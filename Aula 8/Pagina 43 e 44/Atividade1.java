import java.util.Arrays;

public class Atividade1 {

    public static void main(String[] args) {
        int[][] grafo = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        
        Atividade1 obj = new Atividade1();
        obj.dijkstra(grafo, 0);
    }

    public void dijkstra(int[][] grafo, int origem) {
        int tamanho = grafo.length;
        int[] dist = new int[tamanho];
        boolean[] visitado = new boolean[tamanho];

        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[origem] = 0; 

        for (int i = 0; i < tamanho - 1; i++) {
            int u = minDistancia(dist, visitado);
            visitado[u] = true;

            for (int v = 0; v < tamanho; v++) {
                if (!visitado[v] && grafo[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }

        imprimirSolucoes(dist);
    }

    public int minDistancia(int[] dist, boolean[] visitado) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visitado[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public void imprimirSolucoes(int[] dist) {
        System.out.println("Vértice \t Distância da Origem");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
