public class MetodosOrdenamiento {
    public int[] sortBubbleAva(int[] arreglo){
        int n = arreglo.length;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n-1-i; j++) {
                if(arreglo[j] > arreglo[j+1]){

                    //intercambio
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = aux;         
                }  
            }
        }
        return arreglo;
    }

    public void printArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");            
        }
    }
}
