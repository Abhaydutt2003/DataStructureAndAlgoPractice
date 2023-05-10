package arrays;

public class SpiralMatrix2 {

    public static void main(String args[]){
        int n = 3;
        int matrix[][] = util1(n);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }System.out.println("");
        }
    }

    public static int[][] util1(int n){
        int matrix[][] = new int[n][n];
        int total = n*n;
        int current = 0;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n-1;
        int colEnd = n-1;
        int k = 1;
        while(true){
            if(current>=total){
                break;
            }
            for(int i = colStart;i<=colEnd;i++){
                if(current>=total){return matrix;}
                matrix[rowStart][i] = k++;
                current++;
            }
            rowStart++;
            for(int i =rowStart;i<=rowEnd;i++){
                if(current>=total){return matrix;}
                matrix[i][colEnd] =  k++;
                current++;
            }
            colEnd--;
            for(int i = colEnd;i>=colStart;i--){
                if(current>=total){return matrix;}
                matrix[rowEnd][i] = k++;
                current++;
            }
            rowEnd--;
            for(int i = rowEnd;i>=rowStart;i--){
                if(current>=total){return matrix;}
                matrix[i][colStart] = k++;
                current++;
            }
            colStart++;
        }
        return matrix;
    }
    
}
