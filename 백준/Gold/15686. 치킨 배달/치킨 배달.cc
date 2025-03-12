//
// Created by Yunjae on 2025-03-12.
//
#include<iostream>
#include<vector>
#include<climits>
using namespace std;

vector<int> cp;

vector<pair<int, int>> cvec;
vector<pair<int, int>> hvec;

int cdis = INT_MAX;

void kyochon(int start, int depth, int limit) {
    if(depth == limit) {

        int sum = 0;

        for(int i = 0 ; i < hvec.size() ; i ++ ) {
            int min = INT_MAX;
            for(int j = 0 ; j < cp.size() ; j ++ ) {
                if(cp[j]) {
                    int dis = abs(hvec[i].first - cvec[j].first) + abs(hvec[i].second - cvec[j].second);
                    if(dis < min) min = dis;
                }
            }
            sum += min;
        }
        if(sum < cdis) cdis = sum;
        return;

    }
    for(int i = start ; i < cp.size() ; i ++ ){
        if(!cp[i]) {
            cp[i] = 1;
            kyochon(i + 1, depth + 1, limit);
            cp[i] = 0;
        }
    }
}

int main() {

    int n, m;
    cin >> n >> m;

    vector<vector<int>> house;


    for(int i = 0 ; i < n ; i ++ ) {
        vector<int> row;
        for(int j = 0 ; j < n ; j ++ ) {
            int e;
            cin >> e;
            row.push_back(e);
            if(e == 1) hvec.push_back(make_pair(i + 1, j + 1));
            if(e == 2) cvec.push_back(make_pair(i + 1, j + 1));
        }
        house.push_back(row);
    }

    cp = vector<int> (cvec.size());

    kyochon(0, 0, m);

    cout << cdis;

    return 0;
}