public class DistanceCalculator {

    public static double calculateDistance(
            double lat1, double lon1,
            double lat2, double lon2) {

        double earthRadius = 6371;

        double latDifference =
                Math.toRadians(lat2 - lat1);

        double lonDifference =
                Math.toRadians(lon2 - lon1);

        double a =
                Math.sin(latDifference / 2)
                * Math.sin(latDifference / 2)
                +
                Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDifference / 2)
                * Math.sin(lonDifference / 2);

        double c =
                2 * Math.atan2(
                        Math.sqrt(a),
                        Math.sqrt(1 - a)
                );

        return earthRadius * c;
    }
}