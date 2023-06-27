package funwithsortings23b;

/**
 *
 * @author jg
 */
public class FunWithSortingS23B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] nums1 = new int[10000];
        int[] nums2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] nums3 = {3, 8, 2, 4, 9, 6, 7, 1, 10, 5};
        
        for(int i = 0; 1 < nums1.length; i++)
        {
            nums1[i] = i + 1;
        }
        
        SearchUtility.instructionCount = 0;
        SearchUtility.compCount = 0;
        
        SearchUtility.linearSearch(nums1,1);
        System.out.println("Best Case: O(1) " + SearchUtility.instructionCount);
        
        SearchUtility.instructionCount = 0;
        SearchUtility.compCount = 0;
        SearchUtility.linearSearch(nums1,10000);
        System.out.println("Worst Case: O(n) " + 
                SearchUtility.instructionCount);
        
        SearchUtility.instructionCount = 0;
        for(int i = 0; i < 1000; i++)
        {
            int target = (int)(Math.random() * 10000 + 1);
            SearchUtility.linearSearch( nums1, target);
        }
        // O(n)
        
        System.out.println("Average Case: O(5) " + 
        SearchUtility.instructionCount/1000);

        
        SearchUtility.instructionCount = 0;
        SearchUtility.compCount = 0;
        SearchUtility.binarySearchIterative(nums1,5000);
        System.out.println("Best Case: " + 
                SearchUtility.instructionCount);
        
        SearchUtility.instructionCount = 0;
        SearchUtility.compCount = 0;
        SearchUtility.binarySearchIterative(nums1,10000);
        System.out.println("Worst Case: O(n) " + 
                SearchUtility.instructionCount);
        
        SearchUtility.instructionCount = 0;
        for(int i = 0; i < 10000; i++)
        {
            int target = (int)(Math.random() * 10000 + 1);
            SearchUtility.binarySearchIterative( nums1, target);
        }
        // O(n) 
        System.out.println("Average Case: O(5) " + 
                SearchUtility.instructionCount/10000);
        
    }
    
}
