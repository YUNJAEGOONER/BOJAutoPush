import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr;
	static int M;
	static boolean[][] eraseList;
	static boolean [][] unavail;

	static int[] dir_x = { -1, 0, 1, 0 };
	static int[] dir_y = { 0, 1, 0, -1 };

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void avg(){

		int sum = 0;
		int cnt = 0;

		for(int i = 1 ; i < arr.length ; i ++ ){
			for(int j = 0 ; j < M ; j ++){
				if(!unavail[i][j]){
					sum += arr[i][j];
					cnt ++;
				}
			}
		}

		double avg = (double)sum / cnt;
		
		for(int i = 1 ; i < arr.length ; i ++ ){
			for(int j = 0 ; j < M ; j ++){
				if(!unavail[i][j]){
					if((double) arr[i][j] < avg){
						arr[i][j]++;
					}
					else if((double) arr[i][j] > avg){
						arr[i][j]--;
					}
				}
			}
		}
	}
	
	public static boolean eraseAdj() {

		boolean check = false;

		for (int idx = 1; idx < arr.length; idx++) {
			for (int jdx = 0; jdx < M; jdx++) {
				for (int d = 0; d < 4; d++) {
					int nx = idx + dir_x[d];
					int ny = jdx + dir_y[d];

					if(0 > nx) nx += arr.length;
					if(0 > ny) ny += M;

					nx %= arr.length;
					ny %= arr[0].length;

					if ((!unavail[idx][jdx] && !unavail[nx][ny]) && (arr[idx][jdx] == arr[nx][ny])) {
						eraseList[idx][jdx] = true;
					}

				}		
			}
		}
		
		for(int i = 1 ; i < arr.length ; i ++ ) {
			for (int j = 0; j < M; j++) {
				if (eraseList[i][j]) {
					arr[i][j] = 0;
					unavail[i][j] = true;
					check = true;
				}
			}
		}

		return check;
	}

	public static void rotate(int idx, int k, int d) {

		// k칸 만큼 D방향으로
		int start = 0;
		int[] rotated = new int[M];
		boolean [] rotateUn = new boolean[M];
		if (d == 0) {
			start -= k;
			for (int j = 0; j < M; j++) {
				if (start < 0)
					start += M;
				int s = start % M;
				rotated[j] = arr[idx][s];
				rotateUn[j] = unavail[idx][s];
				start++;
			}
			arr[idx] = rotated;
			unavail[idx] = rotateUn;
		} else {
			start += k;
			for (int j = 0; j < M; j++) {
				int s = start % M;
				rotated[j] = arr[idx][s];
				rotateUn[j] = unavail[idx][s];
				start++;
			}
			arr[idx] = rotated;
			unavail[idx] = rotateUn;
		}

	}

	public static int getSum() {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMT = br.readLine().split(" ");

		int N = Integer.parseInt(NMT[0]); // N개의 원판이 존재
		M = Integer.parseInt(NMT[1]); // 원판의 숫자 수
		int T = Integer.parseInt(NMT[2]); // 회전 수

		arr = new int[N + 1][M];
		unavail = new boolean[N + 1][M];

		for (int i = 1; i < N + 1; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int t = 0; t < T; t++) {
			String[] XDK = br.readLine().split(" ");
			int X = Integer.parseInt(XDK[0]); // X의 배수
			int D = Integer.parseInt(XDK[1]); // D방향으로 (0 시계, 1 반시계)
			int K = Integer.parseInt(XDK[2]); // K칸

			int r = X;

			while (r < N + 1) {
				rotate(r, K, D);
				r += X;
			}

			eraseList = new boolean[N + 1][M];
			boolean erase = eraseAdj();

			if(!erase){
				avg();
			}
		}

		int answer = getSum();
		System.out.print(answer);

	}
}
