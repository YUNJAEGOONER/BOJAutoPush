//
// Created by Yunjae on 2025-03-21.
//
#include<iostream>
#include<vector>
#include<map>
#include<stack>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<string> words;

    map<int, vector<string>> wordsize;

    for(int i = 0; i < n ; i ++ ) {
        string str;
        cin >> str;
        words.push_back(str);
    }

    vector<map<char, int>> wmap;

    for(int i = 0 ; i < words.size() ; i ++ ) {
        map<char, int> tmap;
        string cur = words[i];
        for(int j = 0 ; j < words[i].size() ; j ++ ) {
            tmap[words[i][j]]++;
        }
        wmap.push_back(tmap);
    }

    int answer = 0;
    int std = 0;

    for(int j =  1 ; j < wmap.size() ; j ++ ) {
        int diffsize = words[std].size() - words[j].size() ;

        if(abs(diffsize) == 1){
            int cnt = 0;
            for(int i = 0 ; i < 26; i ++ ) {
                int diff = wmap[std]['A' + i] - wmap[j]['A' + i];
                cnt += abs(diff);
            }
            if(cnt == 1) {
                //cout << words[j] << '\n';
                answer ++;
            }
        }

        else if(abs(diffsize) == 0) {
            //구성이 똑같은 경우
            if(wmap[std] == wmap[j]) {
                //cout << words[j] << '\n';
                answer ++;
            }
            else {
                int cnt = 0;
                for(int i = 0 ; i < 26; i ++ ) {
                    int min = 0;
                    if(wmap[std]['A' + i] > wmap[j]['A' + i]) {
                        min = wmap[j]['A' + i];
                    }
                    else {
                        min = wmap[std]['A' + i];
                    }
                    cnt += min;
                }
                if(words[std].size() - cnt <= 1) {
                    //cout << words[j] << '\n';
                    answer ++;
                }
            }
        }

    }
    cout << answer << ' ';

    return 0;
}