/*
 * Maman 11 (Efficiency).
 * 
 * @version 2025B (20454).
 * @author - Shimon Esterkin.
 * @id - 207972258.
 */
public class Ex11
{
    
    // Q.1.1
    
    /*
     * @brief - Retrieves the value at index 'k' of the original array, using its sum-array 
     * representation.
     * This method extracts the original value by analyzing the sum-array relationship for
     * each 'b' give array in this method and a original 'a' that is based upon the 'b' array:
     * - For k=0: a[0] = b[0],
     * - For k>0:
     * 
     * Time Complexity: O(1) - Constant time operations only.
     * Space Complexity: O(1) - Uses only a constant amount of extra space..
     * 
     * @param 'b' - The sum array derived from the original array.
     * @param 'k' - The index to retrieve from the cell from the original array.
     * 
     * @return The value at index 'k' in the original array.
     */
    public static int get(int[] b, int k) {
        if(k == 0) {
            return b[0]; // For the first element, b[0] = a[0].
        } else {
            return b[k] - b[k-1]; // For any other index, a[k] = b[k] - b[k-1].
        }
    }
    
    // Q.1.2
    
    /*
     * @brief - Finds the index of value 'x' in the original array, usby using the sum array 'b'.
     * This method uses binary search on the derived values from the sum array.
     * 
     * Time Complexity: O(log n) - Where 'n' us the length of the array, using binary search.
     * Space Complexity: O(1) - Uses only a constant amount of extra space.
     * 
     * @param 'b' - The sum array derrived from a sorted original array 'a'.
     * @param 'x' - The value to find in the original array 'a'.
     * 
     * @return The index of the 'x' in the original array, or -1 if not found.
     */
    public static int find(int[] b, int x) {
        int left = 0;
        int right = b.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = get(b, mid); // Using the get method to find a[mid].
            
            if(midValue == x) {
                return mid; // Found 'x' at index mid.
            } else if(midValue < x) {
                left = mid + 1; // Search right half.
            } else {
                right = mid - 1; // Search left half.
            }
        }
        
        return -1; // Element not found.
    }
    
    // Q.2
    
    /*
     * @brief - Checks if there exists a subset of the super ascending series that sums to 'k'.
     * A super ascending series is one where each element is greater that the sum of all previous elements.
     * 
     * Algorithm: Uses a greedy approach that takes advantage of the super-ascending property.
     * We work backwards from the largest element, choosing elements that fit within out remaining sum.
     * With super-ascending series, this greedy approach is guaranteed to find a solution, if one exists.
     * 
     * Time Complexity: O(n) - Where 'n' is the length of the array, as we examine each element exactly once.
     * Space Complexity: O(1) - As we only use a constant amount of extra space.
     * 
     * @param "arr" - The super-ascending series (with natural namber).
     * @param 'k' - The target sum to achieve (a natural number).
     * 
     * @return "true" if there exists a subset that sums to 'k', "false" otherwise.
     */
    public static boolean superInc(int[] arr, int k) {
        // If 'k' negative or zero, return "false" as invalid input.
        if(k <= 0) {
            return false;
        }
        
        // Start from the end of the array (largest elements).
        for(int i = arr.length - 1; i >= 0; i--) {
            // If the current element is less than or equal to 'k', include it.
            if(arr[i] <= k) {
                k -= arr[i];
            }
            
            // If we've found a subset that sumns exactly to 'k' already.
            if(k == 0) {
                return true;
            }
        }
        
        // If we've gone through the entire array and 'k' is not '0', no valid subset exits.
        return false;
    }
}
