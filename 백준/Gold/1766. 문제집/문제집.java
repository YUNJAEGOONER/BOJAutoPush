import java.io.*;
import java.util.*;

public class Main {
	
	static List<List<Integer>> adj;
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		adj = new ArrayList<>();
		for(int i = 0 ; i < N ; i ++ ) {
			adj.add(new ArrayList<>());
		}
		
		int [] inDegree = new int [N];
		
		for(int i = 0 ; i < M ; i ++ ) {
			String [] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]) - 1;
			int b = Integer.parseInt(ab[1]) - 1;
			inDegree[b] ++; 
			adj.get(a).add(b);
		}
		
		//기본적으로 오름차순 
		PriorityQueue<Integer> mq = new PriorityQueue<>();
		
		for(int i = 0 ; i < N ; i ++) {
			if(inDegree[i] == 0) {
				mq.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!mq.isEmpty()) {
			int cur = mq.poll();
			sb.append(cur + 1).append(" ");
			
			List<Integer> adjNode = adj.get(cur);
			for(Integer node : adjNode) {
				inDegree[node] --;
				if(inDegree[node] == 0) {
					mq.add(node);
				}
			}
		}
		
		System.out.print(sb);
			
	}
}
