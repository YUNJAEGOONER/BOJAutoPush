import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		String [] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		List<List<Integer>> mmap = new ArrayList<>();
		
		for(int i = 0 ; i < N + 1 ; i ++ ) {
			mmap.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < M ; i ++ ) {
			String [] uv = br.readLine().split(" ");
			int u = Integer.parseInt(uv[0]);
			int v = Integer.parseInt(uv[1]);
			mmap.get(u).add(v);
			mmap.get(v).add(u);
		}
		
		boolean [] visited = new boolean[N + 1];
		
		int disconnected = 0;
		
		int count = 0; //총 몇 덩어리인지...
		
		
		
		for(int i = 1 ; i < N + 1 ; i ++) {
			int size = 0;
			Set<Integer> temp = new HashSet<>();
			Queue<Integer> mq = new LinkedList<>();
			if(visited[i] == false) {
				count ++;
				size ++;
				mq.add(i);
				temp.add(i);
				visited[i] = true;
				while(!mq.isEmpty()) {
					int cur = mq.poll();
					List<Integer> arr = mmap.get(cur);
					for(int j = 0 ; j < arr.size() ; j ++ ) {
						int next = arr.get(j);
						if(!visited[next]) {
							size ++;
							visited[next] = true;
							mq.add(next);
							temp.add(next);
						}
					}
				}
				
				int total = 0;
				for(int node : temp) {
					total += mmap.get(node).size();
				}
				
				disconnected += (total/2) - (size - 1);
				
			}
			
		}
		
		
		System.out.println(disconnected + (count - 1));
		
	
		
	}
	
	
	
}
