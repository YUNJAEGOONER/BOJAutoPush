//
// Created by Yunjae on 2025-03-26.
//
#include <iostream>
#include <vector>
#include <map>
#include <queue>
using namespace std;

int main() {
    vector<int> vec(101, 101);

    int N, M;
    cin >> N >> M;

    map<int, int> lmmap;

    for(int i = 0 ; i < N + M ; i ++ ) {
        int a, b;
        cin >> a >> b;
        lmmap[a] = b;
    }

    queue<pair<int, int>> mq; //주사위 횟수, 현재 위치

    if(lmmap[1] == 0) {
        mq.push(make_pair(0,1));
    }
    else {
        mq.push(make_pair(0, lmmap[1]));
    }


    while(!mq.empty()) {
        int dice = mq.front().first;
        int cur = mq.front().second;
        mq.pop();

        //주사위 굴리기
        for(int i = 1 ; i < 7 ; i ++ ) {
            if(cur + i <= 100) {
                if(lmmap[cur + i] == 0) {
                    if(vec[cur + i] > dice + 1) {
                        vec[cur + i] = dice + 1;
                        mq.push(make_pair(dice + 1, cur + i));
                    }
                }
                else if(lmmap[cur + i] != 0) {
                    if(vec[lmmap[cur + i]] > dice + 1) {
                        vec[lmmap[cur + i]] = dice + 1;
                        mq.push(make_pair(dice + 1, lmmap[cur + i]));
                    }
                }
            }
        }
    }

    cout << vec[100];
    return 0;
}