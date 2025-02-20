//
// Created by Yunjae on 2025-02-20.
//
#include<iostream>
#include<map>
#include<queue>
#include<vector>
#define MAX (1000 * 100000) + 1

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    map<int, vector<pair<int, int>>>mmap;
    while(m--) {
        int a, b, c;
        cin >> a >> b >> c;
        mmap[a - 1].push_back(make_pair(b - 1, c));
    }

    int s, e;
    cin >> s >> e;

    vector<int> visited(n, 1);
    vector<int> distance(n, MAX);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push(make_pair(0, s - 1)); //<distance, current_node>

    while(!pq.empty()) {
        int cur_node = pq.top().second;
        int dis = pq.top().first;
        pq.pop();

        visited[cur_node] = 0;
        if(cur_node == e -1) break; //목적지에 도착한 경우

        for(int i = 0 ; i < mmap[cur_node].size() ; i ++ ) {
            int newdis = mmap[cur_node][i].second;
            int newdes = mmap[cur_node][i].first;
            if(visited[newdes] && distance[newdes] > dis + newdis) {
                distance[newdes] = dis + newdis;
                pq.push(make_pair(distance[newdes], newdes));
            }
        }
    }
    
    cout << distance[e - 1];
    return 0;
}