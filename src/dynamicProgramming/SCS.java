package dynamicProgramming;

public class SCS {
    public static void main(String args[]){
        String s1 = "abac";
        String s2 = "cab";
        String ans = shortestCommonSupersequence(s1,s2);
        System.out.print(ans+" ");
    }
    public static String shortestCommonSupersequence(String str1, String str2){
        int t[][] = lcs(str1,str2);
        StringBuilder ans = new StringBuilder();
        int i = str1.length(),j=str2.length();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;j--;
            }else if(t[i-1][j]>=t[i][j-1]){
                ans.append(str1.charAt(i-1));
                i--;
            }else{
                ans.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }
        return ans.reverse()+"";
    }
    public static int[][] lcs(String s1, String s2){
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
        return t;
    }

    
}
