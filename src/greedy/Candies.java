package greedy;

public class Candies {
    public static void main(String args[]){
        int arr[] = {1,0,2};
        System.out.print(candy(arr));
    }
    public static int candy(int[] ratings) {
        int leftToRight[] = new int[ratings.length];
        int rightToLeft[] = new int[ratings.length];
        //left to right pass
        leftToRight[0] = 1;
        int toPut=1; 
        for(int i = 1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                leftToRight[i] = ++toPut;
            }else{
                toPut=1;
                leftToRight[i] = toPut;
            }
        }
        //right to left pass
        rightToLeft[ratings.length-1] = 1;
        toPut=1;
        for(int i = ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                rightToLeft[i] = ++toPut;
            }else{
                toPut=1;
                rightToLeft[i] = toPut;
            }
        }
        //now calculating the answer
        int ans=0;
        for(int i = 0;i<ratings.length;i++){
            ans += (leftToRight[i]>rightToLeft[i])?leftToRight[i]:rightToLeft[i];
        }
        return ans;
    }
    
}
