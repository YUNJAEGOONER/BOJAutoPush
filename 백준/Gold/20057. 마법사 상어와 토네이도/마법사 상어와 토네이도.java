import java.io.*;
import java.util.*;

public class Main {
	
	static int [] dir_x = {0, 1, 0, -1};
	static int [] dir_y = {-1, 0, 1, 0};
	
	static int [][] dir_wx = {
			
			{-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}, 
			{1, 1, 0, 0, -1, -1, 0, 0, 2, 1},
			{-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
			{-1, -1, 0, 0, 1, 1, 0, 0, -2, -1}
	};
	
	static int [][] dir_wy = {
			
			{-1, -1, 0, 0, 1, 1, 0, 0, -2, -1}, 
			{-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
			{1, 1, 0, 0, -1, -1, 0, 0, 2, 1},
			{-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}		
	};
	
	
	static int [][] mmap;
	
	static int answer = 0;
	
	static int n;
	
	
	public static void wind(int x, int y, int dir) {
		
		int sand = mmap[x][y];
		
		int one = (int) Math.floor(((double)sand / 100.0) * 1);
		int seven = (int) Math.floor(((double)sand / 100.0) * 7);
		int ten = (int) Math.floor(((double)sand / 100.0) * 10);
		int two = (int) Math.floor(((double)sand / 100.0) * 2);
		int five = (int) Math.floor(((double)sand / 100.0) * 5);
		
		int remain = sand - ((2 * seven) + (2 * one) + (2 * two) + (2 * ten) + five);
		
		List<Integer> sandList = new ArrayList<>();
		
		sandList.add(ten);
		sandList.add(ten);
		sandList.add(seven);
		sandList.add(seven);
		sandList.add(one);
		sandList.add(one);
		sandList.add(two);
		sandList.add(two);
		sandList.add(five);
		sandList.add(remain);
		
		int [] direction_x = dir_wx[dir];
		int [] direction_y = dir_wy[dir];
		
		for(int i = 0 ; i < direction_x.length ; i ++) {
			int nx = x + direction_x[i];
			int ny = y + direction_y[i];
			if((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
				mmap[nx][ny] += sandList.get(i);
			}
			else {
				answer += sandList.get(i);
			}
		}
		
	}
	

	public static void main(String [] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		mmap = new int [n][n];
		
		for(int i = 0 ; i < n ; i ++ ) {
			String [] input = br.readLine().split(" ");
			for(int j = 0 ; j < input.length ; j ++ ) {
				mmap[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		int x = n/2;
		int y = n/2;
		int dir = 0;
		int size = 1;
		
		int num = 0;
		
		while(true) {
			
			if(size == n - 1) {
				for(int i = 0 ; i < 3 ; i ++ ) {
					for(int j = 0 ; j < size ; j ++ ) {
						x += dir_x[dir];
						y += dir_y[dir];
						wind(x, y, dir);
					}
					dir ++;
					dir %= 4;
				}
				break;
			}
			else {
				for(int i = 0 ; i < 2 ; i ++ ) {
					for(int j = 0 ; j < size ; j ++ ) {
						x += dir_x[dir];
						y += dir_y[dir];
						wind(x, y, dir);
					}
					dir ++;
					dir %= 4;
				}
				size ++;
			}
		
		}
	
		
		System.out.print(answer);
	
	}
	
}
