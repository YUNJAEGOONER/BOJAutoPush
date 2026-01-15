import java.util.*;
import java.io.*;

public class Main{
	
	static int [] arr;
	
	static int [] count;
	
	public static void main(String [] args) throws IOException{
		
		
		//F(A) : 수열에서의 등장 횟수 
		//F(1) : 3 = 1이 3번 등장함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String [] input = br.readLine().split(" ");
		arr = new int [n];
		//count 
		count = new int[1_000_001];
		
		for(int i = 0 ; i < n ; i ++ ) {
			arr[i] = Integer.parseInt(input[i]);
			count[arr[i]] ++;
		}
		
		int [] answer = new int [n];
		
		for(int i = 0 ; i < n ; i ++ ) {
			answer[i] = -1;
		}

				
		ArrayDeque<Integer> stk = new ArrayDeque<>(); //index
		
		for(int i = n - 1 ; i > -1 ; i --) {
			int cur = count[arr[i]];
			
			while(!stk.isEmpty()) {
				if(count[arr[stk.peek()]] > cur) {
					answer[i] = arr[stk.peek()];
					break;
				}
				else {
					stk.pop();
				}
			}
			
			stk.push(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i ++ ) {
			sb.append(answer[i]);
			sb.append(" ");
		}
		System.out.println(sb);
		

	}
	
}