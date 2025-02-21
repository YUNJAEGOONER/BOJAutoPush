//
// Created by Yunjae on 2025-02-21.
//
#include<iostream>
#include<vector>
using namespace std;

vector<vector<int>> visited2;
vector<int> arr2;
int MAX, LENGTH;

void bfs_mn2(int depth) {
    if(depth == LENGTH) {
        for(int i = 0 ; i < arr2.size() ; i ++ ) {
            cout << arr2[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i = 0 ; i < MAX ; i ++) {
        if(!visited2[depth][i]) {
            arr2.push_back(i + 1);
            visited2[depth][i] = 1;
            bfs_mn2(depth + 1);
            visited2[depth][i] = 0;
            arr2.pop_back();
        }
    }

}

int main() {

    int N, M;
    cin >> N >> M;

    MAX = N;
    LENGTH = M;

    //visited2 = vector<int>(N);
    for(int i = 0 ; i < N ; i ++ ) {
        vector<int> row(N);
        visited2.push_back(row);
    }

    bfs_mn2(0);

    return 0;
}