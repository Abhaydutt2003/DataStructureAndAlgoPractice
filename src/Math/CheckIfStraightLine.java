package Math;

public class CheckIfStraightLine {

    public static void main(String args[]){

    }


    public static boolean util1(int[][] matrix){
        if(matrix.length == 2){
            return true;
        }
        for(int i = 2;i<matrix.length;i++){
            int x1 = matrix[i-2][0];
            int x2 = matrix[i-1][0];
            int x3 = matrix[i][0];
            int y1 = matrix[i-2][1];
            int y2 = matrix[i-1][1];
            int y3 = matrix[i][1];
            if(isValid(x1,x2,x3,y1,y2,y3) == false){
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(int x1,int x2, int x3, int y1, int y2, int y3){
        if(((y2-y1) * (x3-x2)) == ((y3-y2)*(x2-x1))){
            return true;
        }else{
            return false;
        }
    }



    
}
