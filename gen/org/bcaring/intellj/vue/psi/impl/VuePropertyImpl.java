// This is a generated file. Not intended for manual editing.
package org.bcaring.intellj.vue.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.bcaring.intellj.vue.psi.VueTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.bcaring.intellj.vue.psi.*;

public class VuePropertyImpl extends ASTWrapperPsiElement implements VueProperty {

  public VuePropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VueVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VueVisitor) accept((VueVisitor)visitor);
    else super.accept(visitor);
  }

  public String getKey() {
    return VuePsiImplUtil.getKey(this);
  }

  public String getValue() {
    return VuePsiImplUtil.getValue(this);
  }

}
