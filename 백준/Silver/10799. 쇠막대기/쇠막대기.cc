//
// Created by Yunjae on 2025-03-06.
//
#include<iostream>
#include<stack>
using namespace std;

int main() {
    int result = 0;
    string str;
    cin >> str;
    stack<char> mstack;

    for(int i = 0 ; i < str.size() - 1 ; i ++ ) {
        if(str[i] == '(' && str[i + 1] == ')') {
            if(!mstack.empty()) {
                result += mstack.size();
            }
            i = i + 1;
        }
        else {
            if(str[i] == ')') {
                mstack.pop();
                result += 1;
            }
            else {
                mstack.push('(');
            }
        }

    }
    //cout << result;
    cout << result + mstack.size();
    return 0;
}