package dynamicProgramming;

public class PalindromicPartitioning4 {

    public static void main(String args[]){
        String s = "bcbddxy";
        System.out.print(checkPartitioning(s));
    }
    static Boolean palindromeDp[][];
    static Boolean mainDp[][];
    
    public static boolean checkPartitioning(String s){
        palindromeDp = new Boolean[s.length()+1][s.length()+1];
        mainDp = new Boolean[s.length()+1][4];
        boolean ans = helper(s,0,3);
        return ans;
    }
    public static boolean helper(String s, int i, int cuts){
        if(mainDp[i][cuts] != null){
            return mainDp[i][cuts];
        }
        if(i == s.length()){
            if(cuts == 0){return true;}
            return false;
        }
        if(cuts == 0){return false;}
        for(int k=i;k<s.length();k++){
            if(isPalindrome(s,i,k)){
                if(helper(s,k+1,cuts-1)){return mainDp[i][cuts] = true;}
            }
        }
        return mainDp[i][cuts] = false;
    }
    public static boolean isPalindrome(String s, int i, int j){
        if(palindromeDp[i][j]!=null){return palindromeDp[i][j];}
        if(i>=j){return palindromeDp[i][j] = true;}
        if(s.charAt(i) == s.charAt(j)){return palindromeDp[i][j] = isPalindrome(s, i+1, j-1);}
        return palindromeDp[i][j] = false;
    }
    
    //if String till now is palindrome , make a cut and then proceed tom the right side
}
