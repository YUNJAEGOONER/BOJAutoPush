//
// Created by Yunjae on 2025-02-22.
//
#include <iostream>
#include <vector>

using namespace std;

int maxi = 5;
int manswer = 0;
int rvalue = 0;
string target;
vector<char> carr;
vector<int> mchar;

void prt_arr(vector<char> narr) {
    manswer ++;
    string tostr = "";
    for(int i = 0 ; i < narr.size(); i ++ ) {
        tostr += narr[i];
    }
    if(tostr == target) rvalue = manswer;
}

void dfs_dic(int depth){
    if(depth > 0) {
        prt_arr(carr);
        if(depth == maxi) {
            return;
        }
    }
    for(int i = 0 ; i < 5 ; i ++ ) {
        carr.push_back(mchar[i]);
        dfs_dic(depth + 1);
        carr.pop_back();
    }
}

int solution(string word) {
    int answer = 0;
    
    mchar.push_back('A');
    mchar.push_back('E');
    mchar.push_back('I');
    mchar.push_back('O');
    mchar.push_back('U');
    
    target = word;
    
    dfs_dic(0);
    
    return rvalue;
}