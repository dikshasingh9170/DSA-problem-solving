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


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if(c=='('){
                st.push(i);
            }
            else{
                if(!st.isEmpty() && S.charAt(st.peek())=='('){
                    st.pop();
                }
                else{
                    st.push(i);
                }
            }
        }
        int max=0;int n=S.length();
        while(st.size()>0){
            int i=st.pop();
            max=Math.max(max,n-i-1);
            n=i;
        }
        max=Math.max(max,n);
        return max;
    }
};