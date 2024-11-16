#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    
    int hit = 0;
    int miss = 1; //처음에는 모두 miss;
   
    //대소문자를 구분하지 않음 : 모두 소문자로 변경
    for(int i = 0 ; i < cities.size() ; i ++ ){
        transform(cities[i].begin(), cities[i].end(), cities[i].begin(), ::tolower);
    }
    
    vector<string> cache;
    
    cache.push_back(cities[0]);
    
    if(cacheSize){
        for(int i = 1 ; i < cities.size() ; i ++){
            int flag = 1;
            for(auto itr = cache.begin(); itr != cache.end() ; itr ++ ){
                if(*itr == cities[i]){
                    hit++;
                    flag = 0;
                    cache.erase(itr);
                    break;
                 }
            }
            if(flag){
                miss ++;
                if(cache.size() == cacheSize){
                    cache.erase(cache.begin());
                }
            }
            cache.push_back(cities[i]);
        }
        answer = 5 * miss + hit;
    }
    else answer = 5 * cities.size(); //cacheSize가 0인 경우
    
    return answer;
}