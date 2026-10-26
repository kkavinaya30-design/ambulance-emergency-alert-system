public class Alert {

    Vehicle vehicle;
    int ambulanceId;
    String ambulanceLocation;
    String upcomingRoad;
    int minutesToAmbulance;

    String status;

    public Alert(Vehicle vehicle,
                 int ambulanceId,
                 String ambulanceLocation,
                 String upcomingRoad,
                 int minutesToAmbulance) {

        this.vehicle = vehicle;
        this.ambulanceId = ambulanceId;
        this.ambulanceLocation = ambulanceLocation;
        this.upcomingRoad = upcomingRoad;
        this.minutesToAmbulance = minutesToAmbulance;

        status = "SENT";
    }

    public void displayAlert() {

        vehicle.receiveAlert();

        status = "RECEIVED";

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "AMBULANCE ALERT"
        );

        System.out.println(
                "Ambulance ID: " +
                ambulanceId
        );

        System.out.println(
                "Ambulance Location: " +
                ambulanceLocation
        );

        System.out.println(
                "Upcoming Road: " +
                upcomingRoad
        );

        System.out.println(
                "Vehicle: " +
                vehicle.vehicleNumber
        );

        System.out.println(
                "Type: " +
                vehicle.vehicleType
        );

        System.out.println(
                "Current Road: " +
                vehicle.location
        );

        System.out.println(
                "Time to Ambulance: " +
                minutesToAmbulance +
                " minutes"
        );

        System.out.println(
                "ACTION: PLEASE MOVE ASIDE"
        );

        vehicle.moveAside();

        status = "RESPONDED";

        System.out.println(
                "Alert Status: " +
                status
        );

        System.out.println(
                "================================"
        );
    }
}