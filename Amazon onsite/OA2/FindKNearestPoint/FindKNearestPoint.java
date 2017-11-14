import java.util.*;
class Point {
    double x;
    double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
public class FindKNearestPoint {
    public static Point[] findKNearest(Point[] array, Point origin, int k) {
        if (array == null || origin == null || array.length == 0 || k <= 0) return new Point[0];
        Point[] rvalue = new Point[k];
        int index = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                return (int) (getDistance(b, origin) - getDistance(a, origin));
            }
        });
        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (Point p : pq) {
            rvalue[index++] = p;
        }

        return rvalue;
    }

    private static double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    public static void main(String[] args) {
        Point[] array = new Point[]{new Point(1, 2), new Point(3,4), new Point(5,7), new Point(0.5, 0.5)};
        Point[] res = FindKNearestPoint.findKNearest(array, new Point(0,0), 2);
        for (Point p : res) {
            System.out.println("("+p.x + "," + p.y+")");
        }
    }
}