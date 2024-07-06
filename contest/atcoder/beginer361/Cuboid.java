import java.util.Scanner;

public class Main {

    public static boolean doCuboidsIntersect(int ax1, int ay1, int az1, int ax2, int ay2, int az2,
                                             int bx1, int by1, int bz1, int bx2, int by2, int bz2) {
        int minAx = Math.min(ax1, ax2);
        int maxAx = Math.max(ax1, ax2);
        int minAy = Math.min(ay1, ay2);
        int maxAy = Math.max(ay1, ay2);
        int minAz = Math.min(az1, az2);
        int maxAz = Math.max(az1, az2);

        int minBx = Math.min(bx1, bx2);
        int maxBx = Math.max(bx1, bx2);
        int minBy = Math.min(by1, by2);
        int maxBy = Math.max(by1, by2);
        int minBz = Math.min(bz1, bz2);
        int maxBz = Math.max(bz1, bz2);

        boolean xOverlap = Math.max(minAx, minBx) < Math.min(maxAx, maxBx);
        boolean yOverlap = Math.max(minAy, minBy) < Math.min(maxAy, maxBy);
        boolean zOverlap = Math.max(minAz, minBz) < Math.min(maxAz, maxBz);

        return xOverlap && yOverlap && zOverlap;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ax1 = scanner.nextInt();
        int ay1 = scanner.nextInt();
        int az1 = scanner.nextInt();
        int ax2 = scanner.nextInt();
        int ay2 = scanner.nextInt();
        int az2 = scanner.nextInt();

        int bx1 = scanner.nextInt();
        int by1 = scanner.nextInt();
        int bz1 = scanner.nextInt();
        int bx2 = scanner.nextInt();
        int by2 = scanner.nextInt();
        int bz2 = scanner.nextInt();

        if (doCuboidsIntersect(ax1, ay1, az1, ax2, ay2, az2, bx1, by1, bz1, bx2, by2, bz2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
