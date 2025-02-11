#include <string>
#include <map>
#include <set>

using namespace std;

int solution(string dirs) {
    int answer = 0;
    
    int cur_x = 0;
    int cur_y = 0;
    
    set<pair<pair<int, int>, char>> visit;
    
    for(int i = 0 ; i < dirs.size() ; i ++ ){
        int temp = visit.size();
        if(dirs[i] == 'U' && cur_y + 1 <= 5){
            visit.insert(make_pair(make_pair(cur_x, cur_y),'U'));
            visit.insert(make_pair(make_pair(cur_x, cur_y + 1), 'D'));
            cur_y = cur_y + 1;
            if(temp != visit.size()) answer ++;
        }
        else if(dirs[i] == 'D' && cur_y - 1 >= -5){
            visit.insert(make_pair(make_pair(cur_x, cur_y),'D'));
            visit.insert(make_pair(make_pair(cur_x, cur_y - 1), 'U'));
            cur_y --;
            if(temp != visit.size()) answer ++;
        }
        else if(dirs[i] == 'R' && cur_x + 1 <= 5){
            visit.insert(make_pair(make_pair(cur_x, cur_y),'R'));
            visit.insert(make_pair(make_pair(cur_x + 1, cur_y), 'L'));
            cur_x ++;
            if(temp != visit.size()) answer ++;
        }
        else if(dirs[i] == 'L' && cur_x - 1 >= -5){
            visit.insert(make_pair(make_pair(cur_x, cur_y),'L'));
            visit.insert(make_pair(make_pair(cur_x - 1, cur_y), 'R'));
            cur_x --;
            if(temp != visit.size()) answer ++;
        }        
    }
    return answer;
}