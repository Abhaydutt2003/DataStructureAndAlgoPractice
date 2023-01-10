package dynamicProgramming;

public class isSubSeq {
    public static void main(String args[]){
        String s ="axc";
        String t = "ahbgdc";
        System.out.print(isSubsequence(s, t));
    }
    public static boolean isSubsequence(String s, String t){
        if(s.length() == 0 || t.length()==0){return false;}
        int length = lcs(s,t);
        return ((length == s.length()) || (length == t.length()))?true:false;
    }
    private static int lcs(String s, String t){
        int dp[][] = new int[s.length()+1][t.length()+1];
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    
}
