package telran.util;

public class Arrays {

    public static int search(int[] ar, int key) {
        int index = 0;
        while (index < ar.length && ar[index] != key) {
            index++;
        }
        return index == ar.length ? -1 : index;
    }

    public static int[] add(int[] ar, int number) {
        int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[ar.length] = number;
        return res;
    }

    public static int[] insert(int[] ar, int index, int number) {
        int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        System.arraycopy(ar, index, res, index + 1, ar.length - index);
        res[index] = number;
        return res;
    }

    public static int[] remove(int[] numbers, int index) {
        int[] res = java.util.Arrays.copyOf(numbers, numbers.length - 1);
        System.arraycopy(numbers, index + 1, res, index, res.length - index);
        return res;
    }

    private static boolean pushMaxAtEnd(int[] array, int length) {
        boolean res = true;
        for (int i = 1; i < length; i++) {
            if (array[i - 1] > array[i]) {
                res = false;
                swap(array, i - 1, i);
            }
        }
        return res;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array) {
        int length = array.length;
        boolean flSorted = false;
        while (!flSorted) {
            length--;
            flSorted = pushMaxAtEnd(array, length);
        }
    }

    public static int binarySearch(int[] ar, int key) {
        int left = 0;
        int right = ar.length - 1;
        int middle = (left + right) / 2;
        while (left <= right && ar[middle] != key) {
            if (key < ar[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left > right ? -(left + 1) : middle;
    }
}
