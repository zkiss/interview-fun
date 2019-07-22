package kissz;

public class RotateMatrix {
    public static void rotate90(int[][] mx) {
        final int sq = mx.length / 2;
        final int a = sq * sq;

        for (int id = 0; id < a; id++) {
            int col = id % sq;
            int row = id / sq;

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

        if (mx.length % 2 == 1) {
            // do middle columns
            final int mid = sq;
            for (int i = 0; i < sq; i++) {
                // top
                int tmp = mx[i][mid];
                // top <- right
                mx[i][mid] = mx[mid][mx.length - 1 - i];
                // right <- bottom
                mx[mid][mx.length - 1 - i] = mx[mx.length - 1 - i][mid];
                // bottom <- left
                mx[mx.length - 1 - i][mid] = mx[mid][i];
                // left <- top
                mx[mid][i] = tmp;
            }
        }
    }
}