import java.util.*;
import java.io.*;

public class Main {
	
	static int [] dir_x = {1, -1, 0, 0};
	static int [] dir_y = {0, 0, 1, -1};

	static int [][] arr ;
	
	static int M;
	
	static List<Pair> pairList;
	
	static int answer ;
	
	static class Pair{
		int x;
		int y;
		int t;
		public Pair(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	//바이러스 전파
	public static int bfs(List<Pair> temp){

		int count = 0;

		boolean [][] tVisited = new boolean[arr.length][arr.length];

		Queue<Pair> mq = new LinkedList<>();
		for(Pair pair : temp){
			mq.add(pair);
			tVisited[pair.x][pair.y] = true;
		}

		while(!mq.isEmpty()){
			Pair cur = mq.poll();
			int cur_x = cur.x;
			int cur_y = cur.y;
			int time = cur.t;

			count = Math.max(count, time);

			for(int d = 0 ; d < 4 ; d ++ ){
				int nx = cur_x + dir_x[d];
				int ny = cur_y+ dir_y[d];
				if((0 <= nx && nx < arr.length) && (0 <= ny && ny < arr.length)){
					if(arr[nx][ny] != 1 && !tVisited[nx][ny]){
						tVisited[nx][ny] = true;
						mq.add(new Pair(nx, ny, time + 1));
					}
				}

			}
		}

		for(int i = 0 ; i < arr.length ; i ++ ){
			for(int j = 0 ; j < arr.length ; j ++ ){
				if((arr[i][j] == 0 || arr[i][j] == 2) && !tVisited[i][j]){
					return -1;
				}
			}
		}

		return count;
	}
	
	public static void bt(int start, List<Pair> temp) {
		if(temp.size() == M) {
			int time = bfs(temp);
			if(time != - 1){
				answer = (answer == -1) ? time : Math.min(answer, time);
			}
			return;
		}
		for(int i = start; i < pairList.size() ; i ++ ) {
			temp.add(pairList.get(i));
			bt(i + 1, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]); // 바이러스
		
		arr = new int [N][N];
		pairList = new ArrayList<>();
		answer = -1;
		
		for(int i = 0 ; i < N ; i ++ ) {
			String [] input = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j ++ ) {
				arr[i][j] = Integer.parseInt(input[j]);
				if(arr[i][j] == 2) {
					pairList.add(new Pair(i, j, 0));
				}
			}
		}
		
		bt(0, new ArrayList<>());

		System.out.print(answer);
	}
	
	
}