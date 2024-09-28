package dynamicProgramming;

public class LongestPalindromicSubSeq {
    public static void main(String args[]){
        String s = "leetcode";
        System.out.print(longestPalindromeSubseq(s));
    }
    public static String longestPalindromeSubseq(String s){
        String s1 = s,s2 = new String();
        for(int i = 0;i<s.length();i++){
            s2 = s1.charAt(i)+s2;
        }
        String ans = lcs(s1,s2);
        return ans;
    }
    private static String lcs(String s1, String s2){
        int t[][] = new int[s1.length()+1][s2.length()+1];
        for(int i = 1;i<s1.length()+1;i++){
            for(int j =1;j<s2.length()+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        //now to get the String we traverse the matrix...
        String ans = new String();
        int i = s1.length(),j = s2.length();
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans = s1.charAt(i-1)+ans;
                i--;j--;
            }else if(t[i-1][j]>=t[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        return ans;
    }
    
}
