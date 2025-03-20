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

    vector<vector<int>> res(n);

    res[0].push_back(vec[0]); // 제외x
    res[0].push_back(0); //제외

    int max = vec[0];

    for(int i = 1 ; i < n ; i ++ ) {
        int cur = vec[i];
        //하나도 제외하지 않은것
        if(cur < res[i - 1][0] + cur) {
            res[i].push_back(res[i - 1][0] + cur);
        }
        else {
            res[i].push_back(cur);
        }

        //하나를 제외한 것
        if(res[i-1][0] > res[i-1][1] + cur) {
            res[i].push_back(res[i -1][0]);
        }
        else {
            res[i].push_back(res[i-1][1] + cur);
        }
    }

    for(int i = 1; i < res.size() ; i ++ ) {
        if(max < res[i][0]) max = res[i][0];
        if(max < res[i][1]) max = res[i][1];
    }

    cout << max;
    return 0;
}