#include <iostream>
#include <vector>
#include <queue>
#include <map>
#define MAX 500000
using namespace std;

//데이크스트라
int solution(int N, vector<vector<int>> road, int K) {
    int answer = 0;
    
    map<int, vector<pair<int, int>>> mmap;
    
    for(int i = 0 ; i < road.size() ; i ++){
        int s = road[i][0] - 1;
        int e = road[i][1] - 1;
        int d = road[i][2];
        //양방향 그래프
        mmap[s].push_back(make_pair(e, d));
        mmap[e].push_back(make_pair(s, d));
    }
    
    vector<int> visited(N, 0);
    vector<int> dis(N, MAX);
    
    visited[0] = 1;
    dis[0] = 0;
    
    //distance, cur_pos;
    priority_queue <pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>pq;
        
    pq.push(make_pair(0, 0));
    pq.push(make_pair(2, 0));
    pq.push(make_pair(9, 0));
    
    while(!pq.empty()){
        int cur_position = pq.top().second;
        int cur_dis = pq.top().first;
        pq.pop();
        visited[cur_position] = 1;
        
        for(int i = 0; i < mmap[cur_position].size() ; i ++){
            int node = mmap[cur_position][i].first;
            int edge = mmap[cur_position][i].second;
            if(visited[node] == 0 && dis[node] > cur_dis + edge){
                dis[node] = cur_dis + edge;
                pq.push(make_pair(cur_dis + edge, node));
            }
        }
       
    }
    
    for(auto d : dis){
        if(d <= K){
            answer ++;
        }
        cout << d << ' ';
    }
  
    return answer;
}