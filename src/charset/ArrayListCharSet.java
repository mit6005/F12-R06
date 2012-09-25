package charset;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCharSet implements CharSet {
    
    private static boolean CHECK_REP = false;
    
    private List<Character> chars;
    
    public ArrayListCharSet() {
        this.chars = new ArrayList<Character>();
    }
    
    @Override
    public void add(char o) {
        // TODO Complete this implementation!
        throw new RuntimeException("Not yet implemented!");
    }

    @Override
    public void remove(char o) {
        // TODO Complete this implementation!
        throw new RuntimeException("Not yet implemented!");
    }

    @Override
    public boolean contains(char o) {
        // TODO Complete this implementation!
        throw new RuntimeException("Not yet implemented!");
    }

    @Override
    public int size() {
        // TODO Complete this implementation!
        throw new RuntimeException("Not yet implemented!");
    }
    
    /**
     * Checks all representation invariants.
     */
    private void checkRep() {
        // TODO Write a few representation invariants required
        //      for this implementation.
    }
}
