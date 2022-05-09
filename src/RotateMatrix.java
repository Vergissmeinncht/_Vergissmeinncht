public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotate = new int[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j< n;j++) {
                rotate[j][n-1-i] = matrix[i][j];
            }
        }
        for(int i = 0;i < n;i++) {
            System.arraycopy(rotate[i], 0, matrix[i], 0, n);
        }
    }
}
