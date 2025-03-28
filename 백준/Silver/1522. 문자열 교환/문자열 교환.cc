//
// Created by Yunjae on 2025-03-28.
//
#include <iostream>
#include <vector>
#include<algorithm>
using namespace std;

int main() {
    
    string strin;
    cin >> strin;
    
    string str = strin;
    sort(str.begin(), str.end());
    string sa = str;

    sort(str.rbegin(), str.rend());
    string sb = str;

    int answer = str.size();

    for(int i = 0 ; i < strin.size() ; i ++ ) {
        string temp = "";
        int cnt = 0;

        for(int j = i ; j < i + strin.size() ; j ++ ) {
            temp += strin[j % strin.size()];
        }

        if (temp[0] == 'b') {
            for(int j = 0 ; j < sb.size() ; j ++ ) {
                if(temp[j] != sb[j]) {
                    cnt ++;
                }
            }
        }
        else {
            for(int j = 0 ; j < sa.size() ; j ++ ) {
                if(temp[j] != sa[j]) {
                    cnt ++;
                }
            }
        }
        if(answer > cnt) answer = cnt;
    }

    cout << answer / 2 << '\n';
    return 0;
}