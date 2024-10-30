package com.my_new_leetcode_journey.binary_search;

/**
 * <h1>Search 2D Matrix</h1>
 * <h2>Medium</h2>
 * <p>
 * You are given an <code>m x n</code> 2D integer array <code>matrix</code> and an integer <code>target</code>.
 * Each row in <code>matrix</code> is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * </p>
 * <p>
 * Return <code>true</code> if <code>target</code> exists within <code>matrix</code> or <code>false</code> otherwise.
 * </p>
 * <p>
 * Your solution should run in <code>O(log(m * n))</code> time.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
 * Output: true
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
 * Output: false
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>m == matrix.length</code></li>
 *   <li><code>n == matrix[i].length</code></li>
 *   <li><code>1 <= m, n <= 100</code></li>
 *   <li><code>-10,000 <= matrix[i][j], target <= 10,000</code></li>
 * </ul>
 */
public class Search2DMatrix {

    /*
     * Time complexity: O(log(m * n)); 
     */
    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int columnCount = matrix[0].length;
        int rowCount = matrix.length;

        int topRow = 0;
        int botRow = rowCount - 1;

        while (topRow <= botRow) {
            int midRow = topRow + ((botRow - topRow) / 2);

            if(matrix[midRow][columnCount-1] < target){
                topRow = midRow+1;
            }else if(matrix[midRow][0] > target){
                botRow = midRow-1;
            }else{
                break;
            }
        }

        if(topRow> botRow){
            return false;
        }

        int midRow = topRow + ((botRow - topRow) / 2);


        return binarySearch(matrix[midRow], target);

    }


    public boolean searchMatrixMyAttempt(int[][] matrix, int target) {
        int columnCount = matrix[0].length;
        int rowCount = matrix.length;
        int i = 0;
        while (i < rowCount && target > matrix[i][columnCount - 1]) {
            i++;
        }

        if (i >= rowCount) {
            return false;
        }

        return binarySearch(matrix[i], target);

    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
