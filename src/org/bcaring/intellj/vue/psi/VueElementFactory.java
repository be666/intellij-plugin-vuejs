package org.bcaring.intellj.vue.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import org.bcaring.intellj.vue.VueFileType;

public class VueElementFactory {
    public static VueProperty createProperty(Project project, String name, String value) {
        final VueFile file = createFile(project, name + " = " + value);
        return (VueProperty) file.getFirstChild();
    }

    public static VueProperty createProperty(Project project, String name) {
        final VueFile file = createFile(project, name);
        return (VueProperty) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final VueFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

    public static VueFile createFile(Project project, String text) {
        String name = "dummy.Vue";
        return (VueFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, VueFileType.INSTANCE, text);
    }
}