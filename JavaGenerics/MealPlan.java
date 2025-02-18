import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
    void displayMeal();
}

class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public void displayMeal() {
        System.out.println(getMealType() + " Meal: " + mealName);
    }
}

class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public void displayMeal() {
        System.out.println(getMealType() + " Meal: " + mealName);
    }
}

class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public void displayMeal() {
        System.out.println(getMealType() + " Meal: " + mealName);
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public void displayMeal() {
        System.out.println(getMealType() + " Meal: " + mealName);
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(List<T> meals) {
        for (T meal : meals) {
            meal.displayMeal();
        }
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        vegetarianMeals.addMeal(new VegetarianMeal("Grilled Paneer Salad"));
        vegetarianMeals.addMeal(new VegetarianMeal("Vegetable Stir-Fry"));

        Meal<VeganMeal> veganMeals = new Meal<>();
        veganMeals.addMeal(new VeganMeal("Tofu Scramble"));
        veganMeals.addMeal(new VeganMeal("Avocado Toast"));

        Meal<KetoMeal> ketoMeals = new Meal<>();
        ketoMeals.addMeal(new KetoMeal("Grilled Chicken with Avocado"));
        ketoMeals.addMeal(new KetoMeal("Salmon with Asparagus"));

        Meal<HighProteinMeal> highProteinMeals = new Meal<>();
        highProteinMeals.addMeal(new HighProteinMeal("Egg and Turkey Wrap"));
        highProteinMeals.addMeal(new HighProteinMeal("Protein Smoothie"));

        System.out.println("Vegetarian Meal Plan:");
        MealPlanGenerator.generateMealPlan(vegetarianMeals.getMeals());

        System.out.println("\nVegan Meal Plan:");
        MealPlanGenerator.generateMealPlan(veganMeals.getMeals());

        System.out.println("\nKeto Meal Plan:");
        MealPlanGenerator.generateMealPlan(ketoMeals.getMeals());

        System.out.println("\nHigh-Protein Meal Plan:");
        MealPlanGenerator.generateMealPlan(highProteinMeals.getMeals());
    }
}
