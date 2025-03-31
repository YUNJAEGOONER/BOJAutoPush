//
// Created by Yunjae on 2025-03-31.
//
#include<vector>
#include<iostream>
using namespace std;

int main() {
    //cout << "Baek14719" ;

    int H, W;
    cin >> H >> W;

    int max= 0;

    vector<int> vec;

    int max_idx = 0;
    for(int i = 0 ; i < W ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
        if(max <= e) {
            max = e;
            max_idx = i;
        }
    }

    int answer = 0;

    int cur_max = vec[0];
    for(int i = 1 ; i < max_idx ; i ++ ) {
        if(cur_max >= vec[i]) {
            //cout << cur_max;
            //cout << (cur_max - vec[i]);
            answer += (cur_max - vec[i]);
        }
        else {
            cur_max = vec[i];
            //cout << cur_max;
        }
    }

    cur_max = vec[vec.size() - 1];
    for(int i = vec.size() - 1; i > max_idx ; i -- ) {
        if(cur_max >= vec[i]) {
            //cout << cur_max;
            answer += (cur_max - vec[i]);
        }
        else {
            cur_max = vec[i];
            //cout << cur_max;
        }
    }

    cout << answer;


    return 0;
}