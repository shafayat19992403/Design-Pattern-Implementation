import java.util.ArrayList;

public class Espresso extends Decorator{
    Coffee coffee;
    String name;
    public Espresso(Coffee coffee){
        this.coffee=coffee;
        name="Espresso";

    }

    @Override
    public String getDescription() {
        return coffee.getDescription()+" and adding dairy cream";
    }

    @Override
    public ArrayList<Ingredient> getIngredientsList() {
        ArrayList<Ingredient> tempIngredients=coffee.getIngredientsList();
        tempIngredients.add(new Ingredient("Dairy Cream",40));
        return tempIngredients;
    }

    @Override
    public double cost() {
        return coffee.cost()+40;
    }

    @Override
    public Coffee getCoffee() {
        return coffee;
    }

    public String getName(){
        return name;
    }
}
