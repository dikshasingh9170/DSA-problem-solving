//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
        Stack<Character> st=new Stack<Character>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/'){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                boolean isRedundant=true;
                while(st.peek()!='('){
                if(st.peek()=='+' || st.peek()=='-' || st.peek()=='*' || st.peek()=='/'){
                    isRedundant=false;
                }
                st.pop();
                }
                st.pop();
                if(isRedundant==true){
                    return 1;
                }
            }
        }
        return 0;
    }
}
        
