//
// Created by Yunjae on 2025-04-10.
//
#include <iostream>
#include <vector>
using namespace std;

//중복허용
vector<int> btemp;
int tdepth;

void bt7490(int depth) {
    if(depth == tdepth) {
        string e = "1";
        int num = 2;
        for(int i = 0 ; i < btemp.size(); i ++ ) {
            if(btemp[i] == 1) {
                e += '+';
            }
            else if(btemp[i] == 2) {
                e += '-';
            }
            else {
                e += ' ';
            }
            e += to_string(num++);
        }

        int sum = 0;
        string tstr = "";
        for(int i = 0 ; i < e.size() ; i ++ ) {
            if(e[i] == '+') {
                sum += stoi(tstr);
                tstr = "";
            }
            else if(e[i] == '-') {
                sum += stoi(tstr);
                tstr = "-";
            }
            else if('0' <= e[i] && e[i] <= '9'){
                tstr += e[i];
            }
        }
        if(tstr.size()) sum += stoi(tstr);
        if(sum == 0) cout << e << '\n';
        return;
    }
    for(int i = 0 ; i < 3; i ++ ) {
        btemp.push_back(i);
        bt7490(depth + 1);
        btemp.pop_back();
    }
}

int main() {
    int q;
    cin >> q;
    while(q--) {
        cin >> tdepth;
        tdepth --;
        bt7490(0);
        cout << '\n';
    }
    return 0;
}