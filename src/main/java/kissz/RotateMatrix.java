package kissz;

public class RotateMatrix {
    public static void rotate90(int[][] mx) {
        final int cols = mx.length / 2 + mx.length % 2; // handles middle row in case odd
        final int rows = mx.length / 2;
        final int a = cols * rows;

        for (int id = 0; id < a; id++) {
            int col = id % cols;
            int row = id / cols;

            // top left
            int tmp = mx[row][col];
            // top right
            mx[row][col] = mx[col][mx.length - 1 - row];
            // bottom right
            mx[col][mx.length - 1 - row] = mx[mx.length - 1 - row][mx.length - 1 - col];
            // bottom left
            mx[mx.length - 1 - row][mx.length - 1 - col] = mx[mx.length - 1 - col][row];
            mx[mx.length - 1 - col][row] = tmp;
        }
    }
}