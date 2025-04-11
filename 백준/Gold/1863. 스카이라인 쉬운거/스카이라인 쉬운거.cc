//
// Created by Yunjae on 2025-04-11.
//
#include <iostream>
#include <vector>
#include <map>
#include <stack>
using namespace std;

int main() {
    int n;
    cin >> n;

    map<int, int> mmap;
    int max = -1;
    for(int i = 0 ; i < n ; i ++ ) {
        int e, h;
        cin >> e >> h;
        mmap[e] = h;
    }

    int answer = 0;
    stack<int> stk;
    for(auto a : mmap) {
        if(stk.empty()) {
            if(a.second != 0) {
                stk.push(a.second);
                answer ++;
            }
        }
        else {
            if(stk.top() < a.second) {
                stk.push(a.second);
                answer ++;
            }
            else {
                while(!stk.empty() && stk.top() > a.second) {
                    stk.pop();
                }
                if((stk.empty() || (!stk.empty() && stk.top() != a.second)) && a.second != 0) {
                    stk.push(a.second);
                    answer ++;
                }
            }
        }
    }

    cout << answer << ' ';

    return 0;
}