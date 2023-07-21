//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String s) {
        // Code here
        StringBuilder str=new StringBuilder();
        boolean[] freq=new boolean[s.length()];
        HashSet<String> l=new HashSet<>();
        
        permut(s,l,freq,str);
        
        List<String> ans=new ArrayList<>(l);
        Collections.sort(ans);
        
        return ans;
    }
    public void permut(String s,HashSet<String>res,boolean[] freq,StringBuilder str){
        
        if(str.length()==s.length()){
            res.add(String.valueOf(str));
            return;
        }
        
        for(int i=0;i<s.length();i++){
            if(freq[i]==false){
                freq[i]=true;
                str.append(s.charAt(i));
                permut(s,res,freq,str);
                str.deleteCharAt(str.length()-1);
                freq[i]=false;
            }
        }
    }
}