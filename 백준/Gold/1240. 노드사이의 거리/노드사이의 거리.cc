//
// Created by Yunjae on 2025-03-11.
//
#include<iostream>
#include<map>
#include<vector>
#include<queue>
using namespace std;
int main() {
    int a, b;
    cin >> a >> b;

    map<int, vector<pair<int, int>>> vec;

    for(int i = 0 ; i < a  - 1 ; i ++ ) {
        int s, e, d;
        cin >> s >> e >> d;
        vec[s].push_back(make_pair(e, d));
        vec[e].push_back(make_pair(s, d));
    }

    while(b--) {
        int start, end;
        cin >> start >> end;

        queue<pair<int, int>> mq; //destination, distance;
        mq.push(make_pair(start, 0));

        vector<int> visited(a + 1);
        int ans = 0;

        while(!mq.empty()) {
            int cur = mq.front().first;
            int dis = mq.front().second;
            mq.pop();
            if(cur == end) {
                ans = dis;
                break;
            }
            for(int i = 0 ; i < vec[cur].size() ; i ++ ) {
                if(!visited[vec[cur][i].first]) {
                    visited[vec[cur][i].first] = 1;
                    mq.push(make_pair(vec[cur][i].first, dis + vec[cur][i].second));
                }
            }
        }

        cout << ans << '\n';
    }
    return 0;
}