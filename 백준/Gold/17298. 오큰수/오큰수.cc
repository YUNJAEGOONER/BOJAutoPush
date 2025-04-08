//
// Created by Yunjae on 2025-04-08.
//
#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {

    int N;
    cin >> N;
    vector<int> vec;
    for(int i = 0 ; i < N ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    vector<int> result(N , -1);

    stack<int> stk;
    stk.push(0);

    for(int i = 1;  i < N ; i ++ ) {
        while(!stk.empty() && vec[stk.top()] < vec[i]) {
            result[stk.top()] = vec[i];
            stk.pop();
        }
        stk.push(i);
    }

    for(auto a : result) {
        cout << a << ' ';
    }

    return 0;
}