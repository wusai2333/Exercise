import java.util.PriorityQueue;
import java.util.Comparator;
class Process {
    int arrTime;
    int exeTime;
    Process (int arr, int exe) {
        arrTime = arr;
        exeTime = exe;
    }
}
public class ShortestJobFirst {
    public static float Solution (int[] req, int[] dur) {
        if (req == null || dur == null || req.length != dur.length) 
            return 0;
        int index = 0, length = req.length;
        int waitTime = 0, curTime = 0;
        PriorityQueue<Process> pq = new PriorityQueue<Process>(length, new Comparator<Process>() {
            public int compare(Process p1, Process p2) {
                if (p1.exeTime == p2.exeTime)
                    return p1.arrTime - p2.arrTime;
                return p1.exeTime - p2.exeTime;
            }
        });
        while (!pq.isEmpty() || index < length) {
            if (!pq.isEmpty()) {
                Process cur = pq.poll();
                waitTime += curTime - cur.arrTime;
                curTime += cur.exeTime;
                while (index < length && curTime >= req[index])
                    pq.offer(new Process(req[index], dur[index++]));
            } else {
                pq.offer(new Process(req[index], dur[index]));
                curTime = req[index++];
            }
        }
        return (float) waitTime / length;
    }

    public static float shortestJobFirst(int[] arrTime, int[] exeTime) {
        if (arrTime == null || exeTime == null || arrTime.length != exeTime.length) 
            return 0;
        int index = 0, curTime = 0, waitTime = 0, length = arrTime.length;
        PriorityQueue<Process> pq = new PriorityQueue<Process>(length, new Comparator<Process>() {
            public int compare(Process p1, Process p2) {
                if (p1.exeTime == p2.exeTime) 
                    return p1.arrTime - p2.arrTime;
                return p1.exeTime - p2.exeTime;
            }
        });
        while (!pq.isEmpty() || index < length) {
            if (!pq.isEmpty()) {
                Process cur = pq.poll();
                waitTime += curTime - cur.arrTime;
                curTime += cur.exeTime;
                while (index < length && arrTime[index] <= curTime) {
                    pq.offer(new Process(arrTime[index], exeTime[index++]));
                }
            } else {
                pq.offer(new Process(arrTime[index], exeTime[index]));
                curTime = arrTime[index++];
            }
        }

        return (float) waitTime / length;
    }

    public static void main(String[] args) {
        int[] req = new int[]{0, 1, 3, 9};
        int[] dur = new int[]{2, 1, 7, 5};
        System.out.print(ShortestJobFirst.Solution(req, dur)+ " ");
        System.out.print(ShortestJobFirst.shortestJobFirst(req, dur));
    }
}