package nl.firstact.RandomText1;

import edu.duke.FileResource;

public class Tester {
    public static void main(String[] args) {
        //MarkovOne mr=new MarkovOne();
        //mr.setTraining("this is a test yes this is a test.");
        //System.out.println(mr.getFollows("t."));
        Tester test=new Tester();
        test.testGetFollowsWithFile();
    }
    public void testGetFollowsWithFile(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne mr=new MarkovOne();
        mr.setTraining(st);
        System.out.println(mr.getFollows("he").size());
    }
}
