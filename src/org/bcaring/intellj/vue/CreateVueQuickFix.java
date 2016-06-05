package org.bcaring.intellj.vue;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.indexing.FileBasedIndex;
import org.bcaring.intellj.vue.psi.VueElementFactory;
import org.bcaring.intellj.vue.psi.VueFile;
import org.bcaring.intellj.vue.psi.VueProperty;
import org.bcaring.intellj.vue.psi.VueTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class CreateVueQuickFix extends BaseIntentionAction {
    private String key;

    CreateVueQuickFix(String key) {
        this.key = key;
    }

    @NotNull
    @Override
    public String getText() {
        return "Create property";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "Vue properties";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return true;
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override
            public void run() {
                Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, VueFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
                if (virtualFiles.size() == 1) {
                    createProperty(project, virtualFiles.iterator().next());
                } else {
                    final FileChooserDescriptor descriptor = FileChooserDescriptorFactory.createSingleFileDescriptor(VueFileType.INSTANCE);
                    descriptor.setRoots(project.getBaseDir());
                    final VirtualFile file = FileChooser.chooseFile(descriptor, project, null);
                    if (file != null) {
                        createProperty(project, file);
                    }
                }
            }
        });
    }

    private void createProperty(final Project project, final VirtualFile file) {
        new WriteCommandAction.Simple(project) {
            @Override
            public void run() {
                VueFile VueFile = (VueFile) PsiManager.getInstance(project).findFile(file);
                ASTNode lastChildNode = VueFile.getNode().getLastChildNode();
                if (lastChildNode != null && !lastChildNode.getElementType().equals(VueTypes.CRLF)) {
                    VueFile.getNode().addChild(VueElementFactory.createCRLF(project).getNode());
                }
                // IMPORTANT: change spaces to escaped spaces or the new node will only have the first word for the key
                VueProperty property = VueElementFactory.createProperty(project, key.replaceAll(" ", "\\\\ "), "");
                VueFile.getNode().addChild(property.getNode());
                ((Navigatable) property.getLastChild().getNavigationElement()).navigate(true);
                FileEditorManager.getInstance(project).getSelectedTextEditor().getCaretModel().
                        moveCaretRelatively(2, 0, false, false, false);

                // almost the same thing but manipulating plain text of the document instead of PSI
//                FileEditorManager.getInstance(project).openFile(file, true);
//                final Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
//                final Document document = editor.getDocument();
//                document.insertString(document.getTextLength(), "\n" + key.replaceAll(" ", "\\\\ ") + " = ");
//                editor.getCaretModel().getPrimaryCaret().moveToOffset(document.getTextLength());
            }
        }.execute();
    }
}
