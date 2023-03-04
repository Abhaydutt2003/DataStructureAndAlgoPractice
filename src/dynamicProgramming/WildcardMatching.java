package dynamicProgramming;

public class WildcardMatching {
    
    public static void main(String args[]){
        String s1 ="abbacbaa";
        String s2 = "ab*?a";
        System.out.println(isMatch(s1, s2));
    }
    public static boolean isMatch(String s, String p){
        // return helper1(s,p,s.length()-1,p.length()-1);
        return helper2(s,p);
    }
    public static boolean helper1(String s1, String s2, int i,int j){
        if(i == -1 && j == -1){
            return true;
        }else if(j == -1){
            return false;
        }
        if(i>=0 &&((s1.charAt(i) == s2.charAt(j)) || s2.charAt(j) == '?')){
            return helper1(s1,s2,i-1,j-1);
        }else if(s2.charAt(j) == '*'){
            for(int i2 = i;i2>=-1;i2--){
                boolean temp = helper1(s1,s2,i2,j-1);
                if(temp){return true;}
            }
            return false;
        }else{
            return false;
        }
    }
    public static boolean helper2(String s1, String s2){
        boolean dp[][] = new boolean [s1.length()+1][s2.length()+1];
        for(int i = 0,j=0;i<s1.length()+1;i++){
            dp[i][j] = false;
        }
        dp[0][0] = true;
        for(int i = 0,j=1;j<s2.length()+1;j++){
            boolean toPut = false;
            if(s2.charAt(j-1) == '*'){
                toPut = dp[i][j-1];
            }
            dp[i][j] = toPut;
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s2.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(s2.charAt(j-1) == '*'){
                    boolean ans1 = dp[i][j-1];
                    boolean ans2 = dp[i-1][j];
                    dp[i][j] = (ans2)?ans2:ans1;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
