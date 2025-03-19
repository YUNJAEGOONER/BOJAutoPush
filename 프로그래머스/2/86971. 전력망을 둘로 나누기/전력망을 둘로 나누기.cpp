#include <string>
#include <vector>
#include <map>
#include <queue>
#include <iostream>

using namespace std;

int solution(int n, vector<vector<int>> wires) {
    int answer = n;
    
    for(int i = 0 ; i < wires.size() ; i ++ ){
        map<int, vector<int>> tree;
        for(int j = 0 ; j < wires.size() ; j ++ ){
            if(i != j){
                tree[wires[j][0]].push_back(wires[j][1]);
                tree[wires[j][1]].push_back(wires[j][0]);
            }
        }
        
        queue<int> mq;
        mq.push(1);
        vector<int> visited(n);
        int cnt = 0;
        
        while(!mq.empty()){
            int top = mq.front();
            visited[top - 1] = 1;
            mq.pop();
            cnt ++;
            for(int j = 0 ; j < tree[top].size() ; j ++ ){
                if(visited[tree[top][j] - 1] == 0){
                    mq.push(tree[top][j]);
                }
            }
        }
        
        //cout  << " A : " << cnt << "B :" << n - cnt << "diff" << abs(n - cnt - cnt) << '\n';
        if(abs(n - cnt - cnt) < answer){
            answer = abs(n - cnt - cnt);
        }
        
    }
    
    return answer;
}