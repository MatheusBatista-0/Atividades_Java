import java.util.*;

public class Atividade2 {

    private static Map<String, Map<String, Integer>> graph = new HashMap<>();

    public static void main(String[] args) {

        initGraph();

        Map<String, Integer> distances = dijkstra("A");

        distances.forEach((vertex, distance) -> System.out.println("Distância de A para " + vertex + ": " + distance));
    }

    private static void initGraph() {
       
        graph.put("A", Map.of("B", 2, "C", 4));
        graph.put("B", Map.of("A", 2, "C", 1, "D", 7));
        graph.put("C", Map.of("A", 4, "B", 1, "D", 3));
        graph.put("D", Map.of("B", 7, "C", 3));
    }

    private static Map<String, Integer> dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        Set<String> visited = new HashSet<>();

        for (String vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            String currentVertex = currentNode.vertex;

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);
                Map<String, Integer> neighbors = graph.get(currentVertex);

                for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                    String neighborVertex = neighbor.getKey();
                    int edgeWeight = neighbor.getValue();

                    if (!visited.contains(neighborVertex)) {
                        int newDist = distances.get(currentVertex) + edgeWeight;
                        if (newDist < distances.get(neighborVertex)) {
                            distances.put(neighborVertex, newDist);
                            priorityQueue.add(new Node(neighborVertex, newDist));
                        }
                    }
                }
            }
        }

        return distances;
    }

    static class Node {
        String vertex;
        int distance;

        Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
