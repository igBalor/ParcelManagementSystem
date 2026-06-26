// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class Test {
   public Test() {
   }

   public static void main(String[] var0) {
      if (DBConnection.getConnection() != null) {
         System.out.println("Connected Successfully");
      } else {
         System.out.println("Connection Failed");
      }

   }
}
