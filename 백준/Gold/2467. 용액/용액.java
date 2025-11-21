import java.io.*;

public class Main {
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int [n];
		
		String [] input = br.readLine().split(" ");
		
		for(int i = 0 ; i < n ; i ++ ) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int start = 0;
		int end = n - 1;
		long min = Math.abs(arr[start] + arr[end]);
		
		int min_s = start;
		int min_e = end;
		
		while(start < end) {
			
			long sum = arr[start] + arr[end];
		
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				min_s = start;
				min_e = end;
			}
			
			
			if(sum > 0) {
				end --;
			}
			else{
				start ++;
			}
			
			
		}
		
		System.out.print(arr[min_s] + " " + arr[min_e]);
		
	}

}
