import java.util.*;
class Connection implements Comparable<Connection> {
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c) {
        node1 = a;
        node2 = b;
        cost = c;
    }
    public int compareTo(Connection compareEdge) {
        if (this.cost == compareEdge.cost) {
            if (this.node1.equals(compareEdge.node1))
                return this.node2.compareTo(compareEdge.node2);
            return this.node1.compareTo(compareEdge.node1);
        }
        return this.cost - compareEdge.cost;
    }
}
public class ConnectCity {
    static class Subsets {
        Set<String> set;
        Map<String, String> map;
        int count;
        Subsets () {
            count = 0;
            set = new HashSet<>();
            map = new HashMap<>();
        }

        public void makeSet(String s) {
            if (!set.contains(s)) {
                count++;
                set.add(s);
                map.put(s, s);
            }
        }

        public String find(String s) {
            if (!set.contains(s)) return null;
            if (s.equals(map.get(s))) return s;
            String root = this.find(map.get(s));
            map.put(s, root);
            return root;
        }

        public void union(String s, String t) {
            if (!set.contains(s) || !set.contains(t)) return;
            if (s.equals(t)) return;
            count--;
            map.put(s, t);
        }
    }

    public static List<Connection> getMST(List<Connection> connections) {
        Collections.sort(connections);
        Subsets sets = new Subsets();
        List<Connection> result = new ArrayList<>();
        for (Connection con: connections) {
            sets.makeSet(con.node1);
            sets.makeSet(con.node2);
        }

        for (Connection con: connections) {
            String s = sets.find(con.node1);
            String t = sets.find(con.node2);
            System.out.println(s + ", " + t);
            if (!s.equals(t)) {
                sets.union(s, t);
                result.add(con);
                if (sets.count == 1) break;
            }
        }
        if (sets.count == 1) {
            Collections.sort(result, new Comparator<Connection>() {
                public int compare(Connection c1, Connection c2) {
                    if (c1.node1.equals(c2.node1)) 
                        return c1.node2.compareTo(c2.node2);
                    return c1.node1.compareTo(c2.node1);
                }
            });
            return result;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Connection> connections = new ArrayList<>();
        //      connections.add(new Connection("Acity","Bcity",1));
        //      connections.add(new Connection("Acity","Ccity",2));
        //      connections.add(new Connection("Bcity","Ccity",3));
        connections.add(new Connection("A","B",6));
        connections.add(new Connection("B","C",4));
        connections.add(new Connection("C","D",5));
        connections.add(new Connection("D","E",8));
        connections.add(new Connection("E","F",1));
        connections.add(new Connection("B","F",10));
        connections.add(new Connection("E","C",9));
        connections.add(new Connection("F","C",7));
        connections.add(new Connection("B","E",3));
        connections.add(new Connection("A","F",1));
    
        List<Connection> res = ConnectCity.getMST(connections);
        for (Connection c : res){
            System.out.println(c.node1 + " -> " + c.node2 + " cost : " + c.cost);
        }
    }
}
