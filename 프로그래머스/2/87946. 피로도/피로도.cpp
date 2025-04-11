#include <string>
#include <vector>
#include <iostream>

using namespace std;

//중복을 허용하지 않음
//순서가 존재함
vector<int> visited;
vector<int> temp;

vector<vector<int>> vec;
int n0;
int answer = 0;

void bt(int depth, int k){
    if(depth == visited.size()){
        int n0 = k;
        int cnt = 0;
        for(int i = 0 ; i < temp.size() ; i ++ ){
            if(n0 >= vec[temp[i]][0]){
                n0 -= vec[temp[i]][1];
                cnt ++;
            }
            else{
                break;
            }
        }
        if(answer < cnt) answer = cnt;
        return;
    }
    for(int i = 0 ; i < visited.size() ; i ++ ){
        if(visited[i] == 0){
            temp.push_back(i);
            visited[i] = 1;
            bt(depth + 1, k);
            temp.pop_back();
            visited[i] = 0;
        }
    }
}


int solution(int k, vector<vector<int>> dungeons) {
    visited = vector<int> (dungeons.size());
    
    vec = dungeons;
    
    bt(0, k);
    
    return answer;
}