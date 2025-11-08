import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int l = 0 ; l < n ; l ++ ) {
			
			int len = Integer.parseInt(br.readLine());
			String [] elements = br.readLine().split(" ");
			
			int [] arr = new int [len];
			for(int i = 0 ; i < len ; i ++ ) {
				arr[i] = Integer.parseInt(elements[i]);
			}
			
			int target = Integer.parseInt(br.readLine());

			int [][] dp = new int[target + 1][len];	
			
			for(int j = 0 ; j < len ; j ++ ) {
				if(arr[j] <= target) {
					dp[arr[j]][j] = 1;
				}
			}
			
			for(int i = 0 ; i < target + 1 ; i ++) {
				for(int j = 0 ; j < len ; j ++ ) {
					if(i - arr[j] >= 0){
						int sum = 0;
						for(int k = 0 ; k < j + 1 ; k ++ ) {
							sum += dp[i - arr[j]][k];
						}
						dp[i][j] += sum;
					}
				}
				
			}
			
			int result = 0;
			
			for(int j = 0 ; j < len ; j ++ ) {
				result += dp[target][j];
			}

			System.out.println(result);
			
		}
		
	}

}
