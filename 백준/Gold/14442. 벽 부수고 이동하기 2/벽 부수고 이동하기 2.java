import java.util.*;
import java.io.*;

public class Main{
	
	static int [][] arr;

	static int [][][] visited;
	
	static int [] dir_x = {1, -1, 0, 0};
	static int [] dir_y = {0, 0, 1, -1};
	
	public static class Pair{
		int x;
		int y;
		int dis;
		int bcnt;
		Pair(int x, int y, int dis, int bcnt){
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.bcnt = bcnt;
		}
	}

	public static void main(String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] NMK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NMK[0]); 
		int M = Integer.parseInt(NMK[1]); 
		int K = Integer.parseInt(NMK[2]); // 부실 수 있는 벽의 수 
		
		arr = new int [N][M];

		visited = new int [N][M][K + 1];
		
		for(int i = 0 ; i < N ; i ++ ) {
			String input = br.readLine();
			for(int j = 0 ; j < M ; j ++ ) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		Queue<Pair> mq = new LinkedList<>();
		mq.add(new Pair(0, 0, 1, 0));
		visited[0][0][0] = 1;

		//출발 (0, 0)
		//도착 (N - 1, M - 1)
		//최단 경로를 구하기
		
		while(!mq.isEmpty()) {

			Pair cur = mq.poll();
			int cur_x = cur.x;
			int cur_y = cur.y;
			int dis = cur.dis;
			int bcnt = cur.bcnt;

			for(int d = 0 ; d < 4 ; d ++ ){
				int nx = cur_x + dir_x[d];
				int ny = cur_y + dir_y[d];
				if((0 <= nx && nx < N) && (0 <= ny && ny < M)){
					if(arr[nx][ny] == 0){
						if(visited[nx][ny][bcnt] == 0){
							visited[nx][ny][bcnt] = dis + 1;
							mq.add(new Pair(nx, ny, dis + 1, bcnt));
						}
					}
					else{
						if(bcnt + 1 <= K){
							if(visited[nx][ny][bcnt + 1] == 0){
								visited[nx][ny][bcnt + 1] = dis + 1;
								mq.add(new Pair(nx, ny, dis + 1, bcnt + 1));
							}
						}
					}

				}
			}
		}

		int answer = - 1;
		int [] answerList = new int[K + 1];
		for(int i = 0 ; i < K + 1; i ++ ){
			answerList[i] = visited[N - 1][M - 1][i];
		}

		for(int i = 0 ; i < answerList.length ; i ++  ){
			if(answerList[i] != 0){
				if(answer == -1){
					answer = answerList[i];
				}
				else {
					answer = Math.min(answer, answerList[i]);
				}
			}
		}

		System.out.println(answer);


	}

}