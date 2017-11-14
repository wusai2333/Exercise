import java.util.*;
class Process {
    int arrTime;
    int exeTime;
    Process (int arr, int exe) {
        arrTime = arr;
        exeTime = exe;
    }
}
public class RoundRobin {
    public static float Solution(int[] Atime, int[] Etime, int q) {
        // corner case
        if (Atime == null || Etime == null || Atime.length != Etime.length) return 0;
        int length = Atime.length;
        // use queue  to store process type elements
        Queue<Process> queue = new LinkedList<Process>();
        int waitTime = 0, curTime = 0;
        // use a int type variable to track the next process index;
        int index = 0;
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                Process cur = queue.poll();
                // continue summming up the waittime
                waitTime += curTime - cur.arrTime;
                // based on the Round Robin's principle, every round time is limited within the certain quantum q.
                // if exceed time q, the not finished process should be forced to be interrupted, and switch to the next process waiting in the queue.
                curTime += Math.min(cur.exeTime, q);
                // if arrival time of next process is snaller than or equal to the current time
                // means the next process should be pushed into the queue
                for (; index < length && Atime[index] <= curTime; index++) 
                    queue.offer(new Process(Atime[index], Etime[index]));
                // push the interrupted process into the tail of the queue.
                if (cur.exeTime > q)
                    queue.offer(new Process(curTime, cur.exeTime - q));
            } else {
                // push the next proces sinto the queue.
                queue.offer(new Process(Atime[index], Etime[index]));
                // update the curTime/
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / length;
    }

    public static void main(String[] args) {
        int[] Atime = new int[]{0, 1, 4};
        int[] Etime = new int[]{5, 2, 3};
        System.out.print(RoundRobin.Solution(Atime, Etime, 3));
    }
}