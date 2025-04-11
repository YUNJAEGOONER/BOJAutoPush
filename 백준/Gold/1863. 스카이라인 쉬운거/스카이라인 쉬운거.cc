//
// Created by Yunjae on 2025-04-11.
//
#include <iostream>
#include <vector>
#include <map>
using namespace std;

int main() {
    
    int n;
    cin >> n;

    map<int, int> mmap;
    int max = -1;
    for(int i = 0 ; i < n ; i ++ ) {
        int e, h;
        cin >> e >> h;
        mmap[e] = h;
        if(h == 0) mmap[e] = -1;
        if(max < e) max = e;
    }

    vector<int> vec;
    int prev = 0;
    for(int i = 1 ; i < max + 1 ; i ++) {
        if(mmap[i] == 0)vec.push_back(prev);
        else {
            if(mmap[i] == -1) {
                vec.push_back(0);
                prev = 0;
            }
            else {
                vec.push_back(mmap[i]);
                prev = mmap[i];
            }
        }
    }
    vector<int> visited(vec.size());

    int answer = 0;

    for(int i = 0 ; i < vec.size() ; i ++ ) {
        int cur_h = 0;
        if(visited[i] == 0 && vec[i] > 0) {
            visited[i] = 1;
            answer ++;
            cur_h = vec[i];
            int end_idx = i;
            while(vec[end_idx] >= cur_h) {
                end_idx ++;
                if(vec[end_idx] == cur_h) {
                    visited[end_idx] = 1;
                }
            }
        }
    }
    
    cout << answer << ' ';
    
    return 0;
}