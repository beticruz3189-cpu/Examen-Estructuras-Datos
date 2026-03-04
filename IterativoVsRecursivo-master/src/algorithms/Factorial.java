package algorithms;

public class Factorial {

    // Versión iterativa O(n)
    public static long factorialIterativo(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Versión recursiva O(n)
    public static long factorialRecursivo(int n) {
        if (n == 0)
            return 1;
        return n * factorialRecursivo(n - 1);
    }
}
