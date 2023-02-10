package greedy;

import java.util.*;
// class pair2<T,S>{
//     T a;
//     S b;
//     pair2(T a, S b){
//         this.a = a;
//         this.b = b;
//     }
//     T getFirst(){
//         return a;
//     }
//     S getSecond(){
//         return b;
//     }
//     void putFirst(T a){
//         this.a = a;
//     }
//     void putSecond(S b){
//         this.b = b;
//     }
// }
public class NumberOfWeakCharacters {
    public static void main(String args[]){
        int [][] matrix = {
            // {2,6},
            // {2,3},
            // {1,7},
            // {1,6},
            // {1,5},
            // {4,7},
            // {4,5}
            // {1,5},
            // {10,4},
            // {4,3}
            {7,9},
            {10,7},
            {6,9},
            {10,4},
            {7,5},
            {7,10},
        };
        int ans = numberWeak(matrix);
        System.out.println(ans+" ");
    }
    //recursive code..
    public static int numberOfWeakCharacters(int [][] properties){
        Arrays.sort(properties,(a,b) -> a[0] == b[0]?a[1]-b[1]:a[0]-b[0]);
        return findAns(properties,0);
    }
    public static int findAns(int matrix[][], int i){
        if(i == matrix.length){
            return 0;
        }
        int smallAns = findAns(matrix,i+1);
        boolean a = findIfWeak(matrix,i);
        smallAns+=(a)?1:0;
        return smallAns;
    }
    public static boolean findIfWeak(int matrix[][], int i){
        for(int a = i+1;a<matrix.length;a++){
            if(matrix[a][1] > matrix[i][1]){
                return true;
            }
        }
        return false;
    }
    public static int numberWeak(int [][] properties){
        Arrays.sort(properties,(a,b) -> a[0] == b[0]?a[1]-b[1]:a[0]-b[0]);
        int helper[] = new int[2];
        helper[0] = properties[properties.length-1][0];
        helper[1] = properties[properties.length-1][1];
        int ans = 0;
        int i = properties.length-1;
        int currentPart = properties[i][0];
        while(i>=0){
            int[] futureHelper = new int[2]; 
            //traversing the sub parts
            while(i>=0){
                if(properties[i][0] != currentPart){
                    currentPart = properties[i][0];
                    break;
                }else{
                    if(properties[i][0]< helper[0] && properties[i][1]<helper[1]){
                        ans++;
                    }
                    if(futureHelper[1]<properties[i][1]){
                        futureHelper[0] = properties[i][0];
                        futureHelper[1] = properties[i][1];
                    }
                }
                i--;
            }
            if(futureHelper[1]>helper[1]){
                helper = futureHelper;
            }
        }
        return ans;
    }
}
