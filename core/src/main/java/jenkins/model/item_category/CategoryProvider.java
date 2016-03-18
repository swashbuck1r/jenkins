package jenkins.model.item_category;

import hudson.Extension;
import hudson.ExtensionList;
import hudson.ExtensionPoint;
import hudson.model.TopLevelItemDescriptor;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import java.util.Collection;
import java.util.List;

import jenkins.slaves.systemInfo.SlaveSystemInfo;

/**
 * A mapper of {@link ItemCategory}s to {@link hudson.model.Item}s.
 *
 * @since TODO
 */
public abstract class CategoryProvider implements ExtensionPoint {

    @CheckForNull
    public abstract List<Category> getCategories();
    
    public static ExtensionList<CategoryProvider> all() {
        return ExtensionList.lookup(CategoryProvider.class);
    }
}
