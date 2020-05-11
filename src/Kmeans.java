import java.util.ArrayList;

public class Kmeans {

    public Kmeans(ArrayList<Point> points, int k) {
        Cluster[] clusters = new Cluster[k];

        System.out.println("Initialising clusters");

        int i = 0;
        while (i < k) {
            Point p = points.get(i);
            clusters[i] = new Cluster(i);
            clusters[i].addPoint(p);
            points.get(i).cluster = clusters[i];
            i++;
        }
        while (i < points.size()) {
            Point p = points.get(i);
            double minDist = Integer.MAX_VALUE;
            int minDistCluster = 0;
            for (Cluster c : clusters) {
                double dist = dist(c.centroid, p);
                if (dist < minDist) {
                    minDist = dist;
                    minDistCluster = c.i;
                }
            }
            p.cluster = clusters[minDistCluster];
            clusters[minDistCluster].addPoint(p);
            i++;
        }

        boolean changed = true;

        int j = 1;

        while (changed) {
            changed = false;
            System.out.println();
            System.out.println("Finding better fit, iteration: " + j);

            for (Point p : points) {
                int oldCluster = p.cluster.i;
                double minDist = Integer.MAX_VALUE;
                int minDistCluster = 0;

                for (Cluster c : clusters) {
                    double dist = dist(c.centroid, p);
                    System.out.println("Distance between " + p + " and cluster " + c.i + ": " + dist);
                    if (dist < minDist) {
                        minDist = dist;
                        minDistCluster = c.i;
                    }
                }
                if (minDistCluster != oldCluster) {
                    changed = true;
                    p.cluster = clusters[minDistCluster];
                    clusters[oldCluster].removePoint(p);
                    clusters[minDistCluster].addPoint(p);
                    System.out.println(p + ": " + oldCluster + " -> " + minDistCluster);
                }
            }
        }

        System.out.println();
        System.out.println("Final clusters:");
        for (Cluster c : clusters) {
            System.out.println(c + "   ---   " + c.points);
        }
    }

    private double dist(Point a, Point b) {
        return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
    }
}
