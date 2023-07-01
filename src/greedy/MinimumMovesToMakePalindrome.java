package greedy;

public class MinimumMovesToMakePalindrome {

    public static void main(String args[]) {
        String str = "letelt";
        System.out.print(util1(str));
    }

    public static int util1(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        int ans = 0;
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else {
                int foundAt = j;
                while (arr[i] != arr[foundAt]) {
                    foundAt--;
                }
                if (foundAt == i) {
                    swap(arr, foundAt, foundAt + 1);
                    ans++;
                } else {
                    while (foundAt < j) {
                        swap(arr, foundAt, foundAt + 1);
                        foundAt++;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
