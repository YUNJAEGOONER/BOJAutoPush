//
// Created by Yunjae on 2025-03-12.
//
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<int> pwvisited;
vector<char> temp;
vector<int> vec;

void make_pw(int start, int depth, int limit) {
    if(depth == limit) {
        string str = "";
        int cnt = 0;
        for(int i = 0 ; i < depth ; i ++ ) {
            if(temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u') {
                cnt++;
            }
            str += temp[i];
        }
        if(cnt >= 1 && depth - cnt >= 2) {
            cout << str <<'\n';
        }
        return;
    }
    for(int i = start ; i < pwvisited.size() ; i ++ ) {
        if(pwvisited[i] == 0) {
            pwvisited[i] = 1;
            temp.push_back(vec[i]);
            pwvisited[i] = 0;
            make_pw(i + 1, depth + 1 , limit);
            temp.pop_back();
        }
    }

}

int main() {
    int l, c;
    cin >> l >> c;

    for(int i = 0 ; i < c ; i ++){
        char e;
        cin >> e;
        vec.push_back(e);
    }

    sort(vec.begin(), vec.end());
    pwvisited = vector<int> (c);
    make_pw(0, 0, l);

    return 0;
}