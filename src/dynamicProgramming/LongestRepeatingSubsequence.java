package dynamicProgramming;

public class LongestRepeatingSubsequence {
    public static void main(String args[]){
        String s1 = "aabebcdd";
        System.out.print(ans(s1));
    }
    public static int ans(String str){
        String s1 =str,s2  = str;
        int t[][] = new int[s1.length()+1][s2.length()+1];
        for(int i = 1;i<s1.length()+1;i++){
            for(int j = 1;j<s2.length()+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) && i!=j){
                    t[i][j] = t[i-1][j-1]+1;
                }else{
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
        for(int i = 0;i<t.length;i++){
            for(int j = 0;j<t[0].length;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println(" ");
        }
        return t[s1.length()][s2.length()];
    }
    
}
