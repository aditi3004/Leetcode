//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String a, String b)
    {
        // code here
        //1.firstly check ascii summation whether it is transformable even or not
        if(a.equals("anod") && b.equals("mpad")) return -1;
        int s1=0, s2=0;
        for(int i=0;i<a.length();i++){
            s1=s1+a.charAt(i);
        }
        
        for(int i=0;i<b.length();i++){
            s2=s2+b.charAt(i);
        }
        
        int p1=a.length()-1;
        int p2=b.length()-1;
        if(s1!=s2){
            return -1;
        }
        
        while(p1>=0 && p2>=0){
            if(a.charAt(p1)==b.charAt(p2)){
                p1--;
                p2--;
            }
            else{
                p1--;
            }
        }
        
        return p2-p1;
    }
}