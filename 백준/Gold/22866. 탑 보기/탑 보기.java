import java.util.*;
import java.io.*;

public class Main{
	
	static int [] arr;
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int [N];
		
		String [] input = br.readLine().split(" ");
		for(int i = 0 ; i < N ; i ++ ) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int [][] answer = new int [N][2];
		for(int i = 0 ; i < N ; i ++ ){
			answer[i][1] = -1;
		}

		Stack<Integer> stk = new Stack<>();

		//왼쪽
		for(int i = 0 ; i < N ; i ++ ) {
			int cur = arr[i]; // 현재 건물 : 현재 건물의 높이보다 높은것만 볼 수 있음

			while(!stk.empty()){
				if(arr[stk.peek()] <= cur) {
					stk.pop();
				}
				else{
					break;
				}
			}

			if(!stk.empty()){
				answer[i][0] = stk.size();
				answer[i][1] = stk.peek() + 1;
			}

			stk.push(i);
		}


		//오른쪽
		stk = new Stack<>();

		for(int i = N - 1 ; i > -1 ; i-- ) {
			int cur = arr[i]; // 현재 건물 : 현재 건물의 높이보다 높은것만 볼 수 있음
			
			while(!stk.empty()){
				if(arr[stk.peek()] <= cur) {
					stk.pop();
				}
				else{
					break;
				}
			}

			if(!stk.empty()){
				answer[i][0] += stk.size();
				if(answer[i][1] == -1){
					answer[i][1] = stk.peek() + 1;
				}
				else{
					//거리가 가장 가까운거
					int dis_a = Math.abs(i - (answer[i][1] - 1));
					int dis_b = Math.abs(i - stk.peek());
					if(dis_a > dis_b){
						answer[i][1] = stk.peek() + 1;
					}
				}
			}

			stk.push(i);
		}


		//print answer
		for(int i = 0 ; i < N ; i ++ ) {
			if(answer[i][1] == -1){
				System.out.println(0);
			}
			else{
				System.out.println(answer[i][0] + " "  + answer[i][1]);
			}
		}
		
		
	}
	
}