//
// Created by Yunjae on 2025-03-19.
//
#include<iostream>
#include<vector>
using namespace std;

string str = "";

void to_quad(vector<vector<int>> arr, int idx, int jdx, int size) {
    int sum = 0;

    for(int i = idx; i < idx + size ; i ++ ) {
        for(int j = jdx ; j < jdx + size ; j ++ ) {
            sum += arr[i][j];
        }
    }

    if(sum == 0) {
        str += '0';
        return;
    }
    if (sum == (size * size)) {
        str += '1';
        return;
    }
    str += '(';
    to_quad(arr, idx, jdx, size/2);
    to_quad(arr, idx, jdx + size/2, size/2);
    to_quad(arr, idx + size/2, jdx, size/2);
    to_quad(arr, idx + size/2, jdx + size/2, size/2);
    str += ')';

};

int main() {
    int n;
    cin >> n;

    vector<vector<int>> mvec;


    for(int i = 0 ; i < n ; i ++ ) {
        string mstr;
        cin >> mstr;
        vector<int> row;
        for(int j = 0 ; j < n ; j ++ ) {
            row.push_back(mstr[j] - '0');
        }
        mvec.push_back(row);
    }

    to_quad(mvec, 0, 0, mvec.size());

    cout << str << '\n';

    return 0;
}