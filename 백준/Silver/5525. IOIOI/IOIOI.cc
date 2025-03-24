//
// Created by Yunjae on 2025-03-24.
//
#include<iostream>
#include<vector>
using namespace std;

int main() {

    int n;
    cin >> n;

    string temp ="";
    for(int i = 0 ; i < 2 * n + 1 ; i ++) {
        if(i % 2 == 0) temp += "I";
        else temp += "O";
    }

    int m;
    cin >> m;

    string str;
    cin >> str;
    str += "XX";

    int answer = 0;
    for(int i = 0 ; i < str.size() - 2; i ++ ) {
        if(str.substr(i, 2 * n + 1) == temp) {
            answer ++;
        }
    }

    cout << answer;

    return 0;
}