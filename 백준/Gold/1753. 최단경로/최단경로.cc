#include <iostream>
#include <vector>
#include <queue>
#define MAX (300000 * 10) + 1

using namespace std;

int main() {
    //방향그래프
    int v, e, start;
    cin >> v >> e >> start;

    vector<vector<pair<int, int>>>mmap(v);
    vector<int> visited(v, 1);
    vector<int> distance(v, MAX);

    while(e--) {
        int i, j, dis;
        cin >> i >> j >> dis;
        mmap[i -1].push_back(make_pair(j - 1, dis));
    }

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push(make_pair(0, start - 1)); //cur_node, distance;
    distance[start - 1] = 0;

    while(!pq.empty()) {
        int cur_node = pq.top().second;
        int cur_dis = pq.top().first;
        visited[cur_node] = 0;
        pq.pop();
        for(int i = 0 ; i < mmap[cur_node].size() ; i ++ ) {
            int newnode = mmap[cur_node][i].first;
            int newdis = mmap[cur_node][i].second;
            if(visited[newnode] && (distance[newnode] > cur_dis + newdis)) {
                distance[newnode] = cur_dis + newdis;
                pq.push(make_pair(distance[newnode], newnode));
            }
        }
    }

    for(auto a : distance) {
        if(a == MAX) {
            cout << "INF" << '\n';
        }
        else {
            cout << a << '\n';
        }
    }

    return 0;
}