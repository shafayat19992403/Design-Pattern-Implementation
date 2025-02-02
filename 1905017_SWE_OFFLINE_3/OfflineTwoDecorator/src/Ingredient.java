public class Ingredient {
    String name;
    int price;
    public Ingredient(String name,int price){
        this.name=name;
        this.price= price;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "name: "+name+"(price: "+price+")";
    }
}
