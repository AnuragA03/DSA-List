import java.util.Scanner;

class LC33SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;

            else if (nums[mid] >= nums[low]) { // Left half is sorted
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right half is sorted
                if (target <= nums[high] && target >= nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Input array elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array (sorted and rotated):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input target value
        System.out.print("Enter the target value to search for: ");
        int target = scanner.nextInt();

        // Create an instance of LC33SearchInSortedRotatedArray and call the search method
        LC33SearchInSortedRotatedArray solution = new LC33SearchInSortedRotatedArray();
        int result = solution.search(nums, target);

        // Output result
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }

        scanner.close();
    }
}
