public interface Vehicle {

    interface Rideable {
        public void ride();
    }

    interface NeedFuel {
        public void fillFuel(int amount);
    }

    abstract class MotorizedVehicle {
        protected String name;
        protected int fuel;

        abstract String getName();

        abstract int getFuel();
    }

    abstract class NonMotorizedVehicle {
        protected String name;

        abstract String getName();
    }
}