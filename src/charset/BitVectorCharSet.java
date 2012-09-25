package charset;


public class BitVectorCharSet implements CharSet {

    private static boolean CHECK_REP = false;
    
    private long[] chars;
    private int size;

    public BitVectorCharSet() {
        this.chars = new long[1024];
    }
    
    @Override
    public void add(char o) {
        // add() is already implemented.
        //   Use getCharsIndex() to get the group of 64 bits (long) 
        //      that o is represented in.
        //   Use getBitPosition() to get the actual position of the
        //      representation.
        //
        //   << is the SHIFT LEFT bit operator, | is the OR bit operator:
        //      1 << 5 
        //          --> 0b100000
        //      (0b1001010) | (1 << 5)
        //          --> 1 0 0 1 0 1 0
        //            |   1 0 0 0 0 0
        //              1 1 0 1 0 1 0
        //          --> 0b1101010
        //
        int charsIndex = getCharsIndex(o);
        long bitSegment = chars[charsIndex];
        long bitPosition = 1 << getBitPosition(o);

        chars[charsIndex] = bitSegment | bitPosition;
    }

    @Override
    public void remove(char o) {
        // TODO Complete this implementation!
        //      HINT: -1 = 0b11111...111
        //            ^ is the XOR bit operator
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
        //      HINT: Use getNumberOfSetBits to count number of bits in your 
        //          long that is currently set to 1.
    }
    
    /**
     * As per our representation, returns the group of 64 bits (long) that the
     * input char is located.
     * 
     * <pre>
     * Example: 
     *      getCharsIndex('i') -->
     *          'i' == 105 
     *          chars == { '64 bits'  ,   '64 bits'  , ... ,   '64 bits'   }
     *                       0 - 63    ,  64 - 127   , ... , 65472 - 65535
     *          'i' is in the 2nd group of '64 bits'
     *                --> return 1;
     * </pre>
     * @param o input char
     * @return index in our array of longs indicating where the bit is located.
     */
    private static int getCharsIndex(char o) {
        return (int) (((long) o) / 64);
    }
    
    
    /**
     * As per our representation, returns the bit position of the group of 64
     * bits (long) that our input char is located.
     * 
     * <pre>
     * Example: 
     *      getBitPosition('i') -->
     *          'i' == 105
     *          bits = long or '64 bits' of the second group 
     *                      (as returned by getCharsIndex)
     *                 '_127_ _126_ ... _106_ _105_ _104_ ... _66_ _65_ _64_'
     *                    63    62  ...   42    41    40  ...   2    1    0
     *                                         ^^^
     *               --> return 41;
     * </pre>
     * @param o input char
     * @return int indicating bit position in the long containing the bit 
     *      representing the input char. 
     */
    private static int getBitPosition(char o) {
        return (int) (((long) o) % 64);
    }
    
    
    /**
     * Bit twiddling function to count the number of set bits in the input long.
     * 
     * <pre>
     * Example:
     *      getNumberOfSetBits(232)
     *              232 = 0b11101000
     *              --> return 4;
     * </pre>
     * @param i
     * @return
     */
    private static long getNumberOfSetBits(long i)
    {
        i = i - ((i >> 1) & 0x5555555555555555l);
        i = (i & 0x3333333333333333l) + ((i >> 2) & 0x3333333333333333l);
        return (((i + (i >> 4)) & 0xF0F0F0F0F0F0F0Fl) * 0x101010101010101l) >> 56;
    }
}
