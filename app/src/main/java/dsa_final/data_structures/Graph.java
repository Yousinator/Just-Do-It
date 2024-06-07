package dsa_final.data_structures;

import java.util.Arrays;

public class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        // Initialize all elements of the matrix to infinity (indicating no edge)
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("∞ \t");
                } else {
                    System.out.print(adjacencyMatrix[i][j] + " \t");
                }
            }
            System.out.println();
        }
    }

    public void dijkstra(int startVertex) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = findMinDistance(distances, visited);
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && adjacencyMatrix[u][v] != Integer.MAX_VALUE &&
                        distances[u] != Integer.MAX_VALUE && distances[u] + adjacencyMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjacencyMatrix[u][v];
                }
            }
        }

        printSolution(distances);
    }

    public void bellmanFord(int startVertex) {
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 1; i < numVertices; i++) {
            for (int u = 0; u < numVertices; u++) {
                for (int v = 0; v < numVertices; v++) {
                    if (adjacencyMatrix[u][v] != Integer.MAX_VALUE && distances[u] != Integer.MAX_VALUE) {
                        if (distances[u] + adjacencyMatrix[u][v] < distances[v]) {
                            distances[v] = distances[u] + adjacencyMatrix[u][v];
                        }
                    }
                }
            }
        }

        for (int u = 0; u < numVertices; u++) {
            for (int v = 0; v < numVertices; v++) {
                if (adjacencyMatrix[u][v] != Integer.MAX_VALUE && distances[u] != Integer.MAX_VALUE) {
                    if (distances[u] + adjacencyMatrix[u][v] < distances[v]) {
                        System.out.println("Graph contains a negative-weight cycle");
                        return;
                    }
                }
            }
        }

        printSolution(distances);
    }

    private int findMinDistance(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printSolution(int[] distances) {
        System.out.println("Vertex\t Distance from Source");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + "\t\t" + (distances[i] == Integer.MAX_VALUE ? "∞" : distances[i]));
        }
    }

}
