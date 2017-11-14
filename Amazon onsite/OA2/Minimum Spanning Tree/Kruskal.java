import java.util.*;

class Graph {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
        Subset() {}
        Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public int V, E;
    public Edge[] edge;
    public Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void Union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            if (subsets[rootX].rank == subsets[rootY].rank)
                subsets[rootX].rank ++;
            subsets[rootY].parent = rootX;
        }
    }

    public void kruskalMST() {
        Edge[] result = new Edge[V]; // this will store the resultant MST
        int e = 0; // An index variable, used for results
        int i = 0; // An index variable, used for sorted edges
        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }
        // Step1. sort all edges in non-descending order of their weight;
        Arrays.sort(edge);

        // Allocating memory for creating V subset:
        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        i = 0;
        while (e < V - 1) {
            Edge next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
        }
    }
}   

public class Kruskal {
    public static void main(String[] args) {
            int V = 4;
            int E = 5;
            Graph graph = new Graph(V, E);
    
            // add edge 0-1
            graph.edge[0].src = 0;
            graph.edge[0].dest = 1;
            graph.edge[0].weight = 10;
     
            // add edge 0-2
            graph.edge[1].src = 0;
            graph.edge[1].dest = 2;
            graph.edge[1].weight = 6;
     
            // add edge 0-3
            graph.edge[2].src = 0;
            graph.edge[2].dest = 3;
            graph.edge[2].weight = 5;
     
            // add edge 1-3
            graph.edge[3].src = 1;
            graph.edge[3].dest = 3;
            graph.edge[3].weight = 15;
     
            // add edge 2-3
            graph.edge[4].src = 2;
            graph.edge[4].dest = 3;
            graph.edge[4].weight = 4;
     
            graph.kruskalMST();
    }
}