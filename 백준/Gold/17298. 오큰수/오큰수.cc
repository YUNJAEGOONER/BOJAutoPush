//
// Created by Yunjae on 2025-03-06.
//
#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> vec;

    while(N--){
        int a;
        cin >> a;
        vec.push_back(a);
    }

    vector<int> result(vec.size() , - 1);
    stack<int> mstack;

    for(int i = 0 ; i < vec.size() - 1 ; i ++ ) {
        if(vec[i] >= vec[i + 1]) {
            mstack.push(i);
        }
        else {
            result[i] = vec[i + 1];
            while(mstack.size() && vec[mstack.top()] < vec[i + 1]) {
                result[mstack.top()] = vec[i + 1];
                mstack.pop();
            }
        }
    }

    for(auto a : result) {
        cout << a << ' ';
    }

    return 0;
}
