package org.bcaring.intellj.vue.psi;

import com.intellij.psi.tree.IElementType;
import org.bcaring.intellj.vue.VueLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * auth : bqxu
 * create_at:  16/6/5.
 * desc:
 * note:
 * 1.
 */
public class VueTokenType extends IElementType {

    public VueTokenType(@NotNull @NonNls String debugName) {
        super(debugName, VueLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "VueTokenType." + super.toString();
    }
}
