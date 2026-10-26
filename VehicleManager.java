import java.util.ArrayList;

public class VehicleManager {

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesOnRoad(String road) {

        ArrayList<Vehicle> vehiclesOnRoad = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.connected &&
                vehicle.location.equals(road)) {

                vehiclesOnRoad.add(vehicle);
            }
        }

        return vehiclesOnRoad;
    }
}