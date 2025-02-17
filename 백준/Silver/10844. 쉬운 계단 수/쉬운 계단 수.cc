//
// Created by Yunjae on 2025-02-17.
//

#include<iostream>
#include <map>
using namespace std;

int main(){
    int n;
    cin >> n;
    map<int, long long> mmap;
    for(int i = 1 ; i < 10; i ++ ) {
        mmap[i]++;
    }
    mmap[0] = 0;

    for(int i = 1 ; i < n ; i ++ ) {
        map<int, long long> cmap;
        for(auto e: mmap) {
            if(0 <= e.first - 1) {
                cmap[e.first - 1] += (mmap[e.first] % 1000000000);
            }
            if(e.first + 1 <= 9) {
                cmap[e.first + 1] += (mmap[e.first] % 1000000000);
            }
        }
        mmap = cmap;
    }

    long long sum = 0;
    for(auto a : mmap) {
        sum = (sum + a.second) % 1000000000;
    }

    cout << sum;

    return 0;
}