//
// Created by Yunjae on 2025-03-30.
//
#include <iostream>
#include <queue>
#include <vector>
using namespace std;
int main() {

    int s, e;
    cin >> s >> e;

    queue<pair<int, int>> mq; //depth, 위치;
    mq.push(make_pair(0, s));

    int ans = 100001;
    //int vecsize = s < e ? e : s;
    vector<int> visited(100001);

    while(!mq.empty()) {
        int depth = mq.front().first;
        int location = mq.front().second;
        visited[location] = 1;
        mq.pop();

        if(location == e && depth < ans) {
             ans = depth;
        }
        else {
            //순간이동
            int temp = location * 2;
            while(temp <= e + 1 && visited[temp] == 0) {
                mq.push(make_pair(depth , temp));
                temp *= 2;
            }
        }

        if(visited[location + 1] == 0 && location + 1 <= e){
            mq.push(make_pair(depth + 1, location + 1));
        }

        if(visited[location - 1] == 0 && location - 1 >= 0) {
            mq.push(make_pair(depth + 1, location - 1));
        }

    }

    cout << ans;

    return 0;
}