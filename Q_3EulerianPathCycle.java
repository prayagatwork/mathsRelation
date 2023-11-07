import java.util.*;

public class Q_3EulerianPathCycle {
    static class Graph {
        int v;
        private ArrayList<Integer> adjList[];

        public Graph(int v) {
            this.v = v;
            adjList = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v, int w) {
            adjList[v].add(w);
            adjList[w].add(v);
        }

        public int countOddDegreeVertices() {
            int count = 0;
            for (int i = 0; i < v; i++) {
                if (adjList[i].size() % 2 != 0) {
                    count++;
                }
            }
            return count;
        }

        public boolean isConnected() {
            boolean[] visited = new boolean[v];
            int nonZeroDegreeVertex = -1;

            for (int i = 0; i < v; i++) {
                if (adjList[i].size() > 0) {
                    nonZeroDegreeVertex = i;
                    break;
                }
            }

            if (nonZeroDegreeVertex == -1) {
                return true;
            }

            dfsUtil(nonZeroDegreeVertex, visited);

            for (int i = 0; i < v; i++) {
                if (!visited[i] && adjList[i].size() > 0) {
                    return false;
                }
            }

            return true;
        }

        private void dfsUtil(int v, boolean visited[]) {
            visited[v] = true;
            for (Integer neighbor : adjList[v]) {
                if (!visited[neighbor]) {
                    dfsUtil(neighbor, visited);
                }
            }
        }

        public boolean hasEulerianPathOrCycle() {
            int oddDegreeCount = countOddDegreeVertices();

            if (oddDegreeCount == 0) {
                return true;
            } else if (oddDegreeCount == 2) {
                return true;
            } else {
                return false;
            }
        }

        public List<Integer> findEulerianPath() {
            List<Integer> path = new ArrayList<>();
            int startVertex = 0;

            if (countOddDegreeVertices() == 2) {
                for (int i = 0; i < v; i++) {
                    if (adjList[i].size() % 2 != 0) {
                        startVertex = i;
                        break;
                    }
                }
            }
            
            findEulerianPathUtil(startVertex, path);
            return path;
        }

        private void findEulerianPathUtil(int v, List<Integer> path) {
            while (!adjList[v].isEmpty()) {
                int neighbor = adjList[v].get(0);
                adjList[v].remove(Integer.valueOf(neighbor));
                adjList[neighbor].remove(Integer.valueOf(v));
                findEulerianPathUtil(neighbor, path);
            }
            path.add(v);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        
        // No Eulerian Path/ Cycle
        //Graph graph = new Graph(4);
        // graph.addEdge(0,1);
        // graph.addEdge(1,2);
        // graph.addEdge(2,3);
        // graph.addEdge(3,0);
        // graph.addEdge(0,2);
        // graph.addEdge(1,3);
        
        

        if (graph.isConnected() && graph.hasEulerianPathOrCycle()) {
            System.out.println("Detected Eulerian Path/Cycle: " + graph.findEulerianPath());
        } else {
            System.out.println("No Eulerian Path/Cycle.");
        }
    }
}
