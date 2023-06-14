class Solution {
    static double eps = 1e-6;
    public int mySqrt(int x) {
        double l = 1, h = x, m=0;
        while (h - l > eps)
        {
            m = (l + h) / 2;
            if (m * m < x)
            {
                l = m;
            }
            else
            {
                h = m;
            }
        }
        return (int)h;
    }
}