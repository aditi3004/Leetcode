//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Pair implements Comparable<Pair>{
    int wt;
    int v;
    Pair(int v,int wt){
        this.v=v;
        this.wt=wt;
    }
   public int compareTo(Pair that){
       return this.wt-that.wt;
   }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	     ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
	    
	    for(int i = 0;i<V;i++){
	        adj.add(new ArrayList<ArrayList<Integer>>());
	    }
	  
	    for(int i = 0;i<edges.length;i++){
	        ArrayList<Integer> temp = new ArrayList<>();
	        temp.add(edges[i][1]);
	        temp.add(edges[i][2]);
	        adj.get(edges[i][0]).add(temp);
	        
	        temp = new ArrayList<>();
	        temp.add(edges[i][0]);
	        temp.add(edges[i][2]);
	        adj.get(edges[i][1]).add(temp);

	    }
	    
	  boolean[] vis=new boolean[V];
	  PriorityQueue<Pair> q=new PriorityQueue<>();
	  q.add(new Pair(0,0));
	  int ans=0;
	  while(q.size()!=0){
	      Pair cur=q.remove();
	      int u=cur.v;
	      if(vis[u]){
	          continue;
	      }
	      ans+=cur.wt;
	      vis[u]=true;
	      ArrayList<ArrayList<Integer>> neighbour=adj.get(u);
	      for(ArrayList<Integer> list:neighbour){
	          int vertex=list.get(0);
	          int wt=list.get(1);
	          if(vis[vertex]==false){
	              q.add(new Pair(vertex,wt));
	          }
	      }
	  }
	  return ans;
	}
}