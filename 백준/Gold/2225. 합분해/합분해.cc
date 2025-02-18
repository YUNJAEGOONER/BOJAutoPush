//
// Created by Yunjae on 2025-02-18.
//

#include <iostream>
#include <map>
using namespace std;

int main(){

    int n, k ;
    cin >> n >> k;
    long long result = 1;

    if(k != 1) {
        map<int, long long> mmap;
        for(int i = 0 ; i < n + 1  ; i ++ ) {
            mmap[i] = i + 1;
        }
        for(int i = 2 ; i < k ; i ++){
            map<int, long long> tmap;
            for(int j = 0 ; j < n + 1 ; j ++ ) {
                if(j == 0) tmap[0] = 1;
                else tmap[j] = (tmap[j - 1] + mmap[j]) % 1000000000;
            }
            mmap = tmap;
        }
        result = mmap[n];
    }

    cout << result % 1000000000;
    return 0;
}