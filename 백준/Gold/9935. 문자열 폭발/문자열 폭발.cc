//
// Created by Yunjae on 2025-04-07.
//
#include<iostream>
#include<stack>
using namespace std;

int main() {
    string str;
    cin >> str;

    string target;
    cin >> target;

    stack<char> stk;

    int size = target.size();

    // for(int i = 0 ; i < str.size() ; i ++) {
    //     if(i >= size - 1 && str[i] == target[size - 1]) {
    //         if(target == str.substr(i - (size - 1), size)) {
    //             str.erase(i - (size - 1), size);
    //             i = i - size;
    //         }
    //     }
    // }

    for(int i = 0 ; i < str.size() ; i ++ ) {
        stk.push(str[i]);
        if(stk.top() == target[size - 1] && stk.size() >= size) {
            stack<char> temp;
            for(int j = size - 1 ; j > -1 ; j--) {
                if(stk.top() == target[j]) {
                    temp.push(stk.top());
                    stk.pop();
                }
                else {
                    break;
                }
            }
            if(temp.size() != size) {
                while(!temp.empty()) {
                    stk.push(temp.top());
                    temp.pop();
                }
            }
        }
    }

    string result = "";
    while(!stk.empty()){
        result += stk.top();
        stk.pop();
    }

    if(result.size() == 0) cout << "FRULA";
    else cout << string(result.rbegin(), result.rend());


    return 0;
}