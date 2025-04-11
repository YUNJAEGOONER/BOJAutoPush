//
// Created by Yunjae on 2025-04-11.
//
#include <iostream>
#include <vector>
using namespace std;

int max_size = 0;

string convert_str(int num) {
    string temp = "";
    string str = to_string(num);
    for(int i = 0 ; i < max_size - str.size() ; i ++ ) {
        temp += "0";
    }
    temp += str;
    return temp;
}

int main() {
    vector<vector<int>> vec;

    //7segements;
    vector<int> zero = {1, 1, 1, 1, 1, 1, 0};
    vector<int> one = {0, 1, 1, 0, 0, 0, 0};
    vector<int> two = {1, 1, 0, 1, 1, 0, 1};
    vector<int> three = {1, 1, 1, 1, 0, 0, 1};
    vector<int> four = {0, 1, 1, 0, 0, 1, 1};
    vector<int> five = {1, 0, 1, 1, 0, 1, 1};
    vector<int> six = {1, 0, 1, 1, 1, 1, 1};
    vector<int> seven = {1, 1, 1, 0, 0, 0, 0};
    vector<int> eight = {1, 1, 1, 1, 1, 1, 1};
    vector<int> nine = {1, 1, 1, 1, 0, 1, 1};
    vec.push_back(zero);vec.push_back(one);
    vec.push_back(two); vec.push_back(three);
    vec.push_back(four); vec.push_back(five);
    vec.push_back(six); vec.push_back(seven);
    vec.push_back(eight); vec.push_back(nine);

    string N, K, P, X;
    cin >> N >> K >> P >> X;

    max_size = stoi(K);

    string temp = "";
    for(int i = 0 ; i < max_size - X.size() ; i ++) {
        temp += "0";
    }
    temp += X;
    X = temp;

    int answer = 0;

    for(int i = 1; i < stoi(N) + 1; i ++ ) {
        string cmp = convert_str(i);
        int cnt = 0;
        for(int j = 0 ; j < cmp.size() ; j ++ ) {
            for(int s = 0 ; s < 8; s ++) {
                //cout << vec[cmp[j]-'0'][s] << '\n';
                //cout << vec[X[j]-'0'][s] << '\n';
                cnt += abs(vec[X[j] - '0'][s] - vec[cmp[j] - '0'][s]);
            }
        }
        //cout << cmp << " - " << X << " - " << cnt << '\n';
        if(cnt <= stoi(P)) answer ++;
    }

    cout << answer - 1;
    return 0;
}