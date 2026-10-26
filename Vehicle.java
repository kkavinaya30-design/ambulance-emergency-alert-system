public class Vehicle {

    int vehicleId;
    String vehicleNumber;
    String vehicleType;
    String location;

    double latitude;
    double longitude;

    boolean connected;
    boolean alertReceived;
    boolean movedAside;

    String status;

    public Vehicle(int vehicleId, String vehicleNumber,
                   String vehicleType, String location,
                   boolean connected) {

        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.location = location;
        this.connected = connected;

        // Set initial GPS-like position
        setCoordinates();

        this.alertReceived = false;
        this.movedAside = false;

        status = "NORMAL";
    }

    public void setCoordinates() {

        if (location.equals("Gandhipuram")) {

            latitude = 11.0168;
            longitude = 76.9558;

        } else if (location.equals("Ganapathy")) {

            latitude = 11.0420;
            longitude = 76.9950;

        } else if (location.equals("Peelamedu")) {

            latitude = 11.0300;
            longitude = 77.0000;

        } else if (location.equals("Singanallur")) {

            latitude = 11.0000;
            longitude = 77.0200;
        }
    }

    public void updateLocation(String newLocation) {

        location = newLocation;

        setCoordinates();

        System.out.println(
                vehicleNumber +
                " moved to " +
                newLocation
        );

        System.out.println(
                "GPS Position: " +
                latitude +
                ", " +
                longitude
        );
    }

    public void moveToNextLocation() {

        if (location.equals("Gandhipuram")) {

            updateLocation("Ganapathy");

        } else if (location.equals("Ganapathy")) {

            updateLocation("Peelamedu");

        } else if (location.equals("Peelamedu")) {

            updateLocation("Singanallur");
        }
    }

    public void receiveAlert() {

        alertReceived = true;
        status = "ALERT_RECEIVED";

        System.out.println(
                vehicleNumber +
                " received ambulance alert."
        );

        System.out.println(
                "Vehicle Status: " +
                status
        );
    }

    public void moveAside() {

        if (alertReceived) {

            movedAside = true;
            status = "MOVED_ASIDE";

            System.out.println(
                    vehicleNumber +
                    " moved aside for the ambulance."
            );

            System.out.println(
                    "Vehicle Status: " +
                    status
            );
        }
    }
}