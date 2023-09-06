package cn.edu.lcu.cs.design_pattern.bridge.fried_chicken;

/**
 * 炒菜，一系列类与子类
 */
public abstract class FriedDish {
    private String name;
    private String description;
    private String ingredients;

    public FriedDish(String name, String description, String ingredients) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
