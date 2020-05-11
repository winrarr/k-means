import java.util.ArrayList;

public class Cluster {
    public Point centroid;
    public int i;

    ArrayList<Point> points = new ArrayList<>();

    public Cluster(int i) {
        this.i = i;
    }

    public void addPoint(Point p) {
        points.add(p);
        calculateCentroid();
    }

    public void removePoint(Point p) {
        points.remove(p);
        calculateCentroid();
    }

    public void calculateCentroid() {
        double avgX = 0;
        double avgY = 0;
        int i = 0;

        for (Point p : points) {
            avgX += p.x;
            avgY += p.y;
            i++;
        }

        centroid = new Point(avgX / i, avgY / i);
    }

    @Override
    public String toString() {
        return centroid.toString();
    }
}
