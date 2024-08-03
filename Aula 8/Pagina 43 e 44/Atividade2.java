import java.util.Arrays;

public class Atividade2 {

    public static void main(String[] args) {
        int[][] distancias = {
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0}
        };

        Atividade2 obj = new Atividade2();
        obj.dijkstra(distancias, 0); 
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
        System.out.println("Localidade \t Distância da Mercearia");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
