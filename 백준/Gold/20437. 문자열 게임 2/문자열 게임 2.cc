//
// Created by Yunjae on 2025-03-31.
//
#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main() {
    
    int N ;
    cin >> N;
    while(N--) {
        string str;
        cin >> str;

        int k;
        cin >> k;

        map<char, vector<int>> mmap; //char, idx;s

        for(int i = 0 ; i < str.size(); i ++ ) {
            mmap[str[i]].push_back(i);
        }

        int min = str.size();
        int max = -1;

        for(auto a : mmap) {
            if(a.second.size() >= k) {
                for(int i = 0 ; i < a.second.size() ; i ++ ) {
                    if(i + (k - 1) < a.second.size()) {
                        // cout << str.substr(a.second[i], a.second[i + (k - 1)] - a.second[i] + 1) << '\n';
                        if(min > a.second[i + (k - 1)] - a.second[i] + 1) min = a.second[i + (k - 1)] - a.second[i] + 1;
                        if(max < a.second[i + (k - 1)] - a.second[i] + 1) max = a.second[i + (k - 1)] - a.second[i] + 1;
                    }
                }
            }
        }

        if(min == str.size() && max == -1) cout << -1 << '\n';
        else cout << min << ' ' << max << '\n';
    }


    return 0;
}