import java.util.Scanner;

public class GraphAdjMatrix {
    private int[][] adjMatrix;
    private int numVertices;

    // Constructor
    public GraphAdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add edge
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1; // for undirected graph
    }

    // Remove edge
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    // Print the adjacency matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        GraphAdjMatrix graph = new GraphAdjMatrix(vertices);

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter each edge as: u v");
        for (int k = 0; k < edges; k++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.printMatrix();
        sc.close();
    }
}
