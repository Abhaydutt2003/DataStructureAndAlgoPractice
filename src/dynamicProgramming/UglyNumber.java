package dynamicProgramming;

public class UglyNumber {
    public static void main(String args[]){
        int n = 14;
        System.out.println(uglyNumber(n));
    }
    public static boolean uglyNumber(int n){
        if(n <=0){return false;}
        if(n == 1){return true;}
        if(n%2 == 0){
            return uglyNumber(n/2);
        }else if (n%3 == 0){
            return uglyNumber(n/3);
        }else if(n%5 == 0){
            return uglyNumber(n/5);
        }else{
            return false;
        }
    }
    
}
