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
    map<long, int> mmap1253;

    while(n--) {
        long long e;
        cin >> e;
        mmap1253[e] ++;
        vec.push_back(e);
    }

    for(int i = 0 ; i < vec.size() - 1 ; i ++ ) {
        int end = i + 1;
        long long sum = vec[i] + vec[end];
        while(end < vec.size()) {
            if(mmap1253[sum]) {
                if(sum == vec[i] && sum == vec[end]) {
                    if(mmap1253[sum] > 2) {
                        result.push_back(sum);
                    }
                }
                else if(sum == vec[i] || sum == vec[end]) {
                    if(mmap1253[sum] >= 2) {
                        result.push_back(sum);
                    }
                }
                else {
                    result.push_back(sum);
                }
            }
            sum -= vec[end];
            sum += vec[++end];
        }
    }

    int answer = 0;
    for(auto a : result) {
        //cout << a << ' ';
        answer += mmap1253[a];
        mmap1253[a] = 0;
    }
    cout << answer;

    return 0;
}
