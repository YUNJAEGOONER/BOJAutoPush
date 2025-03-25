//
// Created by Yunjae on 2025-03-25.
//
#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<climits>
using namespace std;

int main() {
    int N, M, B;
    cin >> N >> M >> B;

    map<int, int> mmap;

    int sum = 0;

    vector<vector<int>> vec;
    for(int i = 0 ; i < N ; i ++ ) {
        vector<int> row;
        for(int j = 0 ; j < M ; j ++) {
            int e;
            cin >> e;
            row.push_back(e);
            mmap[e] ++;
            sum += e;
        }
        vec.push_back(row);
    }

    vector<pair<int, int>> inventory;

    int answer = INT_MAX;
    int h = 0;
    for(int i = 256 ; i > - 1 ; i -- ) {

        int n = N * M * i;

        int tempB = B;
        int tempS = sum;

        for(int j = 0 ; j < inventory.size() ; j ++ ) {
            tempB += (inventory[j].first - i) * inventory[j].second;
            tempS -= inventory[j].first * inventory[j].second;
            n -= i * inventory[j].second;
        }

        if(n - tempS <= tempB){
            if(answer > (tempB - B) * 2 + (n - tempS)) {
                answer = (tempB - B) * 2 + (n - tempS);
                h = i;
            }
        }

        if(mmap[i] != 0) {
            inventory.push_back(make_pair(i,mmap[i]));
        }
    }

    cout << answer << ' ' << h;

    return 0;
}