import java.util.ArrayList;
import java.util.HashMap;

public class Atividade2 {
    
    static class Grafo {
        private HashMap<Character, ArrayList<Character>> adjList;

        public Grafo() {
            adjList = new HashMap<>();
        }

        public void addAresta(char v1, char v2) {
            adjList.computeIfAbsent(v1, k -> new ArrayList<>()).add(v2);
            adjList.computeIfAbsent(v2, k -> new ArrayList<>()).add(v1);
        }

        public void calcularGrau() {
            int somaGraus = 0;
            for (char vertice : adjList.keySet()) {
                int grau = adjList.get(vertice).size();
                System.out.println("Grau do vértice " + vertice + ": " + grau);
                somaGraus += grau;
            }
            System.out.println("Soma de todos os graus: " + somaGraus);
            System.out.println("Número de arestas: " + (somaGraus / 2));
            System.out.println("Observação: A soma dos graus dos vértices é o dobro do número de arestas.");
        }
    }

    public static void main(String[] args) {
        Grafo[] grafos = new Grafo[8];

        for (int i = 0; i < grafos.length; i++) {
            grafos[i] = new Grafo();
        }

        grafos[0].addAresta('A', 'B');
        grafos[0].addAresta('A', 'C');
        grafos[0].addAresta('B', 'D');

        grafos[1].addAresta('A', 'B');
        grafos[1].addAresta('A', 'C');
        grafos[1].addAresta('A', 'D');
        grafos[1].addAresta('B', 'D');

        grafos[2].addAresta('A', 'B');
        grafos[2].addAresta('A', 'C');
        grafos[2].addAresta('A', 'D');
        grafos[2].addAresta('B', 'C');
        grafos[2].addAresta('B', 'D');

        grafos[3].addAresta('A', 'B');
        grafos[3].addAresta('A', 'C');
        grafos[3].addAresta('A', 'D');
        grafos[3].addAresta('B', 'C');
        grafos[3].addAresta('B', 'D');
        grafos[3].addAresta('C', 'D');

        grafos[4].addAresta('A', 'B');
        grafos[4].addAresta('A', 'C');
        grafos[4].addAresta('A', 'D');
        grafos[4].addAresta('A', 'E');
        grafos[4].addAresta('B', 'C');
        grafos[4].addAresta('B', 'D');
        grafos[4].addAresta('B', 'E');
        grafos[4].addAresta('C', 'D');
        grafos[4].addAresta('C', 'E');
        grafos[4].addAresta('D', 'E');

        grafos[5].addAresta('A', 'B');
        grafos[5].addAresta('A', 'C');
        grafos[5].addAresta('A', 'D');
        grafos[5].addAresta('A', 'E');
        grafos[5].addAresta('A', 'F');
        grafos[5].addAresta('B', 'C');
        grafos[5].addAresta('B', 'D');
        grafos[5].addAresta('B', 'E');
        grafos[5].addAresta('B', 'F');
        grafos[5].addAresta('C', 'D');
        grafos[5].addAresta('C', 'E');
        grafos[5].addAresta('C', 'F');
        grafos[5].addAresta('D', 'E');
        grafos[5].addAresta('D', 'F');
        grafos[5].addAresta('E', 'F');

        grafos[6].addAresta('A', 'B');
        grafos[6].addAresta('A', 'C');
        grafos[6].addAresta('A', 'D');
        grafos[6].addAresta('A', 'E');
        grafos[6].addAresta('B', 'C');
        grafos[6].addAresta('B', 'D');
        grafos[6].addAresta('B', 'E');
        grafos[6].addAresta('C', 'D');
        grafos[6].addAresta('C', 'E');
        grafos[6].addAresta('D', 'E');
        grafos[6].addAresta('E', 'A');

        grafos[7].addAresta('A', 'B');
        grafos[7].addAresta('A', 'C');
        grafos[7].addAresta('A', 'D');
        grafos[7].addAresta('A', 'E');
        grafos[7].addAresta('A', 'F');
        grafos[7].addAresta('B', 'C');
        grafos[7].addAresta('B', 'D');
        grafos[7].addAresta('B', 'E');
        grafos[7].addAresta('B', 'F');
        grafos[7].addAresta('C', 'D');
        grafos[7].addAresta('C', 'E');
        grafos[7].addAresta('C', 'F');
        grafos[7].addAresta('D', 'E');
        grafos[7].addAresta('D', 'F');
        grafos[7].addAresta('E', 'F');
        grafos[7].addAresta('F', 'A');

        for (int i = 0; i < grafos.length; i++) {
            System.out.println("Grafo " + (i + 1) + ":");
            grafos[i].calcularGrau();
            System.out.println();
        }
    }
}
