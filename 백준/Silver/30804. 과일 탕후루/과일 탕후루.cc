//
// Created by Yunjae on 2025-03-25.
//
#include<iostream>
#include<vector>
#include<map>
using namespace std;

int main() {

    //cout << "Fruit Tanghoroo" << '\n';

    int n;
    cin >> n;

    vector<int> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    int max = -1;

    int start = 0;
    int end = 0;

    map<int, int> mmap;
    mmap[vec[0]] ++;

    while(true) {
        if(end == n - 1) {
            if(end - start + 1 > max) max = (end - start + 1);
            break;
        }
        mmap[vec[end + 1]]++ ;
        if(mmap.size() <= 2) {
            end += 1;
        }
        else if(mmap.size() > 2) {
            if(end - start + 1 > max) max = (end - start + 1);
            while(true) {
                if(mmap.size() <= 2) {
                    break;
                }
                mmap[vec[start]]--;
                if(mmap[vec[start]] == 0) {
                    mmap.erase(vec[start]);
                }
                start ++;
            }
            end += 1;
        }
    }

    cout << max;

    return 0;

}