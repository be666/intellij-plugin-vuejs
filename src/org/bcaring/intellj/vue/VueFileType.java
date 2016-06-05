package org.bcaring.intellj.vue;


import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * auth : bqxu
 * create_at:  16/6/5.
 * desc:
 * note:
 * 1.
 */
public class VueFileType extends LanguageFileType {

    public static final VueFileType INSTANCE = new VueFileType();

    protected VueFileType() {
        super(VueLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "vue file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "vue language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "vue";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return VueIcons.LOGO;
    }
}
