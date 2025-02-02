import java.util.ArrayList;

public class BlackCoffee extends Coffee{

    public BlackCoffee(){
        description="Black Coffee prepared by grinded coffee beans with water";
        ingredients.add(new Ingredient("water",0));
        ingredients.add(new Ingredient("Grinded Coffee Beans",30));
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return "BlackCoffee";
    }

    @Override
    public double cost() {
        return 100+30;
    }

    @Override
    public ArrayList<Ingredient> getIngredientsList() {
        return ingredients;
    }
}
