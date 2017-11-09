package lab4.zad4;


import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        Cryptographer cryptographer = new Cryptographer(new Polibiusz());
        String dir = "F:\\IntelliJ\\workspace\\java\\java-po\\src\\lab4\\zad4\\";
        String filename = dir + "test.txt";
        String filename_out = dir + "output.txt";
        String filename_decrypt = dir + "decrypt.txt";
        try {
            cryptographer.cryptFile(filename, filename_out);
            cryptographer.decryptFile(filename_out, filename_decrypt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("koniec");

    }
}
