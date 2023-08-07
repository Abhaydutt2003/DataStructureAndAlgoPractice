package binarySearch;

public class Search2dMatrix2 {

    public static void main(String args[]) {
        int matrix[][] = {
                { -1, 3 }
        };
        System.out.println(util1(matrix, 3));
    }
    
    //normal bs ka koi fayda ni.


    //normal 
    public static boolean util1(int[][] matrix, int target) {
        int currentI = 0;
        int currentJ = matrix[0].length - 1;
        while ((currentI >= 0 && currentI < matrix.length) && (currentJ >= 0 && currentJ < matrix[0].length)) {
            if (matrix[currentI][currentJ] == target) {
                return true;
            } else if (matrix[currentI][currentJ] < target) {
                currentI++;
            } else {
                currentJ--;
            }
        }
        return false;
    }

}
