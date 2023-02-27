package dynamicProgramming;

public class EditDistance {
    public static void main(String args[]){
        String s1 = "horse";
        String s2 = "ros";
        System.out.print(minDistance(s1, s2));
    }
    public static int minDistance(String word1, String word2 ){
        //return recursiveUtil(word1,word2,0,0);
        return tabulationUtil(word1, word2);
    }
    public static int recursiveUtil(String s1, String s2, int i, int j){
        if(i == s1.length()){
            return s2.length()-j;
        }else if (j == s2.length()){
            return s1.length()-i;
        }else if(s1.equals(s2)){
            return 0;
        }
        int ans;
        if(s1.charAt(i) == s2.charAt(j)){
            ans =  recursiveUtil(s1, s2, i+1, j+1);
        }else{
            int ans1 = recursiveUtil(s1,s2,i+1,j+1)+1;
		 	int ans2 = recursiveUtil(s1,s2,i,j+1)+1;
		 	int ans3 = recursiveUtil(s1,s2,i+1,j)+1;
		 	ans = Math.min(ans2, Math.min(ans1, ans3));
        }
        return ans;
    }
    //tabulation
    public static int tabulationUtil(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i = 0,j=0;i<=s1.length();i++){
            dp[i][j] = i;
        }
        for(int i = 0,j=0;j<=s2.length();j++){
            dp[i][j] = j;
        }
        for(int i = 1;i<s1.length()+1;i++){
            for(int j = 1;j<s2.length()+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int ans1 = dp[i-1][j]+1;
                    int ans2 = dp[i-1][j-1]+1;
                    int ans3 = dp[i][j-1]+1;
                    dp[i][j] = Math.min(ans2,Math.min(ans1, ans3));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
