import java.util.ArrayList;

public abstract class Coffee {
    String description;
    public ArrayList<Ingredient> ingredients;
    public Coffee(){
        this.description="";
        ingredients=new ArrayList<>();
    }
    /* public String getDescription(){
        return description;
    };*/

    public abstract String getDescription();
    public abstract double cost();
    public abstract String getName();

    public abstract ArrayList<Ingredient> getIngredientsList();
}
