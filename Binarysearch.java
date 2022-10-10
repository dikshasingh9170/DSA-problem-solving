import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;
import java.math.*;

public class Binarysearch {

	public static void main(String[] args){
		FastScanner sc = new FastScanner();
        Binarysearch ob=new Binarysearch();
		int n=sc.nextInt();
        int x=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int result=ob.binarysearch(arr,0,n-1,x);
        if(result==-1){
            System.out.println("Element not present");
        }
        else{
            System.out.println("Element found at index "+result);
        }
		}
        public int binarysearch(int[] arr,int l,int r,int x){
            if(r>=l){
                int mid=l+(r-l)/2;
            if(arr[mid]==x){
                return mid;
            }
            if(arr[mid]>x){
                return binarysearch(arr,l,mid-1,x);
            }
            return binarysearch(arr,mid+1,r,x);
        }
        return -1;
    }
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
		String nextString(){
		    return nextToken();
		}
	}
}