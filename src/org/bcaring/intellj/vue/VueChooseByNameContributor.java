package org.bcaring.intellj.vue;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import org.bcaring.intellj.vue.psi.VueProperty;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VueChooseByNameContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<VueProperty> properties = VueUtil.findProperties(project);
        List<String> names = new ArrayList<String>(properties.size());
        for (VueProperty property : properties) {
            if (property.getKey() != null && property.getKey().length() > 0) {
                names.add(property.getKey());
            }
        }
        return names.toArray(new String[names.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        // todo include non project items
        List<VueProperty> properties = VueUtil.findProperties(project, name);
        return properties.toArray(new NavigationItem[properties.size()]);
    }
}