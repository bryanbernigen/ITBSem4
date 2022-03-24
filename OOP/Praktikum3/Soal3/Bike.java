public class Bike extends NonMotorizedVehicle implements Rideable {

    public Bike() {
        super();
        this.name = "Bike";
    }

    public Bike(String name) {
        super();
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    public void ride() {
        System.out.println("Riding a " + this.name);
    }
}
