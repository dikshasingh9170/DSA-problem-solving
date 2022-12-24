//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        String s=x;
        Stack<Character> st=new Stack<Character>();
        if(s.length()==0){
            return true;
        }
        st.push(s.charAt(0));char z=0;int flag=0;
        for(int i=1;i<s.length();i++){
            if(!st.isEmpty()){
                z=st.pop();
                if(s.charAt(i)==')' && z=='('){
                    continue;
                }
                else if(s.charAt(i)=='}' && z=='{'){
                    continue;
                }
                else if(s.charAt(i)==']' && z=='['){
                    continue;
                }
                else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}'){
                    return false;
                }
                st.push(z);
                st.push(s.charAt(i));
                z=0;
            }
            else{
                st.push(s.charAt(i));
            }
        }
            if(st.size()==0){
            return true;
            }
        return false;
    }
}
