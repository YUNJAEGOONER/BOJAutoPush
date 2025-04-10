//
// Created by Yunjae on 2025-04-10.
//
#include<iostream>
#include<stack>
#include <vector>
using namespace std;

int main() {
    int N, K;
    cin >> N >> K;
    string num;
    cin >> num;

    string answer = "";

    stack<char> stk;
    stk.push(num[0]);

    int cnt = 0;
    for(int i = 1; i < num.size() ; i ++ ) {
        while(!stk.empty() && stk.top() < num[i] && cnt < K) {
            stk.pop();
            cnt ++;
        }
        stk.push(num[i]);
    }

    while(!stk.empty()) {
        answer += stk.top();
        stk.pop();
    }


    cout << string(answer.rbegin(), answer.rend()).substr(0, N-K);

    return 0;
}