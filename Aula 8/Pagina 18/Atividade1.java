public class Atividade1 {

    public static int calculateEdges(int n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        int K7 = calculateEdges(7);
        int K12 = calculateEdges(12);

        System.out.println("Número de arestas em K7: " + K7);
        System.out.println("Número de arestas em K12: " + K12);

        int n = 5; 
        int Kn = calculateEdges(n);
        System.out.println("Número de arestas em K" + n + ": " + Kn);
    }
}
