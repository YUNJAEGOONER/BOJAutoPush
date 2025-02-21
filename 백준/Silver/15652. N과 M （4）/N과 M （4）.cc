//
// Created by Yunjae on 2025-02-21.
//
#include<iostream>
#include<vector>
using namespace std;

vector<int> visited2;
vector<int> arr2;
int MAX, LENGTH;

void bfs_mn2(int start, int depth) {
    if(depth == LENGTH) {
        for(int i = 0 ; i < arr2.size() ; i ++ ) {
            cout << arr2[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = start ; i < MAX ; i ++) {
        arr2.push_back(i + 1);
        //visited2[i] = 1;
        bfs_mn2(i, depth + 1);
        //visited2[i] = 0;
        arr2.pop_back();

    }
}

int main() {

    int N, M;
    cin >> N >> M;

    MAX = N;
    LENGTH = M;

    visited2 = vector<int>(N);
    
    bfs_mn2(0, 0);

    return 0;
}