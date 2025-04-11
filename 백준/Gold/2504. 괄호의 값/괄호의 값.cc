//
// Created by Yunjae on 2025-04-11.
//
#include<iostream>
#include<stack>
using namespace std;

int main() {

    string str;
    cin >> str;

    stack<char> stk;

    int sum = 0;
    int temp = 0;

    int mul = 1;
    for(int i = 0 ; i < str.size() ; i ++ ) {
        if(str[i] == '(') {
            mul *= 2;
            stk.push(i);
        }
        else if(str[i] == '[') {
            mul *= 3;
            stk.push(i);
        }
        else if(str[i] == ')') {
            if(!stk.empty() && str[stk.top()] == '(') {
                if(i - stk.top() == 1) {
                    sum += mul;
                }
                stk.pop();
                mul /= 2;
            }
            else {
                stk.push(str[i]);
                break;
            }
        }
        else {
            if(!stk.empty() && str[stk.top()] == '[') {
                if(i - stk.top() == 1) {
                    sum += mul;
                }
                stk.pop();
                mul /= 3;
            }
            else {
                stk.push(str[i]);
                break;
            }
        }

        if(stk.empty()) mul = 1;
    }

    if(!stk.empty()) cout << 0;
    else cout << sum;

    return 0;
}