package org.bcaring.intellj.vue.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.bcaring.intellj.vue.VueFileType;
import org.bcaring.intellj.vue.VueLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * auth : bqxu
 * create_at:  16/6/5.
 * desc:
 * note:
 * 1.
 */
public class VueFile extends PsiFileBase {

    public VueFile(@NotNull FileViewProvider fileViewProvider) {
        super(fileViewProvider, VueLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return VueFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Vue File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

}
