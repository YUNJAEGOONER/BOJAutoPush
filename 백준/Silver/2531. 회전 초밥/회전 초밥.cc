//
// Created by Yunjae on 2025-03-28.
//
#include <iostream>
#include <vector>
#include <map>
using namespace std;

int main() {

    int N, d, k, c;
    cin >> N >> d >> k >> c;

    vector<int> vec;
    for(int i = 0 ; i < N ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    vector<int> sushi(3000 + 1, 0);

    int cnt = 0;
    for(int i = 0 ; i < k ; i ++ ) {
        int cur = vec[i];
        if(sushi[cur] == 0) {
            cnt ++;
        }
        sushi[cur] += 1;
    }
    int max = cnt;
    if(sushi[c] == 0) max++;

    for(int i = k ; i < N + k ; i ++ ) {
        int minus = vec[i - k]; //vec[i - k]
        int add = vec[i % N]; //vec[i]

        sushi[minus] --;
        if(sushi[minus] == 0) cnt --;

        sushi[add] ++;
        if(sushi[add] == 1) cnt ++;

        if(sushi[c] == 0 && max < cnt + 1) max = cnt + 1;
        else if(sushi[c] != 0 && max < cnt) max = cnt;

    }

    cout << max;

    return 0;
}