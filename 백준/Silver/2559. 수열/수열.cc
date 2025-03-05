//
// Created by Yunjae on 2025-03-05.
//
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, K;
    cin >> N >> K;
    vector<int> vec;

    while(N--) {
        int a;
        cin >> a;
        vec.push_back(a);
    }

    int sum = 0;
    for(int i = 0 ; i < K ;i ++) {
        sum += vec[i];
    }
    int max = sum;

    int end = K;
    for(int i = 0 ; i < vec.size() - K ; i ++ ) {
        sum -= vec[i];
        sum += vec[end++];
        if(max < sum) max = sum;
    }

    cout << max;


    return 0;
}