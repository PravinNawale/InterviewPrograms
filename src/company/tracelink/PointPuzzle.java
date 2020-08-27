package company.tracelink;

public class PointPuzzle {
    public static void main(String[] args) {
        int[] input = {5, 6, 6, 4, 11};
        long result = deleteAndEarn(input);
        System.out.println("Result:=>"+result);
    }

    public static long deleteAndEarn(int[] nums) {
        int[] count = new int[10000001];
        for (int x: nums) count[x]++;
        long avoid = 0, using = 0, prev = -1;
        for (int k = 0; k <= 1000000; ++k) {
            if (count[k] > 0) {
                long m = Math.max(avoid, using);
                if (k - 1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                } else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
        }
        return avoid > using ? avoid : using;
    }
}
