import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create managers
        VehicleManager vehicleManager = new VehicleManager();
        AlertManager alertManager = new AlertManager();
        EmergencyManager emergencyManager = new EmergencyManager();

        // Create road network
        Graph graph = new Graph();

        graph.addRoad("Gandhipuram", "Ganapathy");
        graph.addRoad("Ganapathy", "Peelamedu");
        graph.addRoad("Peelamedu", "Singanallur");

        graph.displayRoads();

        // Create ambulance
        Ambulance ambulance =
                new Ambulance(
                        1,
                        "Kumar",
                        "Gandhipuram"
                );

        // Create ambulance route
        ArrayList<String> ambulanceRoute =
                new ArrayList<>();

        ambulanceRoute.add("Gandhipuram");
        ambulanceRoute.add("Ganapathy");
        ambulanceRoute.add("Peelamedu");
        ambulanceRoute.add("Singanallur");

        ambulance.setRoute(ambulanceRoute);

        System.out.println(
                "\nAmbulance Route: " +
                ambulance.route
        );

        // Ask number of vehicles
        System.out.print(
                "\nHow many vehicles do you want to register? "
        );

        int numberOfVehicles = sc.nextInt();
        sc.nextLine();

        // Register vehicles
        for (int i = 1; i <= numberOfVehicles; i++) {

            System.out.println(
                    "\nENTER DETAILS FOR VEHICLE " + i
            );

            // Vehicle number
            String vehicleNumber;

            while (true) {

                System.out.print("Enter vehicle number: ");
                vehicleNumber = sc.nextLine();

                boolean duplicate = false;

                for (Vehicle vehicle :
                        vehicleManager.getVehicles()) {

                    if (vehicle.vehicleNumber
                            .equalsIgnoreCase(vehicleNumber)) {

                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {

                    System.out.println(
                            "Vehicle already registered! " +
                            "Please enter a different vehicle number."
                    );

                } else {

                    break;
                }
            }

            // Vehicle type validation
            String vehicleType;

            while (true) {

                System.out.print(
                        "Enter vehicle type (Car/Bike/Scooter): "
                );

                vehicleType = sc.nextLine();

                if (vehicleType.equalsIgnoreCase("car")) {

                    vehicleType = "Car";
                    break;

                } else if (vehicleType.equalsIgnoreCase("bike")) {

                    vehicleType = "Bike";
                    break;

                } else if (vehicleType.equalsIgnoreCase("scooter")) {

                    vehicleType = "Scooter";
                    break;

                } else {

                    System.out.println(
                            "Invalid vehicle type. " +
                            "Please enter Car, Bike, or Scooter."
                    );
                }
            }

            // Location validation
            String vehicleLocation;

            while (true) {

                System.out.print(
                        "Enter vehicle location " +
                        "(Gandhipuram/Ganapathy/Peelamedu/Singanallur): "
                );

                vehicleLocation = sc.nextLine();

                if (vehicleLocation.equalsIgnoreCase("gandhipuram")) {

                    vehicleLocation = "Gandhipuram";
                    break;

                } else if (vehicleLocation.equalsIgnoreCase("ganapathy")) {

                    vehicleLocation = "Ganapathy";
                    break;

                } else if (vehicleLocation.equalsIgnoreCase("peelamedu")) {

                    vehicleLocation = "Peelamedu";
                    break;

                } else if (vehicleLocation.equalsIgnoreCase("singanallur")) {

                    vehicleLocation = "Singanallur";
                    break;

                } else {

                    System.out.println(
                            "Invalid location. " +
                            "Please enter a valid road."
                    );
                }
            }

            // Connected validation
            boolean connected;

            while (true) {

                System.out.print(
                        "Is the vehicle connected? (true/false): "
                );

                String connectedInput = sc.nextLine();

                if (connectedInput.equalsIgnoreCase("true")) {

                    connected = true;
                    break;

                } else if (connectedInput.equalsIgnoreCase("false")) {

                    connected = false;
                    break;

                } else {

                    System.out.println(
                            "Invalid input. " +
                            "Please enter true or false."
                    );
                }
            }

            // Create vehicle
            Vehicle vehicle =
                    new Vehicle(
                            100 + i,
                            vehicleNumber,
                            vehicleType,
                            vehicleLocation,
                            connected
                    );

            // Register vehicle
            vehicleManager.addVehicle(vehicle);

            System.out.println(
                    "Vehicle " + i +
                    " registered successfully."
            );
        }

        // Start emergency
        emergencyManager.startEmergency(ambulance);

        // Process entire emergency
        emergencyManager.processEmergency(
                ambulance,
                vehicleManager,
                alertManager
        );

        // Final destination
        System.out.println(
                "\nAMBULANCE REACHED FINAL DESTINATION: " +
                ambulance.location
        );

        // End emergency
        emergencyManager.stopEmergency(ambulance);

        sc.close();
    }
}