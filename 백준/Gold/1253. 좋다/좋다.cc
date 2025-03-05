//
// Created by Yunjae on 2025-03-05.
//
#include<vector>
#include<algorithm>
#include<iostream>
#include<map>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<long long> vec;

    vector<long long> result;
    map<long, vector<int>> mmap1253;

    while(n--) {
        long long e;
        cin >> e;
        vec.push_back(e);
        mmap1253[e].push_back(vec.size() - 1);
    }

    sort(vec.begin(), vec.end());

    for(int i = 0 ; i < vec.size() ; i ++ ) {
        long long target = vec[i];

        int s = 0;
        int end = vec.size() - 1;
        int sum = vec[s] + vec[end];


        while(s < end) {
            if(sum == target){
                if(s == i) {
                    sum -= vec[s];
                    sum += vec[++s];
                }
                else if(end == i) {
                    sum -= vec[end];
                    sum += vec[--end];
                }
                else {
                    result.push_back(target);
                    break;
                }
            }
            else {
                if(sum < target) {
                    sum -= vec[s];
                    sum += vec[++s];
                }
                else {
                    sum -= vec[end];
                    sum += vec[--end];
                }
            }
        }
    }

    cout << result.size();

    return 0;
}
