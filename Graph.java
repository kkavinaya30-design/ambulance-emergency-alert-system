import java.util.ArrayList;

public class Graph {

    ArrayList<Road> roads = new ArrayList<>();

    public void addRoad(String start, String end) {
        roads.add(new Road(start, end));
    }

    public String getNextRoad(String currentLocation) {

        for (Road road : roads) {

            if (road.start.equals(currentLocation)) {
                return road.end;
            }
        }

        return null;
    }

    public void displayRoads() {

        System.out.println("\nROAD NETWORK:");

        for (Road road : roads) {

            System.out.println(
                road.start + " -> " + road.end
            );
        }
    }
}