package arraysandarraylists;
/**
 * Demonstrate an Array List but with Primitive Types.  So we know
 * exactly what is going on in the the background.
 * @author Professor Meachan 
 */
public class MYAL // My Array List
{
    private int[] nums;
    private int count = 0;
    private int originalSize = 0;
    
    private long transactions = 0;
    
    
    public MYAL() {
        nums = new int[10];  // Default size of ten
        originalSize = 10;
    }
    
    public MYAL(int size) {
        nums = new int[size];
        originalSize = size;
    }
    
    public long getTransactions()
    {
        return transactions;
    }
    
    public void clearTransactions()
    {
        transactions = 0;
    }
    
      public void add(int num) {
        // Note:  I do need to grow the array if it is full.  We will do that later.
        if (count == nums.length) {
            growArray();
        }
        nums[count] = num;  // Add it to the partially filled array
        count++;
    }
    
    /**
     * Insert at a specific location. We are going to assume GIGO
     * @param loc
     * @param num 
     */
    public void add(int loc, int num) {
        if (count == nums.length) {
            growArray();
        }
        // We have to make room for num at a specific location
        for (int i = count - 1; i >= loc; i--) 
        {
            transactions++;
            nums[i + 1] = nums[i];
        }
        
        nums[loc] = num;  // Finally, put the value in its place.
        count++; // Increment our count.
    }
    
    /**
     * A private helper method that creates a new copy of the original
     * with more space.
     */
    private void growArray() {
        int[] newNums = new int[nums.length + originalSize];  // Create a new one
        for (int i = 0; i < count; i++)
        {
            transactions++;
            newNums[i] = nums[i];  // Copies the ints from nums to newNums.  If it was an array of Integers, it would copy the addresses
        }
        nums = newNums;  // Set nums to point at the new array that we just created.
    }
    
    public void set(int loc, int num) {
        nums[loc] = num;
    }
    
    /**
     * We have to shift everything to the left.
     * @param loc 
     */
    public void remove(int loc) {
        for (int i = loc; i < count - 1; i++) 
        {
            transactions++;
            nums[i] = nums[i + 1];
        }
        count--;
    }
    
    public int size() {
        return count;
    }
    public String toString() {
        String str = "[";
        if (count == 0) {
            return str += "]";
        } else if (count == 1) {
            return str += nums[0] + "]";
        } else {
          for (int i = 0; i < count - 1; i++) 
          {
              if ((i+1) % 20 == 0)  // We use modulus for page breaks and line breaks.
                  str += "\n";
              else
                  str += nums[i] + ", ";
          }
          str += nums[count-1] + "]"; // Add the last one.
          return str;
        }
    }   
}