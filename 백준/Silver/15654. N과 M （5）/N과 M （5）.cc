//
// Created by Yunjae on 2025-02-22.
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> myvec;
vector<int> myarr;
vector<int> visited5;
int maxdepht;

void dfsmn5(int depth) {
    if(depth == maxdepht) {
        for(int i = 0 ; i < myarr.size() ; i ++ ) {
            cout << myarr[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = 0 ; i < myvec.size() ; i ++ ) {
        if(!visited5[i]) {
            visited5[i] = 1;
            myarr.push_back(myvec[i]);
            dfsmn5(depth + 1);
            visited5[i] = 0;
            myarr.pop_back();
        }
    }
}

int main() {
    int a;
    cin >> a >> maxdepht;
    for(int i = 0 ; i < a ; i ++ ) {
        int n;
        cin >> n;
        myvec.push_back(n);
    }

    sort(myvec.begin(), myvec.end());

    visited5 = vector<int>(a);
    dfsmn5(0);

    return 0;
}