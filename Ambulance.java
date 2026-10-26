import java.util.ArrayList;

public class Ambulance {

    int ambulanceId;
    String driverName;
    String location;

    double latitude;
    double longitude;

    boolean emergencyActive;
    int minutesToUpcomingRoad;

    ArrayList<String> route;
    int currentRouteIndex;

    public Ambulance(int ambulanceId, String driverName, String location) {

        this.ambulanceId = ambulanceId;
        this.driverName = driverName;
        this.location = location;

        this.emergencyActive = false;
        this.minutesToUpcomingRoad = 10;

        route = new ArrayList<>();
        currentRouteIndex = 0;

        setCoordinates();
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

    public void setRoute(ArrayList<String> route) {

        this.route = route;

        currentRouteIndex = 0;

        location = route.get(0);

        setCoordinates();
    }

    public String getNextRoad() {

        if (currentRouteIndex + 1 < route.size()) {

            return route.get(currentRouteIndex + 1);
        }

        return null;
    }

    public void moveToNextRoad() {

        if (currentRouteIndex + 1 < route.size()) {

            currentRouteIndex++;

            location = route.get(currentRouteIndex);

            setCoordinates();

            System.out.println(
                    "\nAMBULANCE MOVED TO: " + location
            );

            System.out.println(
                    "GPS Position: " +
                    latitude + ", " +
                    longitude
            );
        }
    }
}