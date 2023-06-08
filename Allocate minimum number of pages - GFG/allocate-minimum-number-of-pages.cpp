//{ Driver Code Starts
// Initial template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template in C++

class Solution 
{
    public:
    //Function to find minimum number of pages.
    int findPages(int A[], int N, int M) {
        if(N<M){
            return -1;
        }
    int start = 0; // Initialize the start of the search range
    int sum = 0; // Initialize the sum of all pages
    for (int i = 0; i < N; i++) {
        sum += A[i]; // Calculate the sum of all pages
    }

    int end = sum; // Initialize the end of the search range
    int ans = -1; // Initialize the answer variable
    int mid;

    while (start <= end) {
        mid = start + (end - start) / 2; // Calculate the middle value

        if (isPossible(A, N, M, mid)) {
            ans = mid; // Update the answer
            end = mid - 1; // Adjust the end of the search range
        } else {
            start = mid + 1; // Adjust the start of the search range
        }
    }

    return ans; // Return the minimum number of pages
    }
    bool isPossible(int A[], int N, int M, int mid) {
    int studentCount = 1; // Initialize the student count to 1
    int pageSum = 0; // Initialize the page sum to 0

    for (int i = 0; i < N; i++) {
        if (pageSum + A[i] <= mid) {
            pageSum += A[i]; // Accumulate the page sum
        } else {
            studentCount++; // Increment the student count
            if (studentCount > M || A[i] > mid) {
                return false; // Return false if the student count exceeds the given limit or the current page exceeds the maximum limit
            }

            pageSum = A[i]; // Reset the page sum to the current page
        }
    }

    return true; // Return true if all the pages can be distributed among the students
}
};

//{ Driver Code Starts.

int main() {
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int A[n];
        for(int i=0;i<n;i++){
            cin>>A[i];
        }
        int m;
        cin>>m;
        Solution ob;
        cout << ob.findPages(A, n, m) << endl;
    }
    return 0;
}

// } Driver Code Ends