//
// Created by Yunjae on 2025-04-10.
//
#include<iostream>
#include<vector>
#include<stack>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> vec;

    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    vector<int> result(n);
    stack<int> stk;
    for(int i = n ; i > 0 ; i --) {
        if(stk.empty()) stk.push(i);
        else {
            while(!stk.empty() && vec[stk.top() - 1] < vec[i - 1]) {
                result[stk.top() - 1] = i;
                stk.pop();
            }
            stk.push(i);
        }
    }
    
    for(auto a : result) {
        cout << a << ' ';
    }

    return 0;
}