#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

vector<int> visited;

map<string, int> menus;

void dfs(int depth, int start, int n, string str){
    
    if(depth == n){
        string temp = "";
        for(int i = 0 ; i < str.size() ; i ++ ){
            if(visited[i] != 0){
                temp += str[i];
            }
        }
        menus[temp] ++;
        return;
    }
    
    for(int i = start ; i < str.size() ; i ++ ){
        if(visited[i] == 0){
            visited[i] = 1;
            dfs(depth + 1, i + 1, n, str);
            visited[i] = 0;
        }
    }
}


vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    
    for(int i = 0 ; i < course.size() ; i ++ ){
        int curlen = course[i];
        for(int j = 0 ; j < orders.size() ; j ++){
            if(orders[j].size() >= curlen){
                visited.clear();
                visited = vector<int> (orders[j].size());
                string cur = orders[j];
                sort(cur.begin(), cur.end());
                dfs(0, 0, curlen, cur);
            }
        }
    }

    
    map<int, vector<pair<int, string>>> setmenu;
    
    for(auto a : menus){
        //cout <<  a.first << " " << a.second << '\n';
        string mstr = a.first;
        int cnt = a.second;
        if(cnt >= 2){
            setmenu[mstr.size()].push_back(make_pair(cnt, mstr)); 
        }
    }
    
    for(auto a : setmenu){
        vector<pair<int, string>> res = a.second;
        sort(res.rbegin(), res.rend());
        int max = res[0].first;
        for(int i = 0 ; i < res.size() ; i ++){
            if(max == res[i].first){
                answer.push_back(res[i].second);
            }
        }
    }
    
    sort(answer.begin(), answer.end());
    
    return answer;
}