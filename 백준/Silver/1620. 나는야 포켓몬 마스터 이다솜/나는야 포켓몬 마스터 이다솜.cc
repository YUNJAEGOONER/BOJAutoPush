//
// Created by Yunjae on 2025-03-10.
//
#include<iostream>
#include<map>
using namespace std;

int main() {

    ios::sync_with_stdio(false);
	cin.tie(0);
    
    int n, q;
    cin >> n >> q;

    map<string, int> dic1;
    map<int, string> dic2;

    int i = 1;
    while(n --) {
        string name;
        cin >> name;
        dic1[name] = i ++;
        dic2[dic1[name]] = name;
    }

    while(q--) {
        string answer;
        cin >> answer;
        if('0' <= answer[0] && answer[0] <= '9') {
            cout << dic2[stoi(answer)] << '\n';
        }
        else {
            cout << dic1[answer] << '\n';
        }
    }

    return 0;
}