import java.util.Random;

public class MetodosOrdenamientoBusqueda {

    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(30000) + 1;
        }
        return array;
    }

    // Algoritmo de Ordenamiento por Burbuja con Ajuste
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Algoritmo de Ordenamiento por Selección
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    // Algoritmo de Ordenamiento por Inserción
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Búsqueda binaria iterativa
    public static int binarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Búsqueda binaria recursiva
    public static int binarySearchRecursive(int[] array, int left, int right, int value) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                return binarySearchRecursive(array, mid + 1, right, value);
            } else {
                return binarySearchRecursive(array, left, mid - 1, value);
            }
        }

        return -1;
    }
}

