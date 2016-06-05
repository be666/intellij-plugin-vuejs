package org.bcaring.intellj.vue;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import org.bcaring.intellj.vue.psi.VueProperty;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * auth : bqxu
 * create_at:  16/6/6.
 * desc:
 * note:
 * 1.
 */
public class VueLineMarkerProvider extends RelatedItemLineMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element,
                                            Collection<? super RelatedItemLineMarkerInfo> result) {
        if (element instanceof PsiLiteralExpression) {
            PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
            String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
            if (value != null && value.startsWith("Vue" + ":")) {
                Project project = element.getProject();
                final List<VueProperty> properties = VueUtil.findProperties(project, value.substring(7));
                if (properties.size() > 0) {
                    NavigationGutterIconBuilder<PsiElement> builder =
                            NavigationGutterIconBuilder.create(VueIcons.LOGO).
                                    setTargets(properties).
                                    setTooltipText("Navigate to a vue property");
                    result.add(builder.createLineMarkerInfo(element));
                }
            }
        }
    }

}
