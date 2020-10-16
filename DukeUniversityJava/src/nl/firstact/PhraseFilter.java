package nl.firstact;

public class PhraseFilter implements Filter {
    private String where;
    private String phrase;
    private String name="Phrase";

    public PhraseFilter(String where, String phrase) {
        this.where = where;
        this.phrase = phrase;
    }
    public PhraseFilter(String where, String phrase,String name) {
        this.where = where;
        this.phrase = phrase;
        this.name=name;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        switch (where) {
            case "start":
                if(qe.getInfo().startsWith(phrase)){
                    return true;
                }
                break;
            case "any":
                if(qe.getInfo().indexOf(phrase)>=0){
                    return true;
                }
                break;
            case "end":
                if(qe.getInfo().endsWith(phrase)){
                    return true;
                }
                break;
        }
        return false;
    }
    @Override
    public String getName() {
        return name;
    }



    public String getPhrase() {
        return phrase;
    }

    public String getWhere() {
        return where;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
