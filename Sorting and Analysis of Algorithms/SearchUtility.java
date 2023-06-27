/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funwithsortings23b;

/**
 *
 * @author jg
 */
public class SearchUtility 
{
    public static int instructionCount = 0; 
    public static int compCount = 0;
    
    
    
    public static int linearSearch(int[] arr, int target) 
    {
        int found = -1;
        instructionCount++;
        
        for (int x = 0; x < arr.length; x++) 
        {
            instructionCount++;
            compCount++;
            if (arr[x] == target) 
            {
                found = target;
                instructionCount++;
                break;
            }
        }
        instructionCount++;
        return found;
    }
    public static <T> T linearSearch(T[] arr, T target) 
    {
        T found = null;
        for (T value : arr) 
        {
            if (value == target) 
            {
                found = target;
                break;
            }
        }
        return found;
    }
    public static int binarySearchIterative(int[] arr, int target) 
    {
        
        int min = 0;
        int max = arr.length - 1;
        
        while (min <= max) 
        {
            instructionCount++;
            int mid = min + (max - min) / 2;
            instructionCount++;
            if (arr[mid] == target) 
            {
                compCount++;
                // Check if target is present at mid
                return mid;
            } 
            else if (arr[mid] < target) 
            {
                compCount++;
                // If target is greater, ignore left half of arr
                min = mid + 1;
            } 
            else 
            {
                instructionCount++;
                // If target is smaller, ignore right half of arr
                max = mid - 1;
            }
        }
        instructionCount++;
        // if we reach here, then element was not present
        return -1;
    }
    
    public int binarySearchRecursive(int[] arr, int target) 
    {
        return binarySearchRecursive(arr, 0, (arr.length - 1), target);
    }

    private int binarySearchRecursive(int arr[], int min, int max, int target) 
    {
        if (max >= min)
        {
            int mid = min + (max - min) / 2;
            if (arr[mid] == target) 
            {
            // Check if target is present at mid
            return mid;
            } 
            else if (arr[mid] > target) 
            {
            // If target is smaller, target is in left half of array
            return binarySearchRecursive(arr, min, mid - 1, target);
            } 
            else 
            {
                // If target is greater, target is in right half of array
                return binarySearchRecursive(arr, mid + 1, max, target);
            }
        }
        // We reach here when element is not present in array
        return -1;
    }
}