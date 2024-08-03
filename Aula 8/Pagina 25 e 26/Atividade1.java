import java.util.Arrays;

public class Atividade1 {
    public static void main(String[] args) {
        // Componentes K3 e K7
        int[][] K3 = {
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 0}
        };
        
        int[][] K7 = {
            {0, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 0}
        };
        
        int[][] complementK3 = complement(K3);
        int[][] complementK7 = complement(K7);
        
        System.out.println("Complemento de K3:");
        printMatrix(complementK3);
        
        System.out.println("Complemento de K7:");
        printMatrix(complementK7);
    }

    public static int[][] complement(int[][] matrix) {
        int n = matrix.length;
        int[][] complementMatrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    complementMatrix[i][j] = 1 - matrix[i][j];
                }
            }
        }
        return complementMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
