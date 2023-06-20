//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends

class Solution {
    static int findMaxLen(String S) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<S.length(); i++)
        {
            char ch = S.charAt(i);
            if(ch=='(')
                st.push(i);
            else
                if( !st.isEmpty() && S.charAt(st.peek())=='(' )
                    st.pop();
                else
                    st.push(i);
        }
        
        int max = 0;
        int n = S.length();
        while(!st.isEmpty())
        {
            int i = st.pop();
            max = Math.max(max,n-i-1);
            n = i;
        }
        return Math.max(max,n);
    }
};