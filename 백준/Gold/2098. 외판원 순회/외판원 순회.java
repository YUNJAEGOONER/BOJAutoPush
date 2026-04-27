import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	
	static int [][] mmap;
	
	static int [][] dp;
	
	public static void main(String[] args) throws IOException{
		
		N = Integer.parseInt(br.readLine());
		mmap = new int [N][N];
		
		for(int i = 0 ; i < N ; i ++ ) {
			String [] rows = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j ++ ) {
				mmap[i][j] = Integer.parseInt(rows[j]);
			}
		}
		
		//dp 배열 초기화
		dp = new int [1 << N][N];
		for(int i = 0 ; i < (1 << N) ; i ++) {
			Arrays.fill(dp[i], -1);
		}
		dp[1][0] = 0;
		
		//dp 배열을 채워 나가기....
		for(int visited = 0 ; visited < (1 << N) ; visited ++) {
			
			if((visited & 1) == 0) continue; // 출발지 노드를 방문하지 않은 경우는 고려 필요 x
			
			for(int now = 0 ; now < N ; now ++) {
				if(dp[visited][now] == -1) continue; // 유효하지 않은 방문
				if((visited & (1 << now)) == 0) continue; // 방문했다고 표시되어 있지만 실제 방문을 하지 않은 경우
				
				for(int next = 0 ; next < N ; next ++) {
					if(mmap[now][next] == 0) continue;
					if((visited & (1 << next)) == (1 << next)) continue;
					int nextVisited = visited | (1 << next);
					int distance = dp[visited][now] + mmap[now][next];
					if(dp[nextVisited][next] == - 1 || (dp[nextVisited][next] != - 1 && dp[nextVisited][next] > distance)) {
						dp[nextVisited][next] = distance;
					}	
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < N ; i ++ ) {
			if(dp[(1 << N) - 1][i] == -1) continue;
			if(mmap[i][0] == 0) continue; //복귀 경로가 없는 경우
			min = Math.min(min, dp[(1 << N) - 1][i] + mmap[i][0]);
		}
		System.out.print(min);
	
	}
	
}
