import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static Map<Integer, int[]> arraysMap = new HashMap<>();
    private static boolean isSorted = false; 

    public static void generateArrays() {
        int[] baseArray = MetodosOrdenamientoBusqueda.generateArray(30000); 
                                                                            
        arraysMap.put(30000, baseArray);

        int[] sizes = { 10, 100, 1000, 5000, 10000 };
        for (int size : sizes) {
            arraysMap.put(size, Arrays.copyOf(baseArray, size));
                                                                 
        }
    }

    public static void measureSortTime(int[] array, String methodName) {
        int[] copy = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime(); 

        switch (methodName) {
            case "Bubble":
                MetodosOrdenamientoBusqueda.bubbleSort(copy);
                break;
            case "Selection":
                MetodosOrdenamientoBusqueda.selectionSort(copy);
                break;
            case "Insertion":
                MetodosOrdenamientoBusqueda.insertionSort(copy);
                break;
        }

        long endTime = System.nanoTime(); 
        long duration = endTime - startTime; 
        double durationInSeconds = duration / 1e9; 

        System.out.printf("Método %s: Tiempo para %d elementos es %.9f segundos\n", methodName, array.length,
                durationInSeconds);
    }

    public static void measureBinarySearch(int[] array, int value, boolean recursive) {
        long startTime = System.nanoTime(); 
        int result = recursive
                ? MetodosOrdenamientoBusqueda.binarySearchRecursive(array, 0, array.length - 1, value)
                : MetodosOrdenamientoBusqueda.binarySearch(array, value);
        long endTime = System.nanoTime(); 

        long duration = endTime - startTime; 
        double durationInSeconds = duration / 1e9; 

        if (result == -1) {
            System.out.printf(
                    "Búsqueda Binaria %s: El valor %d no se encuentra en el arreglo (Tiempo: %.9f segundos)\n",
                    (recursive ? "Recursiva" : "Normal"), value, durationInSeconds);
        } else {
            System.out.printf(
                    "Búsqueda Binaria %s: El valor %d se encuentra en la posición %d (Tiempo: %.9f segundos)\n",
                    (recursive ? "Recursiva" : "Normal"), value, result, durationInSeconds);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Generar Arreglos aleatorios con diferente tamaño");
            System.out.println("2. Ordenar por los 3 métodos");
            System.out.println("3. Buscar valores (búsqueda binaria normal y recursiva)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    generateArrays();
                    isSorted = false;
                    System.out.println("Se han generado los arreglos para los tamaños especificados.");

                    if (arraysMap.containsKey(10)) {
                        System.out.println("Contenido del arreglo de tamaño 10: " + Arrays.toString(arraysMap.get(10)));
                    }

                    break;
                case 2:
                    if (arraysMap.isEmpty()) {
                        System.out.println("Primero genere los arreglos usando la opción 1.");
                    } else {
                        Integer[] sortedSizes = arraysMap.keySet().toArray(new Integer[0]);
                        Arrays.sort(sortedSizes);

                        for (int size : sortedSizes) {
                            int[] originalArray = arraysMap.get(size);

                            System.out.println("\nOrdenando arreglo de tamaño " + size + ":");

                            int[] bubbleArray = Arrays.copyOf(originalArray, originalArray.length);
                            int[] selectionArray = Arrays.copyOf(originalArray, originalArray.length);
                            int[] insertionArray = Arrays.copyOf(originalArray, originalArray.length);

                            measureSortTime(bubbleArray, "Bubble");
                            measureSortTime(selectionArray, "Selection");
                            measureSortTime(insertionArray, "Insertion");
                        }
                        isSorted = true;
                    }
                    break;

                case 3:
                    if (arraysMap.isEmpty()) {
                        System.out.println("Primero genere los arreglos usando la opción 1.");
                    } else if (!isSorted) {
                        System.out.println("Primero debe ordenar los arreglos usando la opción 2.");
                    } else {
                        System.out.print("Ingrese el valor a buscar: ");
                        int value = scanner.nextInt();

                        Integer[] sortedSizes = arraysMap.keySet().toArray(new Integer[0]);
                        Arrays.sort(sortedSizes);

                        for (int size : sortedSizes) {
                            int[] array = arraysMap.get(size);

                            Arrays.sort(array); 

                            System.out.println("\nBúsqueda en arreglo de tamaño " + size + ":");
                            measureBinarySearch(array, value, false);
                            measureBinarySearch(array, value, true);
                        }
                    }
                    break;

                case 4:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
