package staff.sol;

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
        if (!chars.contains(o)) {
            chars.add(o);
        }
        if (CHECK_REP) checkRep();
    }

    @Override
    public void remove(char o) {
        chars.remove(o);
        if (CHECK_REP) checkRep();
    }

    @Override
    public boolean contains(char o) {
        if (CHECK_REP) checkRep();
        return chars.contains(o);
    }

    @Override
    public int size() {
        if (CHECK_REP) checkRep();
        return chars.size();
    }

    private void checkRep() {
        // List should have no 'null' objects.
        for (int i = 0; i < chars.size(); i++) {
            assert chars.get(i) != null;
        }
        
        // List should have no duplicate objects.
        for (int i=0; i < chars.size(); i++) {
            for (int j = i+1; j < chars.size(); j++) {
                assert chars.get(i) != chars.get(j);
            }
        }
    }
}
