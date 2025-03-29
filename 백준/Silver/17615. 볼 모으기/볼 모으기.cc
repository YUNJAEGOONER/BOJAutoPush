//
// Created by Yunjae on 2025-03-29.
//
#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
    int N;
    cin >> N;

    string str;
    cin >> str;

    stack<int> bstack;
    stack<int> rstack;
    for(int i = 0 ; i < N ; i ++ ) {
        if(str[i] == 'R') rstack.push(i);
        if(str[i] == 'B') bstack.push(i);
    }


    if(bstack.size() == 0 || rstack.size() == 0) {
        cout << 0;
    }
    else {
        stack<int> rtemp = rstack;
        stack<int> btemp = bstack;

        int r = 0;
        while(!rtemp.empty() && !btemp.empty()) {
            if(rtemp.top() > btemp.top()) {
                rtemp.pop();
            }
            else {
                r++;
                rtemp.pop();
                btemp.pop();
            }
        }

        rtemp = rstack;
        btemp = bstack;

        int b = 0;
        while(!rtemp.empty() && !btemp.empty()) {
            if(btemp.top() > rtemp.top()) {
                btemp.pop();
            }
            else {
                b++;
                btemp.pop();
                rtemp.pop();
            }
        }

        if(r > b) cout << b;
        else cout << r;
    }

    return 0;
}