package org.bcaring.intellj.vue;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.bcaring.intellj.vue.psi.VueTypes;
import org.jetbrains.annotations.NotNull;

public class VueCompletionContributor extends CompletionContributor {
    public VueCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(VueTypes.VALUE).withLanguage(VueLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("Hello"));
                    }
                }
        );
    }
}
