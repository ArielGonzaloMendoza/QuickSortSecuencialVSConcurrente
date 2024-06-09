package test;

import dato.QuickSortSequential; // Importa la clase QuickSortSequential
import dato.QuickSortConcurrent; // Importa la clase QuickSortConcurrent

import java.util.Random; // Importa la clase Random

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 1000, 100000, 1000000, 5000000, 10000000}; // Define diferentes tamaños de arrays para pruebas
        Random random = new Random(); // Crea una instancia de Random

        for (int size : sizes) { // Itera sobre cada tamaño de array
            int[] array = new int[size]; // Crea un array del tamaño especificado
            for (int i = 0; i < size; i++) { // Llena el array con números aleatorios
                array[i] = random.nextInt(size);
            }

            int[] arrayCopy1 = array.clone(); // Clona el array original para el QuickSort secuencial
            int[] arrayCopy2 = array.clone(); // Clona el array original para el QuickSort concurrente

            // Tiempo para QuickSort secuencial
            long startTime = System.nanoTime(); // Marca el inicio del tiempo
            QuickSortSequential.quickSort(arrayCopy1, 0, arrayCopy1.length - 1); // Ejecuta el QuickSort secuencial
            long endTime = System.nanoTime(); // Marca el final del tiempo
            long durationSequential = endTime - startTime; // Calcula la duración

            // Tiempo para QuickSort concurrente
            startTime = System.nanoTime(); // Marca el inicio del tiempo
            QuickSortConcurrent.quickSort(arrayCopy2); // Ejecuta el QuickSort concurrente
            endTime = System.nanoTime(); // Marca el final del tiempo
            long durationConcurrent = endTime - startTime; // Calcula la duración

            System.out.println("Array size: " + size); // Imprime el tamaño del array
            System.out.println("Sequential QuickSort: " + durationSequential + " ns"); // Imprime la duración del QuickSort secuencial
            System.out.println("Concurrent QuickSort: " + durationConcurrent + " ns"); // Imprime la duración del QuickSort concurrente
            System.out.println(); // Línea en blanco para separación visual
        }
    }
}




