import java.util.Comparator;

public class HeapSortComparator {
    public static <E> void heapSort(E[] arr, Comparator<? super E> comparator) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, comparator);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0, comparator);
        }
    }
    private static <E> void heapify(E[] arr, int n, int root, Comparator<? super E> comparator) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        if (left < n && comparator.compare(arr[left], arr[largest]) > 0) {
            largest = left;
        }
        if (right < n && comparator.compare(arr[right], arr[largest]) > 0) {
            largest = right;
        }
        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, n, largest, comparator);
        }
    }
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 10, 3, 5, 1};
        Comparator<Integer> comparator = Integer::compare;
        heapSort(arr, comparator);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
