package greedy;

public class MinimumTimeToMakeRopeColourful {

    public static void main(String[] args) {
        String colors = "abaac";
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(util2(colors, arr));
    }

    public static int util1(String colors, int time[], int i) {
        if (i == colors.length() - 1) {
            return 0;
        }
        if (colors.charAt(i) == colors.charAt(i + 1)) {
            if (time[i + 1] < time[i]) {
                int temp = time[i + 1];
                time[i + 1] = time[i];
                time[i] = temp;
            }
            return util1(colors, time, i + 1) + time[i];
        } else {
            return util1(colors, time, i + 1);
        }
    }

    public static int util2(String colors, int time[]) {
        int timeTaken = 0;
        for (int i = 0; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                if (time[i] > time[i + 1]) {
                    int temp = time[i];
                    time[i] = time[i + 1];
                    time[i + 1] = temp;
                }
                timeTaken += time[i];
            }
        }
        return timeTaken;
    }

}
