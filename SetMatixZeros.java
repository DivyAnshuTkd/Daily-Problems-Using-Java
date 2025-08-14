import java.util.HashMap;
class SetMatixZeros 
{
    public void setZeroes(int[][] matrix) 
    {
        int row = matrix.length;
        int column = matrix[0].length;

        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> columnMap = new HashMap<>();

        // Step 1: Store positions of rows & columns that have zeros
        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < column; j++) 
            {
                if (matrix[i][j] == 0) 
                {
                    rowMap.put(i, j);
                    columnMap.put(j, i);
                }
            }
        }

        // Step 2: Set rows to zero
        
            for (int k = 0; k < row; k++) 
            {
                if (rowMap.containsKey(k)) 
                {
                    for (int i = 0; i < column; i++) 
                    {
                        matrix[k][i] = 0;
                    }
                }
            }
        

        // Step 3: Set columns to zero

            for (int k = 0; k < column; k++) 
            {
                if (columnMap.containsKey(k)) 
                {
                    for (int i = 0; i < row; i++) 
                    {
                        matrix[i][k] = 0;
                    }
                }
            }
    }

    public static void main(String[] args) {
        SetMatixZeros obj = new SetMatixZeros();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        obj.setZeroes(matrix);
        
        // Print the modified matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
