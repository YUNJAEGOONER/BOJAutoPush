//
// Created by Yunjae on 2025-03-21.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<long long> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        long long e;
        cin >> e;
        vec.push_back(e);
    }

    sort(vec.begin(), vec.end());

    int i = 0;
    int j = vec.size() - 1;

    int tempi = vec[i];
    int tempj = vec[j];

    long long min = LONG_LONG_MAX;

    while(i < j) {
        long long liquid = vec[i] + vec[j];
        if(abs(liquid) < min) {
            tempi = vec[i];
            tempj = vec[j];
            min = abs(liquid);
        }
        if(liquid > 0) {
            j --;
        }
        else {
            i ++;
        }
    }

    cout << tempi << ' ' << tempj;

    return 0;
}