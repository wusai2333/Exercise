/**
 * Suppose we have a city of a given length and width which we can represent as a grid(int[][]) and a list of locker points (x and y coordinates), then we can pre-compute the distance of the closet locker to each point in the grid;
 */
public class City {
    public static getLockerDistanceGrid(int cityLength, int cityWidth, List<Point> lockerPositions) {
        int[][] grid = new int[cityLength][cityWidth];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = findClosetManhattanDistance(getCoordinate(row), getCoordinate(col), lockerPositions);
            }
        }
    }

    private int getCoordinate(int zeroBasedPositions) {
        return zeroBasedPositions + 1;
    }

    private static int findClosetManhattanDistance(int x, int y, List<Point> lockerPositions) {
        double closetDistance = Double.MAX_VALUE;
        for (Point p : lockerPositions) {
            double distance = Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
            closestDistance = Math.min(distance, cloestDistance);
            if (cloestDistance == 0) {
                return cloestDistance;
            }
        }
        return cloestDistance;
    } 

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}