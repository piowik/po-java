package lab2.crossword;

import lab1.JIn;
import lab2.crossword.dictionary.CwDB;


public class Test {
    public static void main(String[] argv) {
        int menu = 0;
        while (menu != 4) {
            System.out.println("1. Wczytaj plik z hasłami");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. Zakończ");
            System.out.print("Wybierz opcje: ");
            menu = JIn.getInteger();
            switch (menu) {
                case 1:
                    System.out.print("Podaj nazwę pliku: ");
                    String filename = JIn.getString();
                    CwDB db = new CwDB(filename);
//                    Entry testWord = db.getEntryAtPos(5);
//                    System.out.print(testWord.getWord() + ":" + testWord.getClue());
                    break;

                case 2:
                    break;

                case 3:
                    break;
            }
        }
    }
}