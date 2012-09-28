package staff.sol;

/**
 * A Set of chars.  
 */
public interface CharSet {
    
    /**
     * Adds a character into our CharSet.
     * 
     * @param o char to be added.
     */
    public void add(char o);
    
    /**
     * Removes a character from our CharSet.
     * 
     * @param o char to removed.
     */
    public void remove(char o);
    
    /**
     * Indicates if a character is in our CharSet.
     * 
     * @param o char to be checked.
     * @return boolean indicating if o is in our CharSet.
     */
    public boolean contains(char o);
    
    /**
     * Indicates number of elements in our CharSet.
     * 
     * @return int indicating number of elements in our CharSet.
     */
    public int size();
    
}
