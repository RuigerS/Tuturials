package nl.firstact;

public class DepthFilter implements Filter {
    private double minDepth;
    private double maxDepth;
    private String name="Depth";

    public DepthFilter(double minDepth, double maxDepth){
        this.minDepth=minDepth;
        this.maxDepth=maxDepth;
    }
    public DepthFilter(double minDepth, double maxDepth,String name){
        this.minDepth=minDepth;
        this.maxDepth=maxDepth;
        this.name=name;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        if(qe.getDepth()>=minDepth&&qe.getDepth()<=maxDepth){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getMaxDepth() {
        return maxDepth;
    }
    public double getMinDepth() {
        return minDepth;
    }
    public void setMaxDepth(double maxDepth) {
        this.maxDepth = maxDepth;
    }
    public void setMinDepth(double minDepth) {
        this.minDepth = minDepth;
    }
}

