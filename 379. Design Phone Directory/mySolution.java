import java.util.*;

public class PhoneDirectory {
    private int maxNumbers;
    private Queue<Integer> availableList;
    private Set<Integer> usedSet;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers; 
        availableList = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            availableList.offer(i);
        }    
        usedSet = new HashSet<>(); 
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!availableList.isEmpty()) {
            int num = availableList.poll();
            usedSet.add(num);
            return num;
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !usedSet.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (number >= maxNumbers) return;
        if (usedSet.contains(number)) {
            usedSet.remove(number);
            availableList.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */