//
// Created by Yunjae on 2025-04-09.
//
#include <iostream>
#include <vector>
using namespace std;

vector<int> tempvec;

int n, k;
int cntt = 0;
string resstr = "";

void bt12101(int sum){
    if(sum == n) {
        cntt ++;
        if(cntt == k) {
            for(int i = 0 ; i < tempvec.size() - 1; i ++ ) {
                resstr += to_string(tempvec[i]);
                resstr += '+';
            }
            resstr += to_string(tempvec[tempvec.size() - 1]);
        }
        return;
    }
    if(sum > n) return;
    for(int i = 1 ; i < 4 ; i ++) {
        tempvec.push_back(i);
        bt12101(sum + i);
        tempvec.pop_back();
    }
}

int main() {
    cin >> n >> k;

    bt12101(0);

    if(resstr.size() == 0) cout << -1;
    else cout << resstr;

    return 0;
}