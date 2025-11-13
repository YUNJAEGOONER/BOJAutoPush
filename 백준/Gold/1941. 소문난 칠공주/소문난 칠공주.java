import java.io.*;
import java.util.*;

public class Main {
	
	static int count = 0;
	
	static char [][] mmap;
	
	public static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int [] dir_x = {1, -1, 0, 0};
	static int [] dir_y = {0, 0, 1, -1};
	
	public static boolean validate(List<Integer> list) {
		
		int [][] visited = new int [5][5];
		for(int i = 0 ; i < list.size() ; i ++ ) {
			int x = list.get(i) / 5;
			int y = list.get(i) % 5;
			visited[x][y] = 1;
		}
		
		int S = 0;
		int Y = 0;
		int count = 0;
		
		Queue<Pair> mq = new LinkedList<>();
		
		int i = list.get(0)/5;
		int j = list.get(0)%5;
		
		mq.add(new Pair(i, j));
		if(mmap[i][j] == 'S') S++;
		else Y ++;
		visited[i][j] = 0;
		count ++;

		while(!mq.isEmpty()) {
			Pair pair = mq.poll();
			int cur_x = pair.x;
			int cur_y = pair.y;
			for(int k = 0 ; k < 4 ; k ++) {
				int x = cur_x + dir_x[k];
				int y = cur_y + dir_y[k];
				if((0 <= x && x < 5) && (0 <= y && y < 5)) {
					if(visited[x][y] == 1) {
						visited[x][y] = 0;
						if(mmap[x][y] == 'S') S++;
						else Y ++;
						count ++;
						mq.add(new Pair(x, y));
					}
				}
			}
		}
		
		if(S >= 4 && count == 7) {
			return true;
		}
		
		return false;
	}
	
	
	public static void bt(int start, List<Integer> list) {
		if(list.size() == 7) {
			if(validate(list)) count ++;
			return;
		}
		for(int i = start ; i < 25 ; i ++ ) {
			list.add(i);
			bt(i + 1, list);
			list.remove(list.size() - 1);
		}
	}


	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		mmap = new char [5][5];
		
		for(int i = 0 ; i < 5 ; i ++ ) {
			String row = br.readLine();
			for(int j = 0 ; j < row.length() ; j ++ ) {
				mmap[i][j] = row.charAt(j);
			}
		}
		
		bt(0, new ArrayList<Integer>());	
		
		System.out.print(count);
	}
	
	
	
}
