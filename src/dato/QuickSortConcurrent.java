package dato;

import java.util.concurrent.RecursiveAction; // Importa la clase RecursiveAction para tareas recursivas
import java.util.concurrent.ForkJoinPool; // Importa la clase ForkJoinPool para paralelismo

public class QuickSortConcurrent extends RecursiveAction { // Hereda de RecursiveAction para tareas paralelas
    private int[] array; // El array a ordenar
    private int left; // Índice izquierdo del subarray
    private int right; // Índice derecho del subarray

    public QuickSortConcurrent(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() { // Método que define la tarea a realizar
        if (left < right) { // Verifica si el subarray es válido
            int pivotIndex = partition(array, left, right); // Particiona el array y obtiene el índice del pivote
            QuickSortConcurrent leftTask = new QuickSortConcurrent(array, left, pivotIndex - 1); // Crea una tarea para la parte izquierda
            QuickSortConcurrent rightTask = new QuickSortConcurrent(array, pivotIndex + 1, right); // Crea una tarea para la parte derecha
            invokeAll(leftTask, rightTask); // Invoca ambas tareas en paralelo
        }
    }

    private int partition(int[] array, int left, int right) { // Particiona el subarray alrededor de un pivote
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

    private void swap(int[] array, int i, int j) { // Intercambia dos elementos en el array
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(int[] array) { // Método estático para iniciar el ordenamiento
        ForkJoinPool pool = new ForkJoinPool(); // Crea un ForkJoinPool
        pool.invoke(new QuickSortConcurrent(array, 0, array.length - 1)); // Inicia la tarea de ordenamiento
    }
}

