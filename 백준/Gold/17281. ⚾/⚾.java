import java.util.*;
import java.io.*;

public class Main {
	
	//(0), 1, 2, 3
	static int [] bases = new int [4];
	
	public static int run(int n) {
		int count = 0;
		if(n == 4) { //home run
			for(int i = 1 ; i < 4 ; i ++ ) {
				if(bases[i] == 1) {
					count ++;
					bases[i] = 0;
				}
			}
			return count + 1;
		}
		
		else {
			for(int i = 3 ; i > 0 ; i -- ) {
				if(bases[i] == 1) {
					if(i + n >= 4) {
						bases[i] = 0;
						count ++;
					}
					else {
						bases[i] = 0;
						bases[i + n] = 1;
					}
				}
			}
			bases[n] = 1;
		}
		return count;
	}
		
	public static void initBases() {
		for(int i = 0 ; i < bases.length ; i ++ ) {
			bases[i] = 0;
		}
	}
	
	
	static int [][] batter;
	
	static int n;
	
	static int max = -1;
	
	public static void playBaseBall(List <Integer> order) {
		
		
		int result = 0;
		int hong = 0;
	
		
		for(int i = 0 ; i < n ; i ++) {
			int out = 0;
			initBases();
			while(out != 3) {
				if(batter[i][order.get(hong)] == 0) {
					out ++;
				}
				else {
					int score = run(batter[i][order.get(hong)]);
					result += score;
				}
				hong ++;
				hong %= 9;
			}
		}
		
		if(result > max) {
			max = result;
		}
		
	}
	
	
	static int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
	
	static int [] visited = new int [8];
	
	static int count = 0;
	
	public static void permu(int depth, List<Integer> list) {
		
		if(list.size() == 8) {
			list.add(3, 0);
			playBaseBall(list);
			list.remove(3);
			return;
		}
		
		for(int i = 0 ; i < arr.length ; i ++) {
			if(visited[i] == 0) {
				list.add(arr[i]);
				visited[i] = 1;
				permu(depth + 1, list);
				visited[i] = 0;
				list.remove(list.size() - 1);
			}
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		batter = new int[n][9];
		
		for(int i = 0 ; i < n ; i ++ ) {
			String [] input = br.readLine().split(" ");
			for(int j = 0 ; j < 9 ; j ++ ) {
				batter[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		permu(0, new ArrayList<Integer>());
		
		System.out.print(max);
		
	}
	
}
