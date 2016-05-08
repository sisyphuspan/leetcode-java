/**
 * Created by sisyphuspan on 16/4/7.
 */
public class BinarySearch2D {

    public static void main(String[] args) {

        int[][] matrix = {{-1, 3}};
        boolean res = searchMatrix2(matrix, -1);
        System.out.print("find: " + res);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int column = n - 1;
        while(row < m && column >= 0) {
            if(matrix[row][column] == target)
                return true;
            else if(matrix[row][column] < target) {
                column--;
            }else {
                row++;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i<matrix.length && j>=0) {
            if(matrix[i][j] == target)
                return true;
            else if(target < matrix[i][j])
                j--;
            else
                i++;
        }

        return false;
    }
}
