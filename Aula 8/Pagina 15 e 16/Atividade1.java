import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Atividade1 {

    private static Map<Integer, Set<Integer>> graph1 = new HashMap<>();
    private static Map<Integer, Set<Integer>> graph2 = new HashMap<>();

    private static Map<Integer, Integer> correspondence = new HashMap<>();

    public static void main(String[] args) {
        initGraphs();
        initCorrespondence();

        if (checkIsomorphism()) {
            System.out.println("A correspondência proposta preserva o isomorfismo.");
        } else {
            System.out.println("A correspondência proposta NÃO preserva o isomorfismo.");
        }
    }

    private static void initGraphs() {
        graph1.put(1, Set.of(2, 3));
        graph1.put(2, Set.of(1, 4));
        graph1.put(3, Set.of(1, 4));
        graph1.put(4, Set.of(2, 3));

        graph2.put(1, Set.of(2, 3));
        graph2.put(2, Set.of(1, 4));
        graph2.put(3, Set.of(1, 4));
        graph2.put(4, Set.of(2, 3));
    }

    private static void initCorrespondence() {
        correspondence.put(1, 1);
        correspondence.put(2, 2);
        correspondence.put(3, 3);
        correspondence.put(4, 4);
    }

    private static boolean checkIsomorphism() {
        for (Integer v1 : graph1.keySet()) {
            Integer correspondingVertex = correspondence.get(v1);
            if (correspondingVertex == null) {
                return false;
            }
            Set<Integer> neighbors1 = graph1.get(v1);
            Set<Integer> neighbors2 = graph2.get(correspondingVertex);
            
            Set<Integer> mappedNeighbors1 = new HashSet<>();
            for (Integer neighbor : neighbors1) {
                Integer mappedNeighbor = correspondence.get(neighbor);
                if (mappedNeighbor != null) {
                    mappedNeighbors1.add(mappedNeighbor);
                }
            }

            if (!mappedNeighbors1.equals(neighbors2)) {
                return false;
            }
        }
        return true;
    }
}
