import java.util.Arrays;

class Container {
    public double first;
    public double second;
    public Container() {}
    public Container(double f, double s) {
        first = f;
        second = s;
    }
}
public class ClosestTwoSum {
    public static Container findOptimalWeights(double capacity, double[] weights, int numOfContainers) {
        if (weights == null || capacity <= 0)
            return new Container();
        Arrays.sort(weights);
        int minPos = 0, maxPos = weights.length;
        int left = 0, right = weights.length - 1;
        double prevMax = 0.0;
        while (left < right) {
            if (weights[left] + weights[right] == capacity) {
                return new Container(weights[left], weights[right]);
            }
            if (weights[left] + weights[right] < capacity) {
                if (weights[left] + weights[right] > prevMax) {
                    minPos = left;
                    maxPos = right;
                    prevMax = weights[left] + weights[right];
                }
                left++;
            } else if (weights[left] + weights[right] >= capacity) {
                right--;
            } 
        }
        return new Container(weights[minPos], weights[maxPos]);
    }

    public static void main(String[] args) {
        double capacity = 13.2;
        double[] weights = new double[]{1.0, 4.0, 12.0, 13.0, 2.3, 11.4, 112, 9.8, 5.9, 6.9, 7.8};
        Container container = ClosestTwoSum.findOptimalWeights(capacity, weights, weights.length);
        System.out.print("The closest pair is " + container.first + " and " + container.second);
    }
}
