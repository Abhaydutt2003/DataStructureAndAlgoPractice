package dynamicProgramming;

public class MinimumDeletion {

    public static void main(String[] args){
        String s1 = "heap";
        String s2 = "pea";
        System.out.print(minDistance(s1,s2));
    }
    public static int minDistance(String word1,String word2){
        int lcsLength = lcs(word1,word2);
        int ans = (word1.length()-lcsLength)+(word2.length()-lcsLength);
        return ans;
    }
    private static int lcs(String s1,  String s2){
        int t[][] = new int[s1.length()+1][s2.length()+1];
        for(int i = 1;i<s1.length()+1;i++){
            for(int j = 1;j<s2.length()+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }else{
                    int ans1 = t[i-1][j];
                    int ans2 = t[i][j-1];
                    t[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return t[s1.length()][s2.length()];
    }
}
