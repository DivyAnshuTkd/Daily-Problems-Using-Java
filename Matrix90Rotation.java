class Matrix90Rotation
{
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;
        
        for(int i = 0; i<n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                swap(matrix, i, j);
            }
        }

        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n/2; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    public static void swap(int matrix[][], int pos1, int pos2)
    {
        int temp = matrix[pos1][pos2];
        matrix[pos1][pos2] = matrix[pos2][pos1];
        matrix[pos2][pos1] = temp;
    }

    public static void main(String[] args) {
        Matrix90Rotation rotator = new Matrix90Rotation();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        rotator.rotate(matrix);

        System.out.println("Rotated Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}