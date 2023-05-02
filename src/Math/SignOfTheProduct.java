package Math;

public class SignOfTheProduct {

    public static void main(String args[]){
        int arr[] ={-1,1,-1,1,-1};
        System.out.println(util1(arr));
    }

    public static int util1(int [] arr){
        int numberNegative = 0;
        for(int i:arr){
            if(i == 0){
                return 0;
            }else if(i<0){
                numberNegative++;
            }
        }
        if(numberNegative%2 == 0){
            return 1;
        }else{
            return -1;
        }
    }
    
}
