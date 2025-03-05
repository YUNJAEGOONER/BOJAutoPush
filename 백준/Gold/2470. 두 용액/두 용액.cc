//
// Created by Yunjae on 2025-03-05.
//
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

bool mcmp(long a, long b) {
    return abs(a) < abs(b);
}

int main() {
    int N;
    cin >> N;

    vector<long> vec;
    while(N--) {
        long e;
        cin >> e;
        vec.push_back(e);
    }

    sort(vec.begin(), vec.end(), mcmp);

    long sum = vec[0] + vec[1];
    long max = abs(sum);

    int a = 0;
    int b = 1;

    for(int i = 1; i < vec.size() - 1 ; i ++ ) {
        sum -= vec[i - 1];
        sum += vec[i + 1];
        if(max > abs(sum)) {
            a = i;
            b = i + 1;
            max = abs(sum);
        }
    }

    vector<long> result;
    result.push_back(vec[a]);
    result.push_back(vec[b]);
    sort(result.begin(), result.end());

    cout << result[0] << ' ' << result[1];

    return 0;
}