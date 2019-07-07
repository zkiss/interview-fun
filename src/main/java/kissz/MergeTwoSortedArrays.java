package kissz;

public class MergeTwoSortedArrays {
    public static int[] mergeTwo(int[] a, int[] b, int alength) {
        for (int i = alength - 1, j = b.length - 1, k = i + j + 1; k >= 0; k--) {
            if (i < 0) {
                a[k] = b[j];
                j--;
            } else if (j < 0) {
                a[k] = a[i];
                i--;
            } else if (a[i] < b[j]) {
                a[k] = b[j];
                j--;
            } else {
                a[k] = a[i];
                i--;
            }
        }
        return a;
    }
}
