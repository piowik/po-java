package lab2.crossword.dictionary;

public class Entry {
    private String word;
    private String clue;
    public Entry(String _word, String _clue) {
        word = _word;
        clue = _clue;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }
}
