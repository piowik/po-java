package lab2.crossword.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CwDB {
    protected LinkedList<Entry> dict = new LinkedList<>();

    public CwDB(String filename) {
        createDB(filename);
    }

    public void add(String word, String clue) {
        dict.add(new Entry(word,clue));
    }

    public Entry get(String word) {
        for (Entry currentEntry : dict) {
            if (currentEntry.getWord().equals(word))
                return currentEntry;
        }
        return new Entry("","");
    }

    public Entry getEntryAtPos(int pos) {
        return dict.get(pos);
    }

    public void remove(String word) {
        dict.remove(get(word));
    }

    public void saveDB(String filename) {

    }

    public int getSize() {
        return dict.size();
    }

    protected void createDB(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader("F:\\IntelliJ\\workspace\\java\\java-po\\src\\lab2\\crossword\\dictionary\\cwdb.txt"))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                add("A", "B");
//                add(line, br.readLine());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
