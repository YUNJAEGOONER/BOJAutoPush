//
// Created by Yunjae on 2025-03-21.
//

#include<iostream>
#include<vector>
#include<map>
using namespace std;

int main() {
    
    ios::sync_with_stdio(false);
	cin.tie(NULL);
	
    
    int n;
    cin >> n;

    map<int, int> mmap;

    vector<long> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        long e;
        cin >> e;
        vec.push_back(e);
        mmap[e]++;
    }

    int idx = 0;
    map<int, int> rank;
    for(auto a: mmap) {
        rank[a.first] = idx++;
    }

    for(int i = 0 ; i < n ; i ++ ) {
        cout << rank[vec[i]] << ' ';
    }

    return 0;
}