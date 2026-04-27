package ada;
import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int compareTo(Edge e) {
        return this.w - e.w; // sort by weight
    }
}

public class kruskal {

    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootX] = rootY;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int num = sc.nextInt();

        int[][] matrix = new int[num][num];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Convert matrix → edge list
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) { // avoid duplicates
                if (matrix[i][j] != 0 && matrix[i][j] != 99) {
                    edges.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }

        // Sort edges
        Collections.sort(edges);

        int parent[] = new int[num];
        for (int i = 0; i < num; i++)
            parent[i] = i;

        int count = 0;
        int total = 0;

        System.out.println("Edges in MST:");

        for (Edge e : edges) {
            if (count == num - 1)
                break;

            int x = find(parent, e.u);
            int y = find(parent, e.v);

            if (x != y) {
                System.out.println(e.u + " - " + e.v + " -> " + e.w);
                total += e.w;
                union(parent, x, y);
                count++;
            }
        }

        System.out.println("Total cost = " + total);
        sc.close();
    }
}
