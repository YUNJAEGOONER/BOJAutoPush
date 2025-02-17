//
// Created by Yunjae on 2025-02-17.
//

#include <iostream>
#include <vector>
#include <map>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<vector<int>>rgb;

    for(int i = 0 ; i < n ; i ++ ){
        int r, g, b;
        cin >> r >> g >> b;
        vector<int> colors;
        colors.push_back(r);
        colors.push_back(g);
        colors.push_back(b);
        rgb.push_back(colors);
    }

    int sum = 0;

    vector<int>sums;
    sums.push_back(rgb[0][0]);
    sums.push_back(rgb[0][1]);
    sums.push_back(rgb[0][2]);

    for(int i = 1 ; i < n ; i ++ ) {
        vector<int> newrows(3);
        //0으로
        if(sums[1] + rgb[i][0] > sums[2] + rgb[i][0]) {
            newrows[0] = sums[2] + rgb[i][0];
        }
        else {
            newrows[0] = sums[1] + rgb[i][0];
        }

        //1로
        if(sums[0] + rgb[i][1] > sums[2] + rgb[i][1]) {
            newrows[1] = sums[2] + rgb[i][1];
        }
        else {
            newrows[1] = sums[0] + rgb[i][1];
        }

        //2로
        if(sums[1] + rgb[i][2] > sums[0] + rgb[i][2]) {
            newrows[2] = sums[0] + rgb[i][2];
        }
        else {
            newrows[2] = sums[1] + rgb[i][2];
        }
        sums = newrows;
    }

    int result = sums[0];
    for(auto a : sums) {
        if(result > a) {
            result = a;
        }
    }

    cout << result;

    return 0;
}
