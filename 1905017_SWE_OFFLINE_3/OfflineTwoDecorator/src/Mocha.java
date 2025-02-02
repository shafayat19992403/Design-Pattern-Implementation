import java.util.ArrayList;

public class Mocha extends Decorator{
    Coffee coffee;
    String name;



    public Mocha(Coffee coffee){
        this.coffee=coffee;
        name="Mocha";
    }

    @Override
    public String getDescription() {
        return coffee.getDescription()+" and adding chocolate sauce ";
    }

    @Override
    public double cost() {
        return coffee.cost()+60;
    }

    @Override
    public Coffee getCoffee() {
        return coffee;
    }
    public String getName(){
        return name;
    }

    @Override
    public ArrayList<Ingredient> getIngredientsList() {
        ArrayList<Ingredient> tempIngredients=coffee.getIngredientsList();
        tempIngredients.add(new Ingredient("Chocolate Sauce",60));
        return tempIngredients;
    }
}
