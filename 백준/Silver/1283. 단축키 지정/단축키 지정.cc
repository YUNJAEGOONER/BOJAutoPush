//
// Created by Yunjae on 2025-03-26.
//
#include<iostream>
#include<vector>
using namespace std;
vector<int> visited1283(26);

int to_word(string str) {
    for(int i = 0 ; i < str.size() ; i ++) {
        if(i == 0) {
            char temp = str[i];
            if('A' <= temp && temp <= 'Z') {
                temp += 32;
            }
            if(visited1283[temp - 'a'] == 0) {
                visited1283[temp - 'a'] = 1;
                return i;
            }
        }
        else if(i > 0 && str[i - 1] == ' ') {
            char temp = str[i];
            if('A' <= temp && temp <= 'Z') {
                temp += 32;
            }
            if(visited1283[temp - 'a'] == 0) {
                visited1283[temp - 'a'] = 1;
                return i;
            }
        }
    }

    for(int i = 0 ; i < str.size() ; i ++ ) {
        char temp = str[i];
        if(temp != ' ') {
            if('A' <= temp && temp <= 'Z') {
                temp += 32;
            }
            if(visited1283[temp - 'a'] == 0) {
                visited1283[temp - 'a'] = 1;
                return i;
            }
        }
    }

    return -1;
}

int main() {
    int N;
    cin >> N;

    cin.ignore();
    while(N--) {
        string str;
        getline(cin, str);
        //cout << str << '\n';
        int idx = to_word(str);
        if(idx != -1) {
            for(int i = 0 ; i < str.size() ; i ++ ) {
                if(i == idx) {
                    cout << '[' << str[i] << ']';
                }
                else {
                    cout << str[i];
                }
            }
            cout <<'\n';
        }
        else {
            cout << str << '\n';
        }

    }
    return 0;
}