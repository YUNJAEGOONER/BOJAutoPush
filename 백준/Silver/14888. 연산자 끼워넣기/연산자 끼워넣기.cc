//
// Created by Yunjae on 2025-02-22.
//
#include<iostream>
#include<vector>
#include<climits>
using namespace std;

vector<int> intarr;
vector<int> dfsarr;
vector<int> matharr;
vector<int> visited14888;

int mmmax = INT_MIN;
int mmmin = INT_MAX;


void opdfs(int depth) {
    if(depth == matharr.size()) {
        int sum = intarr[0];
        for(int i = 0 ; i < dfsarr.size() ; i ++ ) {
            if(dfsarr[i] == 0) {
                sum += intarr[i + 1];
                //cout << "add ";
            }
            else if(dfsarr[i] == 1) {
                sum -= intarr[i + 1];
                //cout << "minus ";
            }
            else if(dfsarr[i] == 2) {
                sum *= intarr[i + 1];
                //cout << "mul ";
            }
            else {
                sum /= intarr[i + 1];
                //cout << "div ";
            }
        }
        if(mmmin > sum) mmmin = sum;
        if(mmmax < sum) mmmax = sum;
        //cout << '\n';
        return;
    }
    for(int i = 0 ; i < matharr.size() ; i ++ ) {
        if(!visited14888[i]) {
            visited14888[i] = 1;
            dfsarr.push_back(matharr[i]);
            opdfs(depth + 1);
            visited14888[i] = 0;
            dfsarr.pop_back();
        }
    }
}

int main() {
    int n;
    cin >> n;

    while(n -- ) {
        int e;
        cin >> e;
        intarr.push_back(e);
    }

    for(int i = 0 ; i < 4 ; i ++ ) {
        int op;
        cin >> op;
        for(int j = 0 ; j < op; j ++ ) {
            matharr.push_back(i);
        }
    }

    visited14888 = vector<int>(matharr.size());
    opdfs(0);

    cout << mmmax << '\n' << mmmin;

    return 0;
}