package dato;

public class QuickSortSequential {
    public static void quickSort(int[] array, int left, int right) { // Método de ordenamiento secuencial
        if (left < right) { // Verifica si el subarray es válido
            int pivotIndex = partition(array, left, right); // Particiona el array y obtiene el índice del pivote
            quickSort(array, left, pivotIndex - 1); // Ordena la parte izquierda
            quickSort(array, pivotIndex + 1, right); // Ordena la parte derecha
        }
    }

    private static int partition(int[] array, int left, int right) { // Particiona el subarray alrededor de un pivote
        int pivot = array[right]; // Selecciona el último elemento como pivote
        int i = left - 1; // Índice del elemento más pequeño
        for (int j = left; j < right; j++) { // Itera sobre el subarray
            if (array[j] <= pivot) { // Si el elemento actual es menor o igual al pivote
                i++;
                swap(array, i, j); // Intercambia los elementos
            }
        }
        swap(array, i + 1, right); // Coloca el pivote en la posición correcta
        return i + 1; // Devuelve el índice del pivote
    }

    private static void swap(int[] array, int i, int j) { // Intercambia dos elementos en el array
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

