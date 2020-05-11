import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new Kmeans(new ArrayList<>() {{
            add(new Point(0, 0));
            add(new Point(0, 1));
            add(new Point(0, 2));
            add(new Point(1, 1));
            add(new Point(1, 2));
            add(new Point(2, 2));
            add(new Point(4, 2));
            add(new Point(5, 2));
            add(new Point(5, 3));
            add(new Point(6, 1));
            add(new Point(6, 2));
            add(new Point(6, 3));
            add(new Point(7, 3));
        }}, 2);
    }
}
