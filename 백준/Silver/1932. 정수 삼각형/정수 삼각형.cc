//
// Created by Yunjae on 2025-02-17.
//

#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<vector<int>> myvec;
    for(int i = 0 ; i < n ; i ++ ) {
        vector<int> row;
        for(int j = 0;  j < i + 1 ; j ++){
            int n;
            cin >> n;
            row.push_back(n);
        }
        myvec.push_back(row);
    }


    for(int i = 1 ; i < n ; i ++ ) {
        for(int j = 0; j < i + 1; j ++ ) {
            if(j - 1 < 0) {
                myvec[i][j] = myvec[i - 1][j] + myvec[i][j];
            }
            else if(j == i){
                myvec[i][j] = myvec[i - 1][j - 1] + myvec[i][j];
            }
            else {
                if(myvec[i - 1][j - 1] > myvec[i - 1][j]) {
                    myvec[i][j] = myvec[i - 1][j - 1] + myvec[i][j];
                }
                else {
                    myvec[i][j] = myvec[i - 1][j] + myvec[i][j];
                }
            }
        }
    }

    int max = myvec[n-1][0];
    for(auto e: myvec[n-1]) {
        if(max < e) max = e;
    }

    cout << max;


    return 0;
}
