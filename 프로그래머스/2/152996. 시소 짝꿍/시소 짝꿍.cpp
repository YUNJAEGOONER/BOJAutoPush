#include <string>
#include <vector>
#include <map>
#include <iostream>


using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    
    map<int, int> maps;
    map<int, int> duplicate;
    
    for(int i = 0 ; i < weights.size() ; i ++ ){
        int cur = weights[i];
        if(maps[cur * 2] != 0){
            answer += maps[cur* 2];
        }
        if(maps[cur * 3] != 0){
            answer += maps[cur * 3];
        }
        if(maps[cur * 4] != 0){
            answer += maps[cur * 4];
        }
        maps[cur * 2] ++ ;
        maps[cur * 3] ++ ;
        maps[cur * 4] ++ ;
        
        duplicate[cur]++ ;
        
        if(duplicate[cur] >= 2){
            answer -= (duplicate[cur] - 1) * 2;
        }
    }
    
    
    return answer;
}