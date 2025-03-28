//
// Created by Yunjae on 2025-03-28.
//
#include <iostream>
using namespace std;

int main() {
    string str;
    cin >> str;

    int answer = str.size();

    int bcnt = 0;
    for(auto a : str) if(a == 'b') bcnt++;

    if(bcnt == 0) answer = 0;

    for(int i = 0 ; i < str.size() ; i ++ ) {
        int cnt = 0;
        if(str[i] == 'b') {
            for(int j = i ; j < i + bcnt ; j ++ ) {
                if(str[j % str.size()] != 'b') {
                    cnt ++;
                }
            }
            if(answer > cnt) answer = cnt;
        }
    }
    cout << answer << '\n';
    return 0;
}