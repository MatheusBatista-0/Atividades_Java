import java.util.*;

class Grafo {
    private Map<String, List<String>> adjList;

    public Grafo() {
        adjList = new HashMap<>();
    }

    public void addEdge(String v1, String v2) {
        adjList.putIfAbsent(v1, new ArrayList<>());
        adjList.putIfAbsent(v2, new ArrayList<>());
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    public int getDegree(String vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>()).size();
    }

    public int getTotalDegree() {
        int total = 0;
        for (String vertex : adjList.keySet()) {
            total += getDegree(vertex);
        }
        return total;
    }

    public int getNumberOfEdges() {
        int totalEdges = 0;
        for (List<String> neighbors : adjList.values()) {
            totalEdges += neighbors.size();
        }
        return totalEdges / 2; 
    }

    public void printGrafo() {
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (String neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public void printDegrees() {
        for (String vertex : adjList.keySet()) {
            System.out.println("Grau do vértice " + vertex + ": " + getDegree(vertex));
        }
    }
}

public class Atividade1 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.addEdge("6A", "7A");
        grafo.addEdge("6A", "7B");
        grafo.addEdge("6A", "8B");
        grafo.addEdge("6B", "7A");
        grafo.addEdge("6B", "8A");
        grafo.addEdge("6B", "8B");
        grafo.addEdge("7B", "8A");
        grafo.addEdge("7B", "8B");
        grafo.addEdge("8A", "8B");

        System.out.println("Grafo do Campeonato:");
        grafo.printGrafo();

        System.out.println("\nGraus dos vértices:");
        grafo.printDegrees();

        int totalDegree = grafo.getTotalDegree();
        System.out.println("\nSoma de todos os graus: " + totalDegree);

        int numEdges = grafo.getNumberOfEdges();
        System.out.println("Número de arestas: " + numEdges);

        System.out.println("Observação: A soma dos graus dos vértices é igual ao dobro do número de arestas, pois cada aresta é contada duas vezes.");
    }
}
