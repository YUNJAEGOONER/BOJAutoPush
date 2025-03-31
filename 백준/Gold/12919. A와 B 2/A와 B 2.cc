//
// Created by Yunjae on 2025-03-31.
//
#include<iostream>
#include<queue>
using namespace std;

int main() {
    string s, t;
    cin >> s >> t;

    queue<string> mq;
    mq.push(t);

    int answer = 0;

    while(!mq.empty()) {
        string cur = mq.front();
        mq.pop();

        if(cur == s) {
            answer = 1;
            break;
        }

        if(cur.size() >= s.size()) {
            if(cur[cur.size() - 1] == 'A') {
                mq.push(string(cur.begin(), cur.end() - 1));
            }
            if(cur[0] == 'B') {
                mq.push(string(cur.rbegin(), cur.rend() - 1));
            }
        }

    }
    cout << answer;

    return 0;
}