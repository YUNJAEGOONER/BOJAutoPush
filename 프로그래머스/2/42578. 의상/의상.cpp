#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

// vector<int> visit;

// map <string, int> cmap;
// vector<string> keys;
// int answer = 0;

// void dfs_combi(int s, int e, int depth){
//     if(depth){
//         int temp = 1;
//         for(int i = 0 ; i < e; i ++ ){
//             if(!visit[i]){
//                 temp = temp * cmap[keys[i]];
//             }
//         }
//         answer = answer + temp;
//     }
//     for(int i = s ; i < e ; i ++ ){
//         if(!visit[i]) continue;
//         visit[i] = 0;
//         dfs_combi(i , e, depth + 1);
//         visit[i] = 1;
//     }
// }

int solution(vector<vector<string>> clothes) {
    
    map <string, int> cmap;
    
    for(int i = 0 ; i < clothes.size() ; i ++ ){
        cmap[clothes[i][1]]++;
    }
    
    int answer = 1;
    for(auto a : cmap){
        answer = answer * (a.second + 1);
    }
    return answer - 1;
    
//     for(auto a : cmap)keys.push_back(a.first);
    
//     for(int i = 0 ; i < keys.size() ; i ++) visit.push_back(1);
//     dfs_combi(0, keys.size(), 0);
    
    
    return answer;
}