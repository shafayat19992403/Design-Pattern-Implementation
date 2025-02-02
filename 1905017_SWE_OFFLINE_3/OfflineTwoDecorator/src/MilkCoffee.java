import java.util.ArrayList;

public class MilkCoffee extends Coffee{

    public MilkCoffee(){
        description="Milk Coffee prepared by grinded coffee beans with milk";
        ingredients.add(new Ingredient("Milk",50));
        ingredients.add(new Ingredient("Grinded Coffee Beans",30));
    }

    @Override
    public String getName() {
        return "Milk Coffee";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ArrayList<Ingredient> getIngredientsList() {
        return ingredients;
    }

    @Override
    public double cost() {
        return 100+30+50;
    }
}
