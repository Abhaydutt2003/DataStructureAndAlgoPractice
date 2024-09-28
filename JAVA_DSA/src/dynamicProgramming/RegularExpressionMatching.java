package dynamicProgramming;

public class RegularExpressionMatching {
    public static void main(String args[]){
        String s1 = "aab";
        String s2 = "c*a*b";
        System.out.println(isMatch(s1, s2));
    }
    public static boolean isMatch(String s, String p){
        // return helper1(s,p,s.length()-1,p.length()-1);
        return helper2(s,p);
    }
    public static boolean helper1(String s1, String s2, int i, int j){
        if(i == -1 && j == -1){
            return true;
        }else if(j == -1){
            return false;
        }
        if(i>=0 && (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.')){
            return helper1(s1,s2,i-1,j-1);
        }else if(s2.charAt(j) == '*'){
            //the condition where we want none of the previous character
            boolean ans1 = helper1(s1,s2,i,j-2);
            //now for the cases where we increase the count of the preceding element
            boolean ans = false;
            if(s2.charAt(j-1) == '.'){
                for(int i2 =i;i2>=0;i2--){
                    boolean temp = helper1(s1,s2,i2-1,j-2);
                    ans  = (temp)?temp:ans;
                }
            }else{
                char c = s2.charAt(j-1);
                for(int i2 = i;i2>=0 && s1.charAt(i2) == c;i2--){
                    boolean temp = helper1(s1,s2,i2-1,j-2);
                    ans  = (temp)?temp:ans;
                }
            }return (ans == true)?ans:ans1;
        }else{
            return false;
        }
    }
    //dynammic programming optimization
    public static boolean helper2(String s1, String s2){
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        for(int i = 0,j=0;i<s1.length()+1;i++){
            dp[i][j] = false;
        }
        dp[0][0] = true;
        for(int i = 0,j=2;j<s2.length()+1;j++){
            if(s2.charAt(j-1) == '*'){
                dp[i][j] = dp[i][j-2];
            }else{
                dp[i][j] = false;
            }
        }
        for(int i = 1;i<dp.length;i++){
            for(int j =1;j<dp[0].length;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s2.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(s2.charAt(j-1) == '*'){
                    boolean ans1 = dp[i][j-2];
                    boolean ans2 = false;
                    if(s1.charAt(i-1) == s2.charAt(j-2) || s2.charAt(j-2) == '.'){
                        ans2 = dp[i-1][j];
                    }
                    dp[i][j] = (ans1)?ans1:ans2;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
//     true false true false true false 
//     false false false true true false 
//     false false false false true false 
//     false false false false false true 
    
}
