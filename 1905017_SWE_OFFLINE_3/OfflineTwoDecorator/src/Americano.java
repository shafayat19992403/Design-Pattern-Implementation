import java.util.ArrayList;

public class Americano extends Decorator{
    Coffee coffee;
    String name;
    public Americano(Coffee coffee){
        name="Americano";
        this.coffee=coffee;

    }
    @Override
    public String getDescription() {
        return coffee.getDescription()+" and adding additional grinded beans";
    }

    @Override
    public double cost() {
        return coffee.cost()+30;
    }

    @Override
    public Coffee getCoffee() {
        return coffee;
    }

    @Override
    public ArrayList<Ingredient> getIngredientsList() {
        ArrayList<Ingredient> tempIngredients=coffee.getIngredientsList();
        tempIngredients.add(new Ingredient("Additional Grinded Coffee Beans",30));
        return tempIngredients;
    }

    public String getName(){
        return name;
    }
}
