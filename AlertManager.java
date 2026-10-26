import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AlertManager {

    HashSet<Integer> alertedVehicles = new HashSet<>();

    Queue<Alert> alertQueue = new LinkedList<>();

    public void addAlert(Vehicle vehicle,
                         int ambulanceId,
                         String ambulanceLocation,
                         String upcomingRoad,
                         int minutesToAmbulance) {

        if (alertedVehicles.contains(vehicle.vehicleId)) {
            return;
        }
        alertedVehicles.add(vehicle.vehicleId);
        Alert alert = new Alert(
                vehicle,
                ambulanceId,
                ambulanceLocation,
                upcomingRoad,
                minutesToAmbulance
        );

        alertQueue.add(alert);

        System.out.println(
                "Alert added to queue: " +
                vehicle.vehicleNumber
        );
    }

    public void processAlerts() {

        while (!alertQueue.isEmpty()) {

            Alert alert = alertQueue.poll();

            alert.displayAlert();
        }
    }
}