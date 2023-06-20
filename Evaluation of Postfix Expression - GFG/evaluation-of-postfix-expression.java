//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)>='0' && S.charAt(i)<='9'){
                st.push((int)S.charAt(i)-48);
            }
            else{
                if(S.charAt(i)=='*'){
                    int a=st.pop();
                    int b=st.pop();
                    st.push(b*a);
                }
                else if(S.charAt(i)=='/'){
                    int a=st.pop();
                    int b=st.pop();
                    st.push(b/a);
                }
                else if(S.charAt(i)=='+'){
                    int a=st.pop();
                    int b=st.pop();
                    st.push(b+a);
                }
                else if(S.charAt(i)=='-'){
                    int a=st.pop();
                    int b=st.pop();
                    st.push(b-a);
                }
            }
        }
        return st.pop();
    }
}