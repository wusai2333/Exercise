class Point {
    int x;
    int y;
    public Point (int _x, int _y) {
        x = _x;
        y = _y;
    }
}
public class OverlapRectangles {
    public static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // If one rectangle is on left side of other
        if (l1.x > r2.x || l2.x > r1.x) {
            return false;
        }
        // If one rectangle is above the other
        if (r1.y > l2.y || r2.y > l1.y) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Point topLeft1 = new Point(1, 3);
        Point bottomRight1 = new Point(5, 0);
        Point topLeft2 = new Point(3, 6);
        Point bottomRight2 = new Point(8, 0);
        System.out.print(OverlapRectangles.doOverlap(topLeft1, bottomRight1, topLeft2, bottomRight2));
    }
}