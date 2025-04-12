//
// Created by Yunjae on 2025-04-12.
//
#include<iostream>
#include <set>
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

    int answer = 0;
    for(int i = 0 ; i < n ; i ++ ) {
        int sum = 0;

        int cnt = 0;
        double min = 0;
        for(int j = i - 1 ; j > - 1 ; j -- ) {
            double x = ((double)(vec[i] - vec[j])/(double)(i - j));
            if(cnt == 0) {
                cnt ++;
                min = x;
            }
            else {
                if(min > x) {
                    min = x;
                    cnt ++;
                }
            }
        }
        sum += cnt;

        cnt = 0;
        double max = 0;
        for(int j = i + 1 ; j < n ; j ++ ) {
            double x = ((double)(vec[j] - vec[i])/(double)(j - i));
            if(cnt == 0) {
                cnt ++;
                max = x;
            }
            else {
                if(max < x) {
                    max = x;
                    cnt ++;
                }
            }
        }
        sum += cnt;
        if(answer < sum) answer = sum;
    }

    cout << answer;
    return 0;
}