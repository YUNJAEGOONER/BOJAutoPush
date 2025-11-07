import java.io.*;
import java.util.*;

public class Main {
	
	public static class Pair{
		int w;
		int v;
		public Pair(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
	
	public static void main(String [] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String input = br.readLine();
		String [] inputArray = input.split(" ");
		
		int N = Integer.parseInt(inputArray[0]);
		int K = Integer.parseInt(inputArray[1]);
		
		Map<Integer, Pair> products = new HashMap<>();
		
		for(int i = 0 ; i < N ; i ++ ) {
			String [] str = br.readLine().split(" "); 
			products.put(i, new Pair(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
		}
		
		
		int dp [][] = new int[N][K + 1];
		
		int max = 0;
		
		for(int j = 0 ; j < K + 1 ; j ++ ) {
			if(j >= products.get(0).w) {
				dp[0][j] = products.get(0).v;
				if(dp[0][j] > max) {
					max = dp[0][j];
				}
			}
		}
		
		
		for(int i = 1 ; i < N ; i ++ ) {
			int cur_w = products.get(i).w;
			int cur_v = products.get(i).v;
	
			for(int j = 0 ; j < K + 1 ; j ++) {
				if(j - cur_w >= 0) { // 넣을 수 있는 경우 (넣는 경우와 안는 경우를 비교)
					if(dp[i-1][j - cur_w] + cur_v > dp[i - 1][j]) {
						dp[i][j] = dp[i-1][j - cur_w] + cur_v; // 넣는 경우 
					}
					else {
						dp[i][j] = dp[i - 1][j];
					}
					
				}
				else { //지금 차례를 넣지 못하는 경우...
					dp[i][j] = dp[i - 1][j];
				}
				if(dp[i][j] > max) {
					max = dp[i][j];
				}
			}
		
		}
		
		System.out.print(max);
		

	}

}