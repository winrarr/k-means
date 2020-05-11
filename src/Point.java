public class Point {
    public double x;
    public double y;
    public Cluster cluster;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void removeFromCluster() {
        cluster.removePoint(this);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
