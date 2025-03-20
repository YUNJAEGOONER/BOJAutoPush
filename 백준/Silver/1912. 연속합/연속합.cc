//
// Created by Yunjae on 2025-03-20.
//
#include <iostream>
#include <vector>
using namespace std;

int main() {
    
    int n;
    cin >> n;
    vector<int> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    int max = vec[0];
    for(int i = 1 ; i < n ; i ++ ) {
        if (vec[i - 1] + vec[i] > vec[i]) {
            vec[i] = vec[i - 1] + vec[i];
        }
        if(max < vec[i]) {
            max = vec[i];
        }
    }

    cout << max;
    return 0;
}