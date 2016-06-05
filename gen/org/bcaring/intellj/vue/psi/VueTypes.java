// This is a generated file. Not intended for manual editing.
package org.bcaring.intellj.vue.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.bcaring.intellj.vue.psi.impl.*;

public interface VueTypes {

  IElementType PROPERTY = new VueElementType("PROPERTY");

  IElementType COMMENT = new VueTokenType("COMMENT");
  IElementType CRLF = new VueTokenType("CRLF");
  IElementType KEY = new VueTokenType("KEY");
  IElementType SEPARATOR = new VueTokenType("SEPARATOR");
  IElementType VALUE = new VueTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new VuePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
