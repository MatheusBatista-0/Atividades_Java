import java.io.*;
import java.util.*;

public class Atividade {

    public static void main(String[] args) {
        try {
            int[] dados = carregarDados("dados_500mil.txt");

            int[] heapSortDados = Arrays.copyOf(dados, dados.length);
            long inicioHeapSort = System.nanoTime();
            heapSort(heapSortDados);
            long fimHeapSort = System.nanoTime();
            System.out.println("Tempo de execução do Heap Sort: " + (fimHeapSort - inicioHeapSort) + " nanosegundos");

            long inicioBST = System.nanoTime();
            BinarySearchTree bst = new BinarySearchTree();
            for (int num : dados) {
                bst.inserir(num);
            }
            List<Integer> ordenadoBST = bst.emOrdem();
            long fimBST = System.nanoTime();
            System.out.println("Tempo de execução da Árvore Binária (Impressão em-ordem): " + (fimBST - inicioBST) + " nanosegundos");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] carregarDados(String caminhoArquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
        List<Integer> lista = new ArrayList<>();
        String linha;
        while ((linha = reader.readLine()) != null) {
            linha = linha.trim(); 
            if (!linha.isEmpty()) { 
                try {
                    lista.add(Integer.parseInt(linha));
                } catch (NumberFormatException e) {
                    System.err.println("Linha inválida ignorada: " + linha);
                }
            }
        }
        reader.close();
        return lista.stream().mapToInt(i -> i).toArray();
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    static class BinarySearchTree {
        class Nodo {
            int valor;
            Nodo esquerda, direita;

            public Nodo(int item) {
                valor = item;
                esquerda = direita = null;
            }
        }

        Nodo raiz;

        void inserir(int valor) {
            raiz = inserirRec(raiz, valor);
        }

        Nodo inserirRec(Nodo raiz, int valor) {
            if (raiz == null) {
                raiz = new Nodo(valor);
                return raiz;
            }

            if (valor < raiz.valor) {
                raiz.esquerda = inserirRec(raiz.esquerda, valor);
            } else if (valor > raiz.valor) {
                raiz.direita = inserirRec(raiz.direita, valor);
            }

            return raiz;
        }

        List<Integer> emOrdem() {
            List<Integer> resultado = new ArrayList<>();
            emOrdemRec(raiz, resultado);
            return resultado;
        }

        void emOrdemRec(Nodo raiz, List<Integer> resultado) {
            if (raiz != null) {
                emOrdemRec(raiz.esquerda, resultado);
                resultado.add(raiz.valor);
                emOrdemRec(raiz.direita, resultado);
            }
        }
    }
}
