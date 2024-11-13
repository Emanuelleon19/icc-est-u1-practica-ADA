import java.util.Random;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        MetodosOrdenamiento mO = new MetodosOrdenamiento();

        // Tamaños de los arreglos
        int[] tamaños = {10, 100, 1000, 5000, 10000, 30000};
        
        int[] base = new int[10];
        for (int i = 0; i < base.length; i++) {
            base[i] = random.nextInt(30001);  
        }
        
        int[] arregloPrevio = Arrays.copyOf(base, base.length);  
        
        for (int tamaño : tamaños) {
            int[] arreglo = new int[tamaño];
            
            for (int i = 0; i < arregloPrevio.length; i++) {
                arreglo[i] = arregloPrevio[i];
            }
            
            for (int i = arregloPrevio.length; i < tamaño; i++) {
                arreglo[i] = random.nextInt(30001);  
            }
            
            arregloPrevio = Arrays.copyOf(arreglo, Math.min(10000, tamaño)); 
            
        }
        System.out.println("");
        long startTimeBinaria = System.nanoTime();
        mO.sortBubbleAva(arregloPrevio);
        long endTimeBinaria = System.nanoTime();
        System.out.println("Tiempo de ejecucion: " + (endTimeBinaria - startTimeBinaria) + " nanosegundos");
        System.out.println("");
    }
}


