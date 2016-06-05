package org.bcaring.intellj.vue.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.*;
import org.bcaring.intellj.vue.VueIcons;
import org.bcaring.intellj.vue.psi.VueElementFactory;
import org.bcaring.intellj.vue.psi.VueProperty;
import org.bcaring.intellj.vue.psi.VueTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * auth : bqxu
 * create_at:  16/6/6.
 * desc:
 * note:
 * 1.
 */
public class VuePsiImplUtil {

    public static String getKey(VueProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(VueTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to Vue spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(VueProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(VueTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(VueProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(VueProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(VueTypes.KEY);
        if (keyNode != null) {
            VueProperty property = VueElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(VueProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(VueTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final VueProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getKey();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return VueIcons.LOGO;
            }
        };
    }

}
