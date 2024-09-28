package dynamicProgramming;

public class BestTeamWithNoConflicts {
    public static void main(String args[]){
        // int ages[] = {811,364,124,873,790,656,581,446,885,134};
        // int scores[] = {1,1,1,1,1,1,1,1,1,1};
        int ages[] = {4,1,3,3,5};
        int scores[] ={9,2,8,8,2};
        System.out.print(helperTab(scores,ages));
    }
    public static int bestTeamScore(int[] scores, int[] ages){
        mergeSort(ages,scores);
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<ages.length;i++){max = (max>ages[i])?max:ages[i];}
        dp = new int[scores.length+1][max+1];
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = helperDp(scores,ages,0,0);
        return ans;
    }
    //this was for when we sorted the array acc to ages..
    public static int helperRecursive(int scores[], int ages[],int i,int prevScore){
        if(i == scores.length){
            return 0;
        }
        if(scores[i]>=prevScore ||(i>0 && ages[i] == ages[i-1])){
            int ans1 = helperRecursive(scores,ages,i+1,prevScore);
            int ans2 = helperRecursive(scores, ages, i+1,ages[i])+scores[i];
            return Math.max(ans1, ans2);
        }else{
            int ans = helperRecursive(scores,ages,i+1,prevScore);
            return ans;
        } 
    }
    //when we sort acc to scores
    public static int helperRecursive2(int scores[], int ages[],int i,int prevAge){
        if(i == scores.length){return 0;}
        int ans;
        if(ages[i]>=prevAge){
            int ans1 = helperRecursive2(scores,ages,i+1,prevAge);
            int ans2 = helperRecursive2(scores,ages,i+1,ages[i])+scores[i];
            ans = Math.max(ans1, ans2);
        }else{
            ans  = helperRecursive2(scores,ages,i+1,prevAge);
        }
        return ans;
    }
    //memoization code
    static int dp[][];
    public static int helperDp(int scores[], int ages[],int i,int prevAge){
        if(i == scores.length){return 0;}
        if(dp[i][prevAge]!=-1){return dp[i][prevAge];}
        int ans;
        if(ages[i]>=prevAge){
            int ans1 = helperDp(scores,ages,i+1,prevAge);
            int ans2 = helperDp(scores,ages,i+1,ages[i])+scores[i];
            ans = Math.max(ans1, ans2);
        }else{
            ans  = helperDp(scores,ages,i+1,prevAge);
        }
        return dp[i][prevAge] = ans;
    }
   // 1-dp way
    public static int helperTab(int scores[], int ages[]){
        mergeSort(scores,ages);
        int dp[] = new int[scores.length];
        dp[0] = scores[0];
        int max = dp[0];
        for(int i = 1;i<scores.length;i++){
            dp[i] = scores[i];
            for(int j = 0;j<i;j++){
                if(scores[j]<=scores[i]){
                    dp[i] = Math.max(dp[i],dp[j]+scores[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    //mergeSort(sort them on the basis of score, if score is equal then on the basis of age)
    private static void mergeSort(int ages[],int scores[]){
        if(ages.length<=1){return;}
        int agesHalf[] = new int[ages.length/2];
        int scoresHalf[] = new int[agesHalf.length];
        int agesHalf2[] = new int[ages.length-agesHalf.length];
        int scoresHalf2[] = new int[agesHalf2.length];
        for(int i = 0;i<agesHalf.length;i++){
            agesHalf[i] = ages[i];
            scoresHalf[i] = scores[i];
        }
        for(int i = ages.length/2;i<ages.length;i++){
            agesHalf2[i-ages.length/2] = ages[i];
            scoresHalf2[i-ages.length/2] = scores[i];
        }
        mergeSort(agesHalf,scoresHalf);
        mergeSort(agesHalf2,scoresHalf2);
        mergeSortedArrays(agesHalf,scoresHalf,agesHalf2,scoresHalf2,ages,scores);
    }
    private static void mergeSortedArrays(int[]agesHalf,int[]scoresHalf,int[]agesHalf2,int[]scoresHalf2,int[]ages,int[]scores){
        int i = 0,j=0,k=0;
        while(i<agesHalf.length && j<agesHalf2.length){
            if(scoresHalf[i]<scoresHalf2[j]){
                ages[k] = agesHalf[i];
                scores[k] = scoresHalf[i];
                i++;k++;
            }else if(scoresHalf[i]>scoresHalf2[j]){
                ages[k] = agesHalf2[j];
                scores[k] = scoresHalf2[j];
                k++;j++;
            }else{
                if(agesHalf[i] < agesHalf2[j]){
                    ages[k] = agesHalf[i];
                    scores[k] = scoresHalf[i];
                    i++;k++;
                }else{
                    ages[k] = agesHalf2[j];
                    scores[k] = scoresHalf2[j];
                    k++;j++;
                }
            }
        }
        while(i<agesHalf.length){
            ages[k] = agesHalf[i];
            scores[k] = scoresHalf[i];
            i++;k++;
        }
        while(j<agesHalf2.length){
            ages[k] = agesHalf2[j];
            scores[k] = scoresHalf2[j];
            k++;j++;
        }
    }

}
