import java.util.ArrayList;

public class EmergencyManager {

    public void startEmergency(Ambulance ambulance) {

        ambulance.emergencyActive = true;

        System.out.println("\nAMBULANCE EMERGENCY STARTED");
        System.out.println("Ambulance ID: " + ambulance.ambulanceId);
        System.out.println("Driver: " + ambulance.driverName);
        System.out.println("Location: " + ambulance.location);
    }

    public boolean isAlertTime(Ambulance ambulance) {

        return ambulance.emergencyActive &&
               ambulance.minutesToUpcomingRoad <= 5;
    }

    public void processEmergency(
            Ambulance ambulance,
            VehicleManager vehicleManager,
            AlertManager alertManager) {

        while (ambulance.getNextRoad() != null) {

            String upcomingRoad =
                    ambulance.getNextRoad();

            System.out.println(
                    "\nUpcoming Road: " +
                    upcomingRoad
            );

            // Start countdown
            ambulance.minutesToUpcomingRoad = 10;

            while (ambulance.minutesToUpcomingRoad >= 5) {

                System.out.println(
                        "\nAmbulance reaches " +
                        upcomingRoad +
                        " in " +
                        ambulance.minutesToUpcomingRoad +
                        " minutes"
                );

                // Check at 5 minutes
                if (isAlertTime(ambulance)) {

                    System.out.println(
                            "\nChecking vehicles on " +
                            upcomingRoad + "..."
                    );

                    ArrayList<Vehicle> vehiclesOnRoad =
                            vehicleManager.getVehiclesOnRoad(
                                    upcomingRoad
                            );

                    if (vehiclesOnRoad.isEmpty()) {

                        System.out.println(
                                "No connected vehicles found."
                        );
                    }

                    // Calculate distance from ambulance
                    // to each connected vehicle
                    for (Vehicle vehicle : vehiclesOnRoad) {

                        double distance =
                                DistanceCalculator.calculateDistance(
                                        ambulance.latitude,
                                        ambulance.longitude,
                                        vehicle.latitude,
                                        vehicle.longitude
                                );

                        System.out.println(
                                "\nVehicle: " +
                                vehicle.vehicleNumber
                        );

                        System.out.println(
                                "Ambulance GPS: " +
                                ambulance.latitude +
                                ", " +
                                ambulance.longitude
                        );

                        System.out.println(
                                "Vehicle GPS: " +
                                vehicle.latitude +
                                ", " +
                                vehicle.longitude
                        );

                        System.out.println(
                                "Distance: " +
                                String.format("%.2f", distance) +
                                " km"
                        );

                        // Create alert
                        alertManager.addAlert(
                                vehicle,
                                ambulance.ambulanceId,
                                ambulance.location,
                                upcomingRoad,
                                ambulance.minutesToUpcomingRoad
                        );
                    }

                    // Process alerts
                    alertManager.processAlerts();

                    break;
                }

                ambulance.minutesToUpcomingRoad--;

                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    System.out.println(
                            "Countdown interrupted."
                    );
                }
            }

            // Ambulance reaches the next road
            ambulance.moveToNextRoad();

            /*
             * Simulate movement of connected vehicles.
             */
            System.out.println(
                    "\nUpdating connected vehicle locations..."
            );

            for (Vehicle vehicle :
                    vehicleManager.getVehicles()) {

                if (vehicle.connected &&
                    !vehicle.movedAside) {

                    vehicle.moveToNextLocation();
                }
            }
        }
    }

    public void stopEmergency(Ambulance ambulance) {

        ambulance.emergencyActive = false;

        System.out.println(
                "\nAMBULANCE EMERGENCY ENDED"
        );
    }
}