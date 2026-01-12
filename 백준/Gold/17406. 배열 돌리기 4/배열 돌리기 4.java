import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{

	static int [][] arr;

	static int [][] tempArr;

	static boolean [] visited;

	static List<Pair> pairList;

	static int answer = Integer.MAX_VALUE;

	public static class Pair{
		int r;
		int c;
		int s;
		public Pair(int r, int c, int s){
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void getAnswer() {
		for(int i = 0 ; i < tempArr.length ; i ++ ) {
			int sum = 0;
			for(int j = 0 ; j < tempArr[i].length ; j ++ ) {
				sum += tempArr[i][j];
			}
			answer = Math.min(answer, sum);
		}
	}
	
	public static void rotateMatrix(int r, int c, int s) {
		
		int [][] narr = new int [arr.length][arr[0].length];

		for(int i = 0 ; i < arr.length ; i ++ ) {
			narr[i] = tempArr[i].clone();
		}
	
		// 가장 왼쪽 윗칸 (r - s, c - s); // 시작칸
		// 오른쪽 아랫칸(r + s, c + s); // 끝 칸
		int start_x = r - s - 1;
		int start_y = c - s - 1;

		int move = 2 * s;

		while(move != 0){
			int idx = start_x;
			int jdx = start_y;

			//우츧
			for (int t = 0 ; t < move ; t ++ ){
				narr[idx][jdx + 1] = tempArr[idx][jdx];
				jdx ++;
			}

			//아래
			for (int t = 0 ; t < move ; t ++ ){
				narr[idx + 1][jdx] = tempArr[idx][jdx];
				idx ++;
			}

			//좌측
			for (int t = 0 ; t < move ; t ++ ){
				narr[idx][jdx - 1] = tempArr[idx][jdx];
				jdx --;
			}

			//좌측
			for (int t = 0 ; t < move ; t ++ ){
				narr[idx - 1][jdx] = tempArr[idx][jdx];
				idx -- ;
			}

			start_x ++;
			start_y ++;

			move -= 2;
		}
		
		//clone 
		for(int i = 0 ; i < arr.length ; i ++ ) {
			tempArr[i] = narr[i].clone();
		}

	}

	static int a = 0;

	public static void combi(List<Integer> temp){
		if(temp.size() == visited.length){

			tempArr = new int [arr.length][arr[0].length]; // 회전을 위한 임시 배열

			for(int i = 0 ; i < arr.length ; i ++ ) {
				tempArr[i] = arr[i].clone();
			}

			for(int i = 0 ; i < temp.size() ; i ++ ){
				Pair pair = pairList.get(temp.get(i));
				rotateMatrix(pair.r, pair.c, pair.s);
			}

			getAnswer();
			return;
		}

		for(int i = 0 ; i < visited.length ; i ++ ){
			if(!visited[i]){
				visited[i] = true;
				temp.add(i);
				combi(temp);
				temp.remove(temp.size() - 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] NMK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NMK[0]); // 배열
		int M = Integer.parseInt(NMK[1]); // 배열
		int K = Integer.parseInt(NMK[2]); // 회전 연산의 개수 
		
		arr = new int [N][M]; // 원본 배열
		
		for(int i = 0 ; i < N ; i ++ ) {
			String [] input = br.readLine().split(" ");
			for(int j = 0 ; j < M ; j ++ ) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		pairList = new ArrayList<>();
		visited = new boolean[K];

		//연산 횟수 K번
		for(int i = 0 ; i < K ; i ++ ) {
			String [] rcs = br.readLine().split(" ");
			int r = Integer.parseInt(rcs[0]);
			int c = Integer.parseInt(rcs[1]);
			int s = Integer.parseInt(rcs[2]);
			pairList.add(new Pair(r, c, s));
		}
		combi(new ArrayList<>());
		System.out.print(answer);

	}
	
}