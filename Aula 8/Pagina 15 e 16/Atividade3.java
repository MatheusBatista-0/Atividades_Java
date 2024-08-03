import java.util.*;

public class Atividade3 {

    static class Grafo {
        private final int numeroVertices;
        private final List<Set<Integer>> adjacencias;

        public Grafo(int numeroVertices) {
            this.numeroVertices = numeroVertices;
            adjacencias = new ArrayList<>();
            for (int i = 0; i < numeroVertices; i++) {
                adjacencias.add(new HashSet<>());
            }
        }

        public void adicionarAresta(int origem, int destino) {
            adjacencias.get(origem).add(destino);
            adjacencias.get(destino).add(origem);
        }

        public int[] obterGrausDosVertices() {
            int[] graus = new int[numeroVertices];
            for (int i = 0; i < numeroVertices; i++) {
                graus[i] = adjacencias.get(i).size();
            }
            return graus;
        }

        public boolean temCicloDeTamanho3() {
            for (int i = 0; i < numeroVertices; i++) {
                for (int vizinho1 : adjacencias.get(i)) {
                    for (int vizinho2 : adjacencias.get(vizinho1)) {
                        if (vizinho2 != i && adjacencias.get(vizinho2).contains(i)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public static boolean verificarIsomorfismo(Grafo grafoA, Grafo grafoB) {
        int[] grausA = grafoA.obterGrausDosVertices();
        int[] grausB = grafoB.obterGrausDosVertices();

        Arrays.sort(grausA);
        Arrays.sort(grausB);

        if (!Arrays.equals(grausA, grausB)) {
            return false; // Os graus dos vértices são diferentes
        }

        boolean ciclo3GrafoA = grafoA.temCicloDeTamanho3();
        boolean ciclo3GrafoB = grafoB.temCicloDeTamanho3();

        return ciclo3GrafoA == ciclo3GrafoB; // Estrutura de ciclo deve ser igual
    }

    public static void main(String[] args) {
        // Definindo Grafo 1.11
        Grafo grafo1 = new Grafo(4);
        grafo1.adicionarAresta(0, 1);
        grafo1.adicionarAresta(0, 2);
        grafo1.adicionarAresta(0, 3);
        grafo1.adicionarAresta(1, 2);
        grafo1.adicionarAresta(1, 3);
        grafo1.adicionarAresta(2, 3);

        // Definindo Grafo 1.12
        Grafo grafo2 = new Grafo(4);
        grafo2.adicionarAresta(0, 1);
        grafo2.adicionarAresta(1, 2);
        grafo2.adicionarAresta(2, 3);
        grafo2.adicionarAresta(3, 0);

        // Verificação de isomorfismo
        if (verificarIsomorfismo(grafo1, grafo2)) {
            System.out.println("Os grafos 1.11 e 1.12 são isomorfos.");
        } else {
            System.out.println("Os grafos 1.11 e 1.12 NÃO são isomorfos.");
        }
    }
}
