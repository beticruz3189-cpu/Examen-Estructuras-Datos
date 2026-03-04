package algorithms;

public class OrdenamientoBurbuja {

    // Versión iterativa O(n^2)
    public static void burbujaIterativo(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Versión recursiva O(n^2)
    public static void burbujaRecursivo(int[] arr, int n) {
        if (n == 1)
            return;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        burbujaRecursivo(arr, n - 1);
    }
}
