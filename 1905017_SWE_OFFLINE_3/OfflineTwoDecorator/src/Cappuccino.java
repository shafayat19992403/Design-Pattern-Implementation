import java.util.ArrayList;

public class Cappuccino extends Decorator{
    Coffee coffee;
    String name;
    public Cappuccino(Coffee coffee){
        this.coffee=coffee;
        name="Cappuccino";

    }

    @Override
    public String getDescription() {
        return coffee.getDescription()+" and adding  cinnamon powder ";
    }

    @Override
    public ArrayList<Ingredient> getIngredientsList() {
        ArrayList<Ingredient> tempIngredients=coffee.getIngredientsList();
        tempIngredients.add(new Ingredient("Cinnamon Powder",50));
        return tempIngredients;
    }

    @Override
    public double cost() {
        return coffee.cost()+ 50;
    }

    @Override
    public Coffee getCoffee() {
        return coffee;
    }

    @Override
    public String getName(){
        return name;
    }
}
