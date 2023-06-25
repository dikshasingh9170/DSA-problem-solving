class Solution {
    public int longestString(int x, int y, int z) {
         int result = z * 2;
         result+= (x > y) ? (2 * y + (y + 1) * 2) : (y > x) ? (2 * x + (x + 1) * 2) : (4 * x);
            return result;
    }
}