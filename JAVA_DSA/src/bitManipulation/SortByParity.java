package bitManipulation;

public class SortByParity {

    public static void main(String[] args) {
        int arr[] = {3,1,2,4};
        arr = util1(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    //actually sorting by parity
    public static int[] util1(int[] arr) {
        int ans[] = new int[arr.length];
        int i = 0;
        int j = ans.length - 1;
        for (int a = 0; a < arr.length; a++) {
            if (oddParity(arr[a])) {
                ans[j--] = arr[a];
            } else {
                ans[i++] = arr[a];
            }
        }
        return ans;
    }

    public static boolean oddParity(int n) {
        boolean oddParity = false;
        while (n > 0) {
            oddParity = !oddParity;
            n &= (n - 1);
        }
        return oddParity;
    }

}
