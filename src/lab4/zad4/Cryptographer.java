package lab4.zad4;


import java.io.*;
import java.util.LinkedList;

public class Cryptographer {
    private static Algorithm algorithm;

    Cryptographer(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public static void cryptFile(String in_, String out_) throws IOException {
        FileReader plik_do_czytania = new FileReader(in_);
        BufferedReader bf = new BufferedReader(plik_do_czytania);
        LinkedList<String> inputList = new LinkedList<>();
        LinkedList<String> outputList = new LinkedList<>();
        String linie;
        while ((linie = bf.readLine()) != null)
            inputList.add(linie);
        bf.close();
        for (String s : inputList)
            outputList.add(algorithm.crypt(s));
        FileWriter fileWriter = new FileWriter(out_);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String s : outputList) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void decryptFile(String in_, String out_) throws IOException {
        FileReader plik_do_czytania = new FileReader(in_);
        BufferedReader bf = new BufferedReader(plik_do_czytania);
        LinkedList<String> inputList = new LinkedList<>();
        LinkedList<String> outputList = new LinkedList<>();
        String linie;
        while ((linie = bf.readLine()) != null)
            inputList.add(linie);

        bf.close();
        for (int j = 0; j < inputList.size(); j++)
            outputList.add(algorithm.decrypt(inputList.get(j)));
        FileWriter fileWriter = new FileWriter(out_);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String s : outputList) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}