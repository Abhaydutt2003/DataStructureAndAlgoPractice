package dynamicProgramming;

public class MinimumInsertionPalindrome {
    public static void main(String args[]){
        String s1 = "mbadm";
        int ans = minInsertions(s1);
        System.out.println(ans+" ");
    }
    public static int minInsertions(String s){
        String s1 = s;
        String s2 = new String();
        for(int i = 0;i<s1.length();i++){
            s2 = s1.charAt(i)+s2;
        }
        int longestPalindrome = lcs(s1,s2);
        return s1.length()-longestPalindrome;
    }
    public static int lcs(String s1, String s2){
        int t[][] = new int[s1.length()+1][s2.length()+1];
        for(int i = 1;i<s1.length()+1;i++){
            for(int j =1;j<s2.length()+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }return t[s1.length()][s2.length()];
    }
    
}
