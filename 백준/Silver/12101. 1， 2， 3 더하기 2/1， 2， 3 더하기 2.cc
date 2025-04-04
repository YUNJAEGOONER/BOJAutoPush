//
// Created by Yunjae on 2025-04-04.
//
#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main() {

    map<int, vector<string>>mmap;
    mmap[1].push_back("1");

    mmap[2].push_back("1+1");
    mmap[2].push_back("2");

    mmap[3].push_back("1+1+1");
    mmap[3].push_back("1+2");
    mmap[3].push_back("2+1");
    mmap[3].push_back("3");

    int n, idx;
    cin >> n >> idx;

    for(int i = 4 ; i < n + 1 ; i ++ ) {
        int cur_val = i;
        for(int j = 1; j <= 3 ; j ++ ) {
            for(int k = 0 ; k < mmap[cur_val - j].size() ; k ++ ) {
                string tstr = to_string(j) + "+";
                tstr += mmap[cur_val - j][k];
                mmap[cur_val].push_back(tstr);
            }
        }
    }

    if(mmap[n].size() < idx) cout << -1;
    else cout << mmap[n][idx -1];

    return 0;
}