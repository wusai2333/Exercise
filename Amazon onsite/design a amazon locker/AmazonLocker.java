import java.util.Comparator;
import java.util.PriorityQueue;

import AmazonLocker.ZipGraph.Locker;

public class AmazonLocker {
    class ZipGraph {
        int n = N; // how many zips in this area.
        int[][] adjecencyMatrix = new int[n][n]; // represent distance of zips.
        Map<Integer, Integer> = HashMap<>(); // Zipcode -> index in adjacency matrix.
        class Node {
            int zipcode;
            PriorityQueue<Locker> H = new PriorityQueue(new LockerComparator(this)); // Lockers distance smaller than K
            Node(int zipcode) {
                this.zipcode = zipcode;
            }
        }

        class LockerComparator implements Comparator<Locker> {
            Node node;
            LockerComparator(Node node) {
                this.node = node;
            }
            public int compare(Locker l1, Locker l2) {
                if (l1.status == l2.status) {
                    return getDistande(l1.zipcode, node.zipcode) - getDistance(l2.zipcode, node.zipcode);
                }
                return l1.status - l2.status;
            }
        }
        class Locker {
            long lockerNumber;
            int status;   //0 - available, 1 - not available
            int zipcode;
            Locker(long num, boolean status, int zipcode) {
                lockerNumber = num;
                this.status = status;
                this.zipcode = zipcode;
            }

            public getDistance(int zip1, int zip2) {
                return  Math.abs(adjecencyMatrix[zip1][zip2]);
            }
        }

        ZipGraph() {
            //build adjacency matrix here.
        }

        public assignLockerToNode() {
            // putLockers to Node.H when their distance is smaller than K.
        }
    }
    public assignLockerNumber(long orderID) {
        for (Node node : node.H/*all Node with have zip code belongs to customer's zip code*/) {
            lock(node);
            Locker locker = node.H.peek();
            if (locker != null) {
                locker.status = 1;
                assign(locker, orderID);    
                rearrangeHeap H;
                unlock(Node);
                break;  
            }
            unlock(Node);
        }
    }

    public cancelLocker(Locker locker){
        Node node = Traverse DataStructure1 (Graph) to find the zip code;
        lock(node) {
            Locker locker = search(node.H, Locker);
            locker.status = 0;
            rearrange the heap;
        }
    }
}