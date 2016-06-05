package org.bcaring.intellj.vue;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import org.bcaring.intellj.vue.psi.VueFile;
import org.bcaring.intellj.vue.psi.VueProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * auth : bqxu
 * create_at:  16/6/6.
 * desc:
 * note:
 * 1.
 */
public class VueUtil {

    public static List<VueProperty> findProperties(Project project, String key) {
        List<VueProperty> result = null;
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, VueFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            VueFile VueFile = (VueFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (VueFile != null) {
                VueProperty[] properties = PsiTreeUtil.getChildrenOfType(VueFile, VueProperty.class);
                if (properties != null) {
                    for (VueProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            if (result == null) {
                                result = new ArrayList<VueProperty>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<VueProperty>emptyList();
    }

    public static List<VueProperty> findProperties(Project project) {
        List<VueProperty> result = new ArrayList<VueProperty>();
        Collection<VirtualFile> virtualFiles =
                FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, VueFileType.INSTANCE,
                        GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            VueFile VueFile = (VueFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (VueFile != null) {
                VueProperty[] properties = PsiTreeUtil.getChildrenOfType(VueFile, VueProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

}
