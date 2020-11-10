package com.rutgerspaans.part4;

public class DirectorsFilter implements Filter {
    private String myDirector;

    public DirectorsFilter(String director) {
        myDirector = director;
    }

    @Override
    public boolean satisfies(String id) {
        boolean found=false;
        String[] directors=myDirector.split(",");
        for (String director:directors) {
            if(MovieDatabase.getDirector(id).contains(director)){
                found=true;
            }
        }
        return found;
    }

}
