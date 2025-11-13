import java.util.*;
import java.io.*;

public class Main {
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int [][] mmap;
	
	static int N;
	static int M;
	
	public static int getRoomSize(Queue<Pair> mq) {
		
		int [][] visited = new int [mmap.length][mmap[0].length];
		int size = 2;
		
		while(!mq.isEmpty()) {
			Pair cur = mq.poll();
			int cur_x = cur.x;
			int cur_y = cur.y;
			visited[cur_x][cur_y] = 1;
			
			int val = mmap[cur_x][cur_y];
			
			//상
			if(cur_x - 1 >= 0 && (val & 2) != 2 && visited[cur_x - 1][cur_y] == 0) {
				mq.add(new Pair(cur_x - 1, cur_y));
				visited[cur_x - 1][cur_y] = 1;
				size ++;
			}
			
			//하
			if(cur_x + 1 < M && (val & 8) != 8 && visited[cur_x + 1][cur_y] == 0) {
				mq.add(new Pair(cur_x + 1, cur_y));
				visited[cur_x + 1][cur_y] = 1;
				size ++;
			}
			
			//좌
			if(cur_y - 1 >= 0 && (val & 1) != 1 && visited[cur_x][cur_y - 1] == 0) {
				mq.add(new Pair(cur_x, cur_y - 1));
				visited[cur_x][cur_y - 1] = 1;
				size ++;
			}
			
			//우
			if(cur_y + 1 < N && (val & 4) != 4 && visited[cur_x][cur_y + 1] == 0) {
				mq.add(new Pair(cur_x, cur_y + 1));
				visited[cur_x][cur_y + 1] = 1;
				size ++;
			}
		}
			
		return size;
	}
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] NM = br.readLine().split(" ");
	
		N = Integer.parseInt(NM[0]); //7
		M = Integer.parseInt(NM[1]); //4
		int d = 4;
		
		mmap = new int [M][N];
		
		for(int i = 0 ; i < M ; i ++ ) {
			String [] numList = br.readLine().split(" ");
			for(int j = 0 ; j < numList.length ; j ++ ) {
				int num = Integer.parseInt(numList[j]);
				mmap[i][j] = num;
			}
		}
		
		int [][] visited = new int [M][N];
		
		int room = 0;
		int max_size = 0;
		
		for(int i = 0 ; i < M ; i ++ ) {
			for(int j = 0 ; j < N ; j ++ ) {
				if(visited[i][j] == 0) {
					visited[i][j] = 1;
					room ++;
					Queue<Pair> mq = new LinkedList<>();
					mq.add(new Pair(i, j));
					int size = 1;
					
					while(!mq.isEmpty()) {
						Pair pair = mq.poll();
						
						int cur_x = pair.x;
						int cur_y = pair.y;
						int val = mmap[cur_x][cur_y];
						
						//상
						if(cur_x - 1 >= 0 && (val & 2) != 2 && visited[cur_x - 1][cur_y] == 0) {
							mq.add(new Pair(cur_x - 1, cur_y));
							visited[cur_x - 1][cur_y] = 1;
							size ++;
						}
						
						//하
						if(cur_x + 1 < M && (val & 8) != 8 && visited[cur_x + 1][cur_y] == 0) {
							mq.add(new Pair(cur_x + 1, cur_y));
							visited[cur_x + 1][cur_y] = 1;
							size ++;
						}
						
						//좌
						if(cur_y - 1 >= 0 && (val & 1) != 1 && visited[cur_x][cur_y - 1] == 0) {
							mq.add(new Pair(cur_x, cur_y - 1));
							visited[cur_x][cur_y - 1] = 1;
							size ++;
						}
						
						//우
						if(cur_y + 1 < N && (val & 4) != 4 && visited[cur_x][cur_y + 1] == 0) {
							mq.add(new Pair(cur_x, cur_y + 1));
							visited[cur_x][cur_y + 1] = 1;
							size ++;
						}
					}
					if(max_size < size) max_size = size;
				
				}
			}
		}
		
		int max = 0;
		
		for(int i = 0 ; i < M ; i ++ ) {
			for(int j = 0 ; j < N ; j ++) {
				int val = mmap[i][j];
				int cur_x = i;
				int cur_y = j;
				
				if((val & 2) == 2 && cur_x - 1 >= 0) {
					Queue<Pair> mq = new LinkedList<>();
					mq.add(new Pair(i, j));
					mq.add(new Pair(i - 1, j));
					int size = getRoomSize(mq);
					if(max < size) max = size;
				}
				
				if((val & 8) == 8 && cur_x + 1 < M) {
					Queue<Pair> mq = new LinkedList<>();
					mq.add(new Pair(i, j));
					mq.add(new Pair(i + 1, j));
					int size = getRoomSize(mq);
					if(max < size) max = size;
				}
				
				if((val & 1) == 1 && cur_y - 1 >= 0) {
					Queue<Pair> mq = new LinkedList<>();
					mq.add(new Pair(i, j));
					mq.add(new Pair(i, j - 1));
					int size = getRoomSize(mq);
					if(max < size) max = size;
				}
				
				if((val & 4) == 4 && cur_y + 1 < N) {
					Queue<Pair> mq = new LinkedList<>();
					mq.add(new Pair(i, j));
					mq.add(new Pair(i, j + 1));
					int size = getRoomSize(mq);
					if(max < size) max = size;
				}
			}
		}
		
		
		
		System.out.println(room);
		System.out.println(max_size);
		System.out.println(max);
		

		
	}

}
