import java.util.Scanner;

interface Engine{
    public String getName();
}
class HydrogenFuelCell implements Engine{
    private String name="Hydrogen Fuel Cell";

    @Override
    public String getName(){
        return name;
    }
}

class ElectricEngine implements Engine{
    private String name="Electric Engine";
    @Override
    public String getName(){
        return name;
    }
}

interface DriveTrains{
    public String getName();
}

class RearWheelDriveTrains implements DriveTrains{
    private String name="Rear-Wheel Drive Trains";
    public String getName(){
        return name;
    }
}
class AllWheels implements DriveTrains{
    private String name="All Wheels Drive Trains";
    public String getName(){
        return name;
    }
}
abstract class Car{

    abstract public void setName();

    abstract public void setColor();

    abstract public void setCountry();

    abstract public void setEngine();

    abstract public void setDriveTrains();

    abstract public String getName();

    abstract public String getColor();

    abstract public String getCountry();

    abstract public Engine getEngine();

    abstract public DriveTrains getDriveTrains();
}
class Toyota extends Car{
    private String name;
    private String color;
    private String country;
    private Engine engine;
    private DriveTrains driveTrains;
    @Override
    public void setName(){
        name="Toyota";
    }
    @Override
    public void setColor(){
        color="Red";
    }

    @Override
    public void setCountry(){
        country="Japan";
    }

    @Override
    public void setEngine(){
        engine=new HydrogenFuelCell();
    }

    @Override
    public void setDriveTrains(){
        driveTrains = (DriveTrains) new RearWheelDriveTrains();
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getColor(){
        return color;
    }
    @Override
    public String getCountry(){
        return country;
    }
    @Override
    public Engine getEngine(){
        return engine;
    }
    @Override
    public DriveTrains getDriveTrains(){
        return driveTrains;
    }
    Toyota(){
        setName();
        setColor();
        setCountry();
        setEngine();
        setDriveTrains();
    }
}

class BMW extends Car{
    private String name;
    private String color;
    private String country;
    private Engine engine;
    private DriveTrains driveTrains;
    @Override
    public void setName(){
        name="BMW";
    }
    @Override
    public void setColor(){
        color="Black";
    }

    @Override
    public void setCountry(){
        country="Germany";
    }

    @Override
    public void setEngine(){
        engine=new ElectricEngine();
    }

    @Override
    public void setDriveTrains(){
        driveTrains=new RearWheelDriveTrains();
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getColor(){
        return color;
    }
    @Override
    public String getCountry(){
        return country;
    }
    @Override
    public Engine getEngine(){
        return engine;
    }
    @Override
    public DriveTrains getDriveTrains(){
        return driveTrains;
    }
    BMW(){
        setName();
        setColor();
        setCountry();
        setEngine();
        setDriveTrains();
    }
}

class Tesla extends Car{
    private String name;
    private String color;
    private String country;
    private Engine engine;
    private DriveTrains driveTrains;
    @Override
    public void setName(){
        name="Tesla";
    }
    @Override
    public void setColor(){
        color="White";
    }

    @Override
    public void setCountry(){
        country="US";
    }

    @Override
    public void setEngine(){
        engine=new ElectricEngine();
    }

    @Override
    public void setDriveTrains(){
        driveTrains=new AllWheels();
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getColor(){
        return color;
    }
    @Override
    public String getCountry(){
        return country;
    }
    @Override
    public Engine getEngine(){
        return engine;
    }
    @Override
    public DriveTrains getDriveTrains(){
        return driveTrains;
    }
    Tesla(){
        setName();
        setColor();
        setCountry();
        setEngine();
        setDriveTrains();
    }
}
class CarFactory{
    public Car makeCar(String countryName){
        if(countryName.equalsIgnoreCase("Asia"))
             return new Toyota();
        else if (countryName.equalsIgnoreCase("Europe"))
             return new BMW();
        else if(countryName.equalsIgnoreCase("United States"))
             return new Tesla();

        return null;
    }
}

public class OfflineTwo {
    public static void printCar(Car car){
        System.out.println("Name: "+car.getName());
        System.out.println("Color: "+car.getColor());
        System.out.println("Country: "+car.getCountry());
        System.out.println("Engine: "+car.getEngine().getName());
        System.out.println("Drive Trains: "+car.getDriveTrains().getName());
    }
    public static void main(String[] args) {
    CarFactory carFactory=new CarFactory();
        System.out.println("Choose Region Name(Europe/United States/Asia):");
        Scanner input=new Scanner(System.in);
        String region=input.nextLine();
        Car car=carFactory.makeCar(region);
        if(car==null)
            System.out.println("Wrong Region Input");
        else
            printCar(car);
    }
}
