import java.util.*;

class Solution {
    
    public static class Pair{
        int x;
        int y;
        int dis;
        public Pair(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    static char [][] mmap;
    
    static int [] dir_x = {1, -1, 0, 0};
    static int [] dir_y = {0, 0, 1, -1};
    
    public static int BFS(int x1, int y1, int x2, int y2){
        boolean [][] visited = new boolean[mmap.length][mmap[0].length];
        Queue<Pair> mq = new LinkedList<>();
        
        mq.add(new Pair(x1, y1, 0));
        visited[x1][y1] = true;
        
        while(!mq.isEmpty()){
            Pair cur = mq.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int dis = cur.dis;
            if(cur_x == x2 && cur_y == y2){
                return dis;
            }
            for(int d = 0 ; d < 4 ; d ++){
                int nx = cur_x + dir_x[d];
                int ny = cur_y + dir_y[d];
                if((0 <= nx && nx < mmap.length) && (0 <= ny && ny < mmap[0].length)){
                    if(mmap[nx][ny] != 'X' && !visited[nx][ny]){
                        mq.add(new Pair(nx, ny, dis + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
            
        }
        return -1;
    }
    
    
    
    public int solution(String[] maps) {
        int answer = 0;
        
        mmap = new char[maps.length][maps[0].length()];
        
        int start_x = 0;
        int start_y = 0;
        
        int t1_x = 0;
        int t1_y = 0;
        
        int tx = 0;
        int ty = 0;
        
        for(int i = 0 ; i < maps.length ; i ++ ){
            for(int j = 0 ; j < maps[0].length() ; j ++){
                mmap[i][j] = maps[i].charAt(j);
                if(mmap[i][j] == 'S'){
                    start_x = i;
                    start_y = j;
                }
                else if(mmap[i][j] == 'L'){
                    t1_x = i;
                    t1_y = j;
                }
                else if(mmap[i][j] == 'E'){
                    tx = i;
                    ty = j;
                }
            }
        }
        
        int distance1 = BFS(start_x, start_y, t1_x, t1_y);
        int distance2 = BFS(t1_x, t1_y, tx, ty);
        
        if(distance1 == -1 || distance2 == -1){
            answer = -1;
        }
        else{
            answer = distance1 + distance2;
        }
      
        return answer;
    }
}