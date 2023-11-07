import java.util.*;

public class Q_9Swb {
    public static boolean isStronglyConnected(int[][] graph) {
        int V = graph.length;
        for (int v = 0; v < V; v++) {
            boolean[] visited = new boolean[V];
            dfs(graph, v, visited);

            for (boolean isConnected : visited) {
                if (!isConnected) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isWeaklyConnected(int[][] graph) {
        int V = graph.length;
        int[][] undirectedGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                undirectedGraph[i][j] = Math.min(graph[i][j], graph[j][i]);
            }
        }

        return isStronglyConnected(graph) || isStronglyConnected(undirectedGraph);
    }

    public static boolean isUnilaterallyConnected(int[][] graph) {
        int V = graph.length;
        int[][] reverseGraph = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                reverseGraph[i][j] = graph[j][i];
            }
        }

        return isStronglyConnected(graph) && !isStronglyConnected(reverseGraph);
    }

    public static void dfs(int[][] graph, int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };

        System.out.println("Strongly " + isStronglyConnected(graph));
        System.out.println("Weakly " + isWeaklyConnected(graph));
        System.out.println("Unilaterally " + isUnilaterallyConnected(graph));
    }
}
