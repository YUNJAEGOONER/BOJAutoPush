import java.io.*;

public class Solution {
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
	
		for(int t = 0 ; t < test ; t ++ ) {
			
			long answer = Long.MIN_VALUE;
			
			String NM [] = br.readLine().split(" ");
			
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			int [] n = new int [N];
			String input_n [] = br.readLine().split(" ");
			for(int i = 0 ; i < N ; i ++ ) {
				n[i] = Integer.parseInt(input_n[i]);
			}
			
			int [] m = new int [M];
			String input_m [] = br.readLine().split(" ");
			for(int i = 0 ; i < M ; i ++ ) {
				m[i] = Integer.parseInt(input_m[i]);
			}
		
			
			if(N > M){ // M이 짧은거 
				for(int k = 0 ; k < (N - M + 1) ; k ++ ) {
					int sum = 0;
					for(int i = 0 ; i < M ; i ++ ) {
						sum += (m[i] * n[k + i]);
					}
					if(sum > answer) answer = sum;
				}
			}
			else {
				for(int k = 0 ; k < (M - N + 1) ; k ++ ) {
					int sum = 0;
					for(int i = 0 ; i < N ; i ++ ) {
						sum += (n[i] * m[k + i]);
					}
					if(sum > answer) answer = sum;
				}
			}
			
			System.out.println("#" + (t + 1) + " " + answer);
			
		}
		
		
	}

}
