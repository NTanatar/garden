import java.util.Arrays;

public class Main {

    public static void printIntArray(int[] array) {
        for (int element: array) {
            System.out.print(element + " ");
        }
        System.out.println("*");
    }

    public static int[] fillAndSort(int size, int defaultValue, int[] tail) {
        int[] array = new int[size];
        Arrays.fill(array, defaultValue);

        if (size >= tail.length) {
            int startPos = size - tail.length;
            System.arraycopy(tail, 0, array, startPos, tail.length);
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        printIntArray(new int[]{3, 1, 2, 6, 4, 2});

        int[] b = {7,8,1,0,24,12,5,6,2,15};
        int[] a = fillAndSort(23, 4, b);

        int pos1 = Arrays.binarySearch(a, 14);
        System.out.println(pos1);
        int pos2 = Arrays.binarySearch(a, 15);
        System.out.println(pos2);

        StorageItem[] items = {new StorageItem(2), new StorageItem(14), new StorageItem(1)};
        Arrays.sort(items);
        System.out.println(Arrays.toString(items));

        System.out.println("Hello World!");
    }
}
