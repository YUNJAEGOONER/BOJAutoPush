import java.io.*;
import java.util.*;

public class Main {

	public static class Horse {
		int id;
		int x;
		int y;
		int d;

		public Horse(int id, int x, int y, int d) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int [][][] arr;
	static int [][] mmap;

	static int N;
	static int K;

	static int [] dir_x = {0, 0, -1, 1};
	static int [] dir_y = {1, -1, 0, 0};

	static Map<Integer, Horse> horseMap;

	//이동해야하는 말 가져오기
	public static List<Horse> get(int cur_x, int cur_y, int id){
		List<Horse> tempList = new ArrayList<>();

		int start_idx = -1;
		for(int i = 0 ; i < K ; i ++ ) {
			if(arr[cur_x][cur_y][i] == id){
				start_idx = i;
				break;
			}
		}
		
		for(int i = start_idx ; i < K ; i ++ ){
			int cur = arr[cur_x][cur_y][i];
			if(cur != 0){
				tempList.add(horseMap.get(cur));
				arr[cur_x][cur_y][i] = 0; // 현재 위치에서 말을 제거
			}
		}
		return tempList;
	}

	//새로운 위치에다가 말을 내려 놓기
	public static void moveTo(int nx, int ny, List<Horse> tempList){
		int idx = 0;
		for(int i = 0 ; i < K ; i ++ ){
			if(arr[nx][ny][i] == 0 && tempList.size() > idx){
				Horse h = tempList.get(idx);
				int id = h.id;
				int dir = h.d;
				arr[nx][ny][i] = id; //말 내려놓기
				horseMap.put(id, new Horse(id, nx, ny, dir)); //업데이트 수행하기
				idx++;
			}
		}
	}

	public static void moveBlue(int cur_x, int cur_y, int dir, int id){
		
		// 이동 방향을 반대로...
		if(dir == 0) dir = 1;
		else if(dir == 1) dir = 0;
		else if(dir == 2) dir = 3;
		else if(dir == 3) dir = 2;
		
		int nx = cur_x + dir_x[dir];
		int ny = cur_y + dir_y[dir];
		
		horseMap.put(id, new Horse(id, cur_x, cur_y, dir)); // 말의 방향을 바꾸고
		
		if((0 <= nx && nx < N) && (0 <= ny && ny < N)){
			int color = mmap[nx][ny]; // 새로 이동하는 위치 
			if(color == 0){
				white(cur_x, cur_y, nx, ny, id);
		
			}
			else if(color == 1) {
				red(cur_x, cur_y, nx, ny, id);
			}
			//파란색이면 움직이지 않는다.
		}
		
	}
	
	public static void white(int cur_x, int cur_y, int nx, int ny, int id) {
		List<Horse> tempList = get(cur_x, cur_y, id); // 원래 있던 칸의 말을 다 가져와서
		moveTo(nx, ny, tempList); //새로운 칸으로 옮기기
	}
	
	public static void red(int cur_x, int cur_y, int nx, int ny, int id) {
		List<Horse> tempList = get(cur_x, cur_y, id); // 원래 있던 칸의 말을 다 가져와서
		Collections.reverse(tempList);
		moveTo(nx, ny, tempList); //새로운 칸으로 옮기기
	}

	
	public static boolean move(int id) {
		Horse horse = horseMap.get(id);
	

		int cur_x = horse.x; //원래 있던 칸 정보
		int cur_y = horse.y;
		int dir = horse.d; 

		int nx = cur_x + dir_x[dir]; //새롭게 이동할 장소 
		int ny = cur_y + dir_y[dir];

		if((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
			int color = mmap[nx][ny];
			if(color == 0) {
				white(cur_x, cur_y, nx, ny, id);
			}
			else if (color == 1){ //빨간색인 경우 - 이동하는 말들이 reverse
				red(cur_x, cur_y, nx, ny, id);
			}
			else { //파란색인 경우
				moveBlue(cur_x, cur_y, dir, id);
			}
		}
		else {
			moveBlue(cur_x, cur_y, dir, id);
		}

		horse = horseMap.get(id);

		if(arr[horse.x][horse.y][3] != 0){
			return false;
		}
		return true;
	}


	public static void main(String [] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] NK = br.readLine().split(" ");

		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);


		arr = new int [N][N][K]; // 말을 놓는곳
		mmap = new int [N][N];  

		for(int i = 0 ; i < N ; i ++ ) {
			String [] input = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j ++ ) {
				mmap[i][j] = Integer.parseInt(input[j]); //지도 정보
			}
		}

		horseMap = new HashMap<>();

		for(int i = 0 ; i < K ; i ++ ) {
			String [] xyd = br.readLine().split(" ");
			int x = Integer.parseInt(xyd[0]) - 1;
			int y = Integer.parseInt(xyd[1]) - 1;
			int d = Integer.parseInt(xyd[2]) - 1;
			
			int start = 0;
			int id = i + 1;
		
			while (true){
				if(arr[x][y][start] == 0){
					arr[x][y][start] = id;
					break;
				}
				start ++;
			}
			
			horseMap.put(id, new Horse(id, x, y, d));
		}

		int turn = 0;
		boolean check = true;
	
		while(check) {
			
			if(turn == 1000){
				turn = -1;
				break;
			}
			
			turn ++;
			for(int i = 1 ; i < K + 1 ; i ++ ) {
				boolean result = move(i);	
				if(!result){
					check = false;
					break;
				}
			}
		}

		System.out.println(turn);

	}

}
