//
// Created by Yunjae on 2025-04-07.
//
#include <iostream>
#include <vector>
using namespace std;

vector<int> visited28215;

vector<pair<int, int>> vec;

int answer = 200001;

void get_combi(int depth, int K, int start) {
    if(depth == K) {
        vector<pair<int, int>> temp;
        for(int i = 0 ; i < visited28215.size() ; i ++) {
            if(visited28215[i] == 1) {
                temp.push_back(vec[i]);
            }
        }

        int localmax = -1;
        for(int i = 0 ; i < vec.size() ; i ++ ) {
            int min = 200001;
            //각 집에서 가장 가까운 대피소의 거리
            for(int j = 0 ; j < temp.size() ; j ++ ) {
                int dis = abs(vec[i].first - temp[j].first) + abs(vec[i].second - temp[j].second);
                if(min > dis) {
                    min = dis;
                }
            }
            //가장 먼 것
            if(localmax < min) localmax = min;
        }
        //가장 큰 값이 가장 작을 때
        if(answer > localmax) answer = localmax;
        return;
    }
    for(int i = start ; i < visited28215.size() ; i ++ ) {
        if(visited28215[i] == 0) {
            visited28215[i] = 1;
            get_combi(depth + 1, K, i);
            visited28215[i] = 0;
        }
    }
}


int main() {
    int N, K;
    cin >> N >> K;

    for(int i = 0 ; i < N ; i ++ ) {
        int x, y;
        cin >> x >> y;
        vec.push_back(make_pair(x, y));
    }

    visited28215 = vector<int>(N);
    get_combi(0, K, 0);
    cout << answer;

    return 0;
}