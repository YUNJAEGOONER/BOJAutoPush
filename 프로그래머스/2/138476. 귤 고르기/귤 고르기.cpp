#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int> p1, pair<int, int> p2){
    return p1.second > p2.second;
}

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    map<int, int> t;
    
    for(int i = 0 ; i < tangerine.size(); i ++ ){
        t[tangerine[i]] ++;
    }
    
    vector<pair<int, int>> tovec;
    for(auto itr : t){
        tovec.push_back(make_pair(itr.first, itr.second));
    }
    
    sort(tovec.begin(), tovec.end(), cmp);
    
    int sum = 0; 
    for(int i = 0 ; i < tovec.size() ; i ++ ){
        sum = sum + tovec[i].second;
        answer ++;
        if(sum >= k ){
            break;
        }
        //cout << tovec[i].first << ' ' << tovec[i].second << '\n' ;
    }
    
    return answer;
}