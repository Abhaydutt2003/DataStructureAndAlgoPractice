package backTracking;

import java.util.*;

public class NQueens {

    public static void main(String args[]) {
        List<List<String>> s = util1(4);
        for (List<String> a : s) {
            for (String b : a) {
                System.out.println(b);
            }
            System.out.println("");
        }
    }

    static List<List<String>> ans;

    public static List<List<String>> util1(int n) {
        int[][] chessBoard = new int[n][n];
        ans = new ArrayList<>();
        validConfig(chessBoard, 0);
        return ans;
    }

    public static void validConfig(int[][] chessBoard, int i) {
        if (i == chessBoard.length) {
            List<String> toPut = new ArrayList<>();
            for (int a = 0; a < chessBoard.length; a++) {
                String col = "";
                for (int b = 0; b < chessBoard.length; b++) {
                    if (chessBoard[a][b] == 1) {
                        col += "Q";
                    } else {
                        col += '.';
                    }
                }
                toPut.add(col);
            }
            ans.add(toPut);
            return;
        }

        for (int a = 0; a < chessBoard.length; a++) {
            chessBoard[i][a] = 1;
            boolean isValid = check(chessBoard, i, a);
            if (isValid) {
                validConfig(chessBoard, i + 1);
            }
            chessBoard[i][a] = 0;
        }
    }

    public static boolean check(int chessBoard[][], int i, int j) {
        for (int a = i - 1; a >= 0; a--) {
            if (chessBoard[a][j] == 1) {
                return false;
            }
        }

        for (int a = i + 1; a < chessBoard.length; a++) {
            if (chessBoard[a][j] == 1) {
                return false;
            }
        }

        int a = i - 1;
        int b = j - 1;
        while (a >= 0 && b >= 0) {
            if (chessBoard[a][b] == 1) {
                return false;
            }
            a--;
            b--;
        }

        a = i - 1;
        b = j + 1;
        while (a >= 0 && b < chessBoard.length) {
            if (chessBoard[a][b] == 1) {
                return false;
            }
            a--;
            b++;
        }
        return true;
    }

    static boolean leftDiagonal[];
    static boolean rightDiagonal[];
    static boolean upperRow[];

    public static List<List<String>> util2(int n) {
        int[][] chessBoard = new int[n][n];
        ans = new ArrayList<>();
        upperRow = new boolean[n + 1];
        leftDiagonal = new boolean[2 * n];
        rightDiagonal = new boolean[2 * n];
        validConfig2(chessBoard, 0);
        return ans;
    }

    public static void validConfig2(int[][] chessBoard, int i) {
        if (i == chessBoard.length) {
            List<String> toPut = new ArrayList<>();
            for (int a = 0; a < chessBoard.length; a++) {
                String col = "";
                for (int b = 0; b < chessBoard.length; b++) {
                    if (chessBoard[a][b] == 1) {
                        col += "Q";
                    } else {
                        col += '.';
                    }
                }
                toPut.add(col);
            }
            ans.add(toPut);
            return;
        }
        for (int a = 0; a < chessBoard.length; a++) {
            if (check2(i, a, chessBoard.length)) {
                upperRow[a] = true;
                rightDiagonal[a + i] = true;
                leftDiagonal[(chessBoard.length - 1) + (a - i)] = true;
                chessBoard[i][a] = 1;
                validConfig2(chessBoard, i + 1);
                upperRow[a] = false;
                rightDiagonal[a + i] = false;
                leftDiagonal[(chessBoard.length - 1) + (a - i)] = false;
                chessBoard[i][a] = 0;
            }
        }
    }

    public static boolean check2(int i, int j, int n) {
        if (upperRow[j] == false) {
            if (rightDiagonal[i + j] == false) {
                if (leftDiagonal[(n - 1) + (j - i)] == false) {
                    return true;
                }
            }
        }
        return false;
    }

}
