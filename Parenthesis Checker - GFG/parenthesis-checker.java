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
        if(x==""){
            return true;
        }
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<x.length();i++){
            if(st.isEmpty()==false){
                char a=st.peek();
                if(x.charAt(i)=='(' || x.charAt(i)=='{' || x.charAt(i)=='['){
                    st.push(x.charAt(i));
                }
                else if(a=='(' || a=='{' || a=='['){
                    if(a=='(' && x.charAt(i)==')'){
                        st.pop();
                    }
                    else if(a=='{' && x.charAt(i)=='}'){
                        st.pop();
                    }
                    else if(a=='[' && x.charAt(i)==']'){
                        st.pop();
                    }
                    else{
                        st.push(x.charAt(i));
                    }
                }
                else{
                    st.push(x.charAt(i));
                }
            }
            else{
                st.push(x.charAt(i));
            }
        }
        return st.isEmpty();
    }
}
