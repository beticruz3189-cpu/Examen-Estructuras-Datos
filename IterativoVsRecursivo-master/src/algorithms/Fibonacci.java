package algorithms;
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class Fibonacci {
   public Fibonacci() {
   }

   public static long iterativo(int var0) {
      if (var0 <= 1) {
         return (long)var0;
      } else {
         long var1 = 0L;
         long var3 = 1L;

         for(int var5 = 2; var5 <= var0; ++var5) {
            long var6 = var1 + var3;
            var1 = var3;
            var3 = var6;
         }

         return var3;
      }
   }

   public static long recursivo(int var0) {
      return var0 <= 1 ? (long)var0 : recursivo(var0 - 1) + recursivo(var0 - 2);
   }
}
