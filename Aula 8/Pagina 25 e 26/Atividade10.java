import java.util.ArrayList;
import java.util.List;

public class GrafoRepresentacao {
    public static void main(String[] args) {
        int[][] matrizAdjacencia = {
            {0, 1, 0, 1, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };

        List<List<Integer>> listaAdjacencia = new ArrayList<>();
        
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            List<Integer> adjacentes = new ArrayList<>();
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                if (matrizAdjacencia[i][j] == 1) {
                    adjacentes.add(j);
                }
            }
            listaAdjacencia.add(adjacentes);
        }

        System.out.println("Representação do grafo (Lista de Adjacência):");
        for (int i = 0; i < listaAdjacencia.size(); i++) {
            System.out.println("Vértice " + i + " -> " + listaAdjacencia.get(i));
        }
    }
}
