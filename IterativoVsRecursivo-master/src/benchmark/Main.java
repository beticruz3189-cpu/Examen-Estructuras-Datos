package benchmark;

import algorithms.*;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("tiempos.csv")) {
            writer.write("Algoritmo,Version,n,Tiempo_ms\n");
            Medidor.imprimirEncabezado();

            // Factorial
            for (int n : new int[] { 5, 10, 15, 20, 25, 30 }) {
                double tIter = Medidor.medir(() -> Factorial.factorialIterativo(n));
                double tRec = Medidor.medir(() -> Factorial.factorialRecursivo(n));
                Medidor.imprimirFila("Factorial", "Iterativo", n, tIter);
                Medidor.imprimirFila("Factorial", "Recursivo", n, tRec);
                writer.write("Factorial,Iterativo," + n + "," + tIter + "\n");
                writer.write("Factorial,Recursivo," + n + "," + tRec + "\n");
            }

            // Fibonacci
            for (int n : new int[] { 5, 10, 15, 20, 25, 30 }) {
                double tIter = Medidor.medir(() -> Fibonacci.iterativo(n));
                double tRec = Medidor.medir(() -> Fibonacci.recursivo(n));
                Medidor.imprimirFila("Fibonacci", "Iterativo", n, tIter);
                Medidor.imprimirFila("Fibonacci", "Recursivo", n, tRec);
                writer.write("Fibonacci,Iterativo," + n + "," + tIter + "\n");
                writer.write("Fibonacci,Recursivo," + n + "," + tRec + "\n");
            }

            // Búsqueda Lineal
            int[] arr = new int[10000];
            for (int i = 0; i < arr.length; i++)
                arr[i] = i;
            for (int n : new int[] { 100, 500, 1000, 5000, 10000 }) {
                double tIter = Medidor.medir(() -> BusquedaLineal.buscarIterativo(arr, n));
                double tRec = Medidor.medir(() -> BusquedaLineal.buscarRecursivo(arr, n, 0));
                Medidor.imprimirFila("BusquedaLineal", "Iterativo", n, tIter);
                Medidor.imprimirFila("BusquedaLineal", "Recursivo", n, tRec);
                writer.write("BusquedaLineal,Iterativo," + n + "," + tIter + "\n");
                writer.write("BusquedaLineal,Recursivo," + n + "," + tRec + "\n");
            }

            // Burbuja
            for (int n : new int[] { 100, 500, 1000, 5000, 10000 }) {
                int[] datos = generarDatos(n);
                double tIter = Medidor.medir(() -> OrdenamientoBurbuja.burbujaIterativo(datos.clone()));
                double tRec = Medidor.medir(() -> OrdenamientoBurbuja.burbujaRecursivo(datos.clone(), datos.length));
                Medidor.imprimirFila("Burbuja", "Iterativo", n, tIter);
                Medidor.imprimirFila("Burbuja", "Recursivo", n, tRec);
                writer.write("Burbuja,Iterativo," + n + "," + tIter + "\n");
                writer.write("Burbuja,Recursivo," + n + "," + tRec + "\n");
            }

            System.out.println("\n✓ Resultados guardados en resultados/tiempos.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generarDatos(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * n);
        return arr;
    }
}