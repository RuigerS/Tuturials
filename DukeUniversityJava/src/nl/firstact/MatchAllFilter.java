package nl.firstact;

import java.util.ArrayList;

public class MatchAllFilter implements Filter {
    private ArrayList<Filter> listFilters;

    public MatchAllFilter(){
        listFilters=new ArrayList<>();
    }
    public void addFilter(Filter f){
        listFilters.add(f);
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        for (Filter f:listFilters) {
            if(!f.satisfies(qe)){
                return false;
            }
        }
        return true;
    }
    @Override
    public String getName() {
        String name="";
        for (Filter f:listFilters) {
            name+=f.getName()+" ";
        }
        return name;
    }


}
