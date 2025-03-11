//
// Created by Yunjae on 2025-03-11.
//
#include<iostream>
#include<map>
#include<stack>
#include<vector>
using namespace std;

int main() {
    map<char, pair<char, char>> trees;
    int n;
    cin >> n;


    for(int i = 0 ; i < n ; i ++ ) {
        char root, r, l;
        cin >> root >> r >> l;
        trees[root] = make_pair(r, l);

    }
    
    stack<char> stk;
    stk.push('A');

    //전위 순회 - Root R L
    while(!stk.empty()) {
        char cur = stk.top();
        stk.pop();
        cout << cur;
        if(trees[cur].second != '.') stk.push(trees[cur].second);
        if(trees[cur].first != '.') stk.push(trees[cur].first);
    }
    cout << '\n';

    vector<int> visited2(26);
    stack<char> stk3;
    stk3.push('A');

    //중위 순회 - L Root Right;
    while(!stk3.empty()) {
        char cur = stk3.top();
        if(trees[cur].first != '.' && visited2[trees[cur].first] == 0) stk3.push(trees[cur].first);
        else if(trees[cur].second != '.' && visited2[trees[cur].second] == 0) {
            cout << cur;
            visited2[cur] = 1;
            stk3.push(trees[cur].second);
        }
        else {
            if(!visited2[cur]) {
                cout << cur;
                visited2[cur] = 1;
            }
            stk3.pop();
        }
    }

    cout << '\n';


    vector<int> visited(26);
    stack<char> stk2;
    stk2.push('A');

    //후위 순회 L R root
    while(!stk2.empty()) {
        char cur = stk2.top();
        if(trees[cur].first != '.' && visited[trees[cur].first] == 0) stk2.push(trees[cur].first);
        else if(trees[cur].second != '.' && visited[trees[cur].second] == 0) stk2.push(trees[cur].second);
        else {
            cout << cur;
            visited[cur] = 1;
            stk2.pop();
        }
    }



    return 0;
}