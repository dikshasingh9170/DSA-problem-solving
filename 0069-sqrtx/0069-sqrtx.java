class Solution {
    public int mySqrt(int x) {
        if(x==1){
            return 1;
        }
        double l = 0, h = x;double m=0.0;int res=0;
        while (l<=h)
        {
            m =Math.floor(l+(h-l)/2);
            if (m * m < x)
            {
                l = m+1;
                res=(int)m;
            }
            else if(m*m>x)
            {
                h = m-1;
            }
            else{
                return (int)m;
            }
        }
        return res;
    }
}