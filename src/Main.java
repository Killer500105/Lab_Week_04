public class Main {


    public static void main(String[] args) {
        // ===== Homework 1 =====
        System.out.println("Homework 1: printHelloNTimes(3)");
        printHelloNTimes(3);
        // Expected output:
        // Hello World
        // Hello World
        // Hello World


        System.out.println();


        // ===== Homework 2 =====
        System.out.println("Homework 2: sumMultiplesOf7(5, 30)");
        int sum = sumMultiplesOf7(5, 30);
        System.out.println("Sum of multiples of 7 between 5 and 30: " + sum);
        // Expected output: 70 (7 + 14 + 21 + 28)


        System.out.println();


        // ===== Homework 3 =====
        System.out.println("Homework 3: binarySearch");
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target1 = 7;
        int target2 = 4;


        int index1 = binarySearch(arr, target1, 0, arr.length - 1);
        int index2 = binarySearch(arr, target2, 0, arr.length - 1);


        System.out.println("Index of 7: " + index1); // Expected 3
        System.out.println("Index of 4: " + index2); // Expected -1 (not found)
    }


    // ===============================
    // Homework 1: Print "Hello World" n times recursively
    // ===============================
    static void printHelloNTimes(int n) {
        if (n <= 0) return;  // Base case
        System.out.println("Hello World");
        printHelloNTimes(n - 1);
    }


    // ===============================
    // Homework 2: Sum of multiples of 7 between n1 and n2 recursively
    // ===============================
    // Homework 2: Sum of multiples of 7 between n1 and n2 (inclusive), recursively
    static int sumMultiplesOf7(int n1, int n2) {
        // Normalize once (no recursion here)
        if (n1 > n2) {
            int t = n1; n1 = n2; n2 = t;
        }


        // First multiple of 7 >= n1
        int first = (n1 % 7 == 0) ? n1 : n1 + (7 - (n1 % 7));


        // Tail-recursive helper accumulates the sum by stepping +7 each call
        return sumMultiplesOf7Acc(first, n2, 0);
    }


    static int sumMultiplesOf7Acc(int current, int end, int acc) {
        if (current > end) return acc;          // base case
        return sumMultiplesOf7Acc(current + 7, end, acc + current);
    }




    // ===============================
    // Homework 3: Recursive Binary Search
    // ===============================
    static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) return -1; // Not found


        int mid = low + (high - low) / 2;


        if (arr[mid] == key) return mid;
        if (key < arr[mid]) return binarySearch(arr, key, low, mid - 1);
        return binarySearch(arr, key, mid + 1, high);
    }
}