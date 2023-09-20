package backTracking;

public class SplittingAString {

    public static void main(String[] args) {
        System.out.print(util1("64424509442147483647"));
    }

    public static boolean util1(String str) {
        return helper(str.toCharArray(), 0, -1,0);
    }

    public static boolean helper(char arr[], int index, long prev, int steps) {
        if (index == arr.length) {
            if(steps>1){
                return true;
            }else{
                return false;
            }
        }
        long current = 0;
        for (int i = index; i < arr.length; i++) {
            current = (current * 10) + (arr[i] - 48);
            if (current == prev-1 || prev == -1) {
                boolean smallAns = helper(arr, i + 1, current,steps+1);
                if (smallAns) {
                    return true;
                }
            }
        }
        return false;
    }

}
