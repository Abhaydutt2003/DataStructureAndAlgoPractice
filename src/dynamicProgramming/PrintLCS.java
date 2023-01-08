package dynamicProgramming;

public class PrintLCS {
    public static void main(String args[]){
        String s1 = "acbcf";
        String s2 = "abcdaf";
        System.out.print(print(s1,s2));
    }
    public static String print(String s1, String s2){
        int memo[][] = tabulation(s1,s2);
        //now traversal of the memo to make the string...
        String ans = new String();
        int i = s1.length(),j = s2.length();
        while(i>=1 && j>=1){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans = s1.charAt(i-1)+ans;
                i--;j--;
            }else{
                if(memo[i-1][j]>=memo[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return ans;
    }
    private static int[][] tabulation(String s1, String s2){
        int memo[][] = new int [s1.length()+1][s2.length()+1];
        for(int i = 1;i<memo.length;i++){
            for(int j = 1;j<memo[0].length;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1]+1;
                }else{
                    int ans1 =memo[i-1][j];
                    int ans2 = memo[i][j-1];
                    memo[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return memo;
    }
    
}
