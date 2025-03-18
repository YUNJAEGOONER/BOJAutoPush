#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    
    map<string, int> maps;
    map<int, string> keys;
    
    //tosmallletter
    for(int i = 0 ; i < cities.size() ; i ++ ){
        for(int j = 0 ; j < cities[i].size() ; j ++ ){
            if('A'<= cities[i][j] && cities[i][j] <= 'Z'){
                cities[i][j] += 32;
            }
        }
    }
    
    for(int i = 0 ; i < cities.size() ; i ++ ){
        string cur = cities[i];
        if(cacheSize){
            if(maps.size() < cacheSize){
                //miss
                if(maps[cur] == 0){
                    answer += 5;
                }
                //hit
                else{
                    int prev = maps[cur]; //이전 키
                    keys.erase(prev);
                    answer += 1;
                }
            }
            else{
                //miss
                if(maps[cur] == 0){
                    int prev = keys.begin()->first; //LRU;
                    string str = keys.begin()->second;
                    maps[str] = 0;
                    keys.erase(prev);
                    answer += 5;
                }
                //hit
                else{
                    int prev = maps[cur]; //이전 키
                    keys.erase(prev);
                    answer += 1;
                }
            }
            maps[cur] = i + 1; //새로운 키 업데이트
            keys[i + 1] = cur;
        }
        else{
            answer = 5 * cities.size();
        }
        
    }
    
    
    
    
    return answer;
}