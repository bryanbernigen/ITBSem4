public class Car extends MotorizedVehicle implements Rideable, NeedFuel {

    public Car() {
        super();
        this.name = "Car";
        this.fuel = 5;
    }

    public Car(String name, int fuel) {
        super();
        this.name = name;
        this.fuel = fuel;
    }

    String getName() {
        return this.name;
    }

    int getFuel() {
        return this.fuel;
    }
  
    public void ride() {
        if (this.fuel > 0) {
            this.fuel--;
            System.out.println("Riding a " + this.name + ", fuel remaining: " + this.fuel);
        } else {
            System.out.println("No fuel, cannot ride");
        }
    }

    public void fillFuel(int amount) {
        this.fuel += amount;
        System.out.println("Filled " + amount + " units of fuel, fuel now: " + this.fuel);
    }
}
