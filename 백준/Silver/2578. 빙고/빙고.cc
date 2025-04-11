//
// Created by Yunjae on 2025-04-11.
//
#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main() {

    map<int, pair<int, int>> mmap;

    for(int i = 0 ; i < 5 ; i ++ ) {
        for(int j = 0 ; j < 5 ; j ++ ) {
            int e;
            cin >> e;
            mmap[e] = make_pair(i, j);
        }
    }

    vector<int> x(5);
    vector<int> y(5);
    vector<int> d(2);

    int cnt = 0;
    int answer = 0;

    for(int i = 0 ; i < 5 ; i ++ ) {
        for(int j = 0 ; j < 5 ; j ++ ) {
            cnt ++;
            int a;
            cin >> a;
            int binggo = 0;
            
            x[mmap[a].first] ++;
            y[mmap[a].second] ++;

            if(mmap[a].first ==  mmap[a].second) {
                d[0] ++;
            }

            if(mmap[a].first + mmap[a].second == 4) {
                d[1] ++;
            }

            for(int k = 0 ; k < x.size() ; k ++ ) {
                if(x[k] == 5) binggo++;
                if(y[k] == 5) binggo++;
            }

            for(int k = 0 ; k < d.size() ; k ++ ) {
                if(d[k] == 5) binggo++;
            }

            if(answer == 0 && binggo >= 3) {
                answer = cnt;
                break;
            }
        }

    }
    
    cout << answer;
    return 0;
}