package staff.sol;


public class BitVectorCharSet implements CharSet {

    private static boolean CHECK_REP = false;
    
    private long[] chars;
    private int size;
    
    public BitVectorCharSet() {
        this.chars = new long[1024];
    }
    
    @Override
    public void add(char o) {
        int charsIndex = getCharsIndex(o);
        long bitSegment = chars[charsIndex];
        long bitPosition = 1 << getBitPosition(o);

        if ((bitSegment & bitPosition) == 0) {
            size ++;
        }
        
        chars[charsIndex] = bitSegment | bitPosition;
        if (CHECK_REP) checkRep();
    }

    @Override
    public void remove(char o) {
        int charsIndex = getCharsIndex(o);
        long bitSegment = chars[charsIndex];
        long bitPosition = -1 ^ (1 << getBitPosition(o));
        
        size--;
        
        chars[charsIndex] = bitSegment & bitPosition;
        if (CHECK_REP) checkRep();
    }

    @Override
    public boolean contains(char o) {
        int charsIndex = getCharsIndex(o);
        long bitSegment = chars[charsIndex];
        long bitPosition = 1 << getBitPosition(o);

        if (CHECK_REP) checkRep();
        return (bitSegment & bitPosition) != 0;
    }

    @Override
    public int size() {
        if (CHECK_REP) checkRep();
        return size;
    }
    
    private void checkRep() {
        // Check size field corresponds with the correct size.
        int size = 0;
        for (long l : chars) {
            size += getNumberOfSetBits(l);
        }
        assert this.size == size;
    }
    
    private static int getCharsIndex(char o) {
        return (int) (((long) o) / 64);
    }
    private static int getBitPosition(char o) {
        return (int) (((long) o) % 64);
    }
    private static long getNumberOfSetBits(long i)
    {
        i = i - ((i >> 1) & 0x5555555555555555l);
        i = (i & 0x3333333333333333l) + ((i >> 2) & 0x3333333333333333l);
        return (((i + (i >> 4)) & 0xF0F0F0F0F0F0F0Fl) * 0x101010101010101l) >> 56;
    }
}
