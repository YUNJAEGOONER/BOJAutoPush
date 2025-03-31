//
// Created by Yunjae on 2025-03-31.
//
#include <iostream>
#include <vector>
using namespace std;

int main(){

    string s, t;
    cin >> s >> t;
    
    vector<char> vec;
    for(int i = 0 ; i < t.size() ; i ++ ) {
        vec.push_back(t[i]);
    }

    int answer = 0;

    while(s.size() <= vec.size()) {
        if(s == string(vec.begin(), vec.end())) {
            answer = 1;
            break;
        }
        if(vec[vec.size() - 1] == 'B') {
            vec.erase(vec.end() - 1);
            vec = vector(vec.rbegin(), vec.rend());
        }
        else if(vec[vec.size() - 1] == 'A'){
            vec.erase(vec.end() - 1);
        }
        else {
            break;
        }
    }

    cout << answer << '\n';

    return 0;
}