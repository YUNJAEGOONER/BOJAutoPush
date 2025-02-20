//
// Created by Yunjae on 2025-02-20.
//
#include <iostream>
#include <queue>
#include <vector>
#include <map>
#define MAX 50000 * 1000 + 1
using namespace std;

int main() {

    //Dijkstra algorithm
    //하나의 정점에서 다른 모든 정범으로 가는 최단 경로
    //시작 노드에서 나머지 모든 노드까지의 최단 경로를 구할 수 있음
    //한계점 -> 간선이 음의 가중치를 갖는 경우 최단 경로를 보장하지 못함
    int a, b;
    cin >> a >> b;

    //방문여부를 확인하기 위함
    vector<int> visited(a ,1);

    //초기 거리는 모두 무한대
    vector<int> distance(a ,MAX);

    //우선순위 큐 -> 내림차순이 default
    //오름차순 우선순위 큐를 만들어 주기 위함
    //거리가 짧은 순으로 먼저 방문함 <거리, 현위치>
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

    //지도 -> 입력받기
    //vector<vector<int>> mmap;
    //vector<int> row(a ,-1);
    // for(int i = 0 ; i < a; i ++ ){
    //     mmap.push_back(row);
    // }

    map<int, vector<pair<int,int>>> mmap;

    //양방향 그래프
    while(b --) {
        int i, j, d;
        cin >> i >> j >> d;
        mmap[i - 1].push_back(make_pair(j - 1, d));
        mmap[j - 1].push_back(make_pair(i - 1, d));
    }

    //처음 위치
    pq.push(make_pair(0, 0));
    distance[0] = 0;

    while(!pq.empty()) {
        int cur = pq.top().second; //위치
        int dis = pq.top().first; // 거리
        visited[cur] = 0;
        for(int i = 0 ; i < mmap[cur].size() ; i ++ ) {
            int dest = mmap[cur][i].first;
            int ndis = mmap[cur][i].second;
            if(visited[dest] && distance[dest] > dis + ndis) {
                distance[dest] = dis + ndis;
                pq.push(make_pair(distance[dest], dest));
            }
        }
        pq.pop();
    }
    
    cout << distance[a - 1];
    return 0;
}