package algorithms;

public class BusquedaLineal {

    // Versión iterativa O(n)
    public static int buscarIterativo(int[] arr, int valor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor)
                return i;
        }
        return -1;
    }

    // Versión recursiva O(n)
    public static int buscarRecursivo(int[] arr, int valor, int indice) {
        if (indice >= arr.length)
            return -1;
        if (arr[indice] == valor)
            return indice;
        return buscarRecursivo(arr, valor, indice + 1);
    }
}