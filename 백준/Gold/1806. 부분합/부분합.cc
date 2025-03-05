//
// Created by Yunjae on 2025-03-05.
//
#include<iostream>
#include<vector>
using namespace std;

int main() {
    int N, S;
    cin >> N >> S;

    vector<int> vec;
    while(N--) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    int sum = 0;
    int end = 0;
    int length = vec.size() + 1;

    for(int i = 0 ; i < vec.size() ; i ++) {
        while(sum < S && end < vec.size()) {
            sum += vec[end++];
        }
        if(sum >= S && length > end - i) {
            length = end - i;
        }
        sum -= vec[i];
    }
    if(length == vec.size() + 1) {
        length = 0;
    }
    cout << length;
    return 0;

}