package nl.firstact.WordNGram2;

public class WordGram {
    private String[] myWords;
    private int myHash;


    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt " + index);
        }
        return myWords[index];
    }

    public int length() {
        return myWords.length;
    }

    public String toString() {
        String ret = "";
        for (String tmp : myWords) {
            ret += tmp + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if (length() != other.length()) {
            return false;
        }
        if (!toString().equals(other.toString())) {
            return false;
        }
        return true;

    }

    public WordGram shiftAdd(String word) {
        WordGram out = new WordGram(myWords, 0, myWords.length);
        System.arraycopy(myWords,1,out.myWords,0,myWords.length-1);
        out.myWords[myWords.length-1]=word;
        return out;
    }
    @Override
    public int hashCode(){
        return toString().hashCode();
    }

}