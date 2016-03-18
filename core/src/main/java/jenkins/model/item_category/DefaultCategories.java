package jenkins.model.item_category;

import hudson.Extension;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Extension(ordinal=1000)
public class DefaultCategories extends CategoryProvider {
	public static String DEFAULT_CATEGORY_ID = "jenkins.category.uncategorized";
	public static String STANDALONE_CATEGORY_ID = "jenkins.category.standaloneProjects";
	
	
	@Override
	public List<Category> getCategories() {
		ArrayList<Category> list = new ArrayList<Category>();
		list.add(getStandaloneProjects());
		list.add(getNestedProjects());
		list.add(getUncategorized());
		return list;
	}

	private Category getStandaloneProjects() {
		return new Category(STANDALONE_CATEGORY_ID,
				"Standalone Projects", "Standalone Projects Description", 1, 1,
				new ArrayList<Map<String, Serializable>>());
	}
	
	private Category getNestedProjects() {
		return new Category("jenkins.category.nestedProjects",
				"Nested Projects", "Nested Projects Description", 10, 1,
				new ArrayList<Map<String, Serializable>>());
	}
	
	private Category getUncategorized() {
		return new Category(DEFAULT_CATEGORY_ID,
				"Uncategorized", "Uncategorized Description", 1000, 0,
				new ArrayList<Map<String, Serializable>>());
	}

}
