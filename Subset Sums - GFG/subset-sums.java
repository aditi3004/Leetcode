//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        int sum=0;
        ArrayList<Integer> ans=new ArrayList<Integer>();
        f(arr,ans,0,sum);
        Collections.sort(ans);
        return ans;
    }
    
    public void f(ArrayList<Integer> arr,ArrayList<Integer> ans,int index,int sum){
        ans.add(sum);
        for(int i=index;i<arr.size();i++){
            if(i==arr.size()){
                //sum=0;
                return;
            }
            
            sum=sum+arr.get(i);
            f(arr,ans,i+1,sum);
            sum=sum-arr.get(i);
        }
    }
}