import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		Set<Integer> coins = new HashSet<>();
		
		for(int i = 0 ; i < n ; i ++ ) {
			int coin = Integer.parseInt(br.readLine());
			coins.add(coin);
		}
		
		List<Integer> coinList = new ArrayList<>();
		for(Integer value : coins) {
			coinList.add(value);
		}
		Collections.sort(coinList);
		
		int [] dp = new int [k + 1];
		
		for(int i = 0 ; i< coinList.size() ; i ++ ) {
			int cur_coin = coinList.get(i);
			for(int j = 0 ; j < k + 1 ; j ++ ) {
				if(j - cur_coin == 0) {
					dp[j] = 1;
				}
				else if(j - cur_coin > 0 && dp[j - cur_coin] != 0) {
					if(dp[j] == 0) {
						dp[j] = dp[j - cur_coin] + 1;
					}
					else{
						dp[j] = Math.min(dp[j], dp[j - cur_coin] + 1);
					}
				}
			}
			
		}
		
		if(dp[k] == 0) {
			System.out.print(-1);
		}
		else {
			System.out.print(dp[k]);
		}
		
		
	}
	
}
