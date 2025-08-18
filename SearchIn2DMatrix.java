public class SearchIn2DMatrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
         int row = 0;
         int column = matrix[0].length - 1;

         while(row < matrix.length && column >= 0)
         {
            if(target > matrix[row][column])
            {
                row++;
            }

            else if(target < matrix[row][column])
             {
                column--;
             }

            else if(target == matrix[row][column])
                {
                    return true;
                }
         }

         return false;
    }

    public static void main(String[] args) {
        SearchIn2DMatrix searchIn2DMatrix = new SearchIn2DMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = searchIn2DMatrix.searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}