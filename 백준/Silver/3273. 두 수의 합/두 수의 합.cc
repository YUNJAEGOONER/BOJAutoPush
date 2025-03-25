//
// Created by Yunjae on 2025-03-25.
//
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> vec;

    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }
    sort(vec.begin(), vec.end());

    int target;
    cin >> target;

    int answer = 0 ;

    int start = 0;
    int end = n - 1;
    while(start < end) {
        int sum = vec[start] + vec[end];
        if(sum == target) {
            answer ++;
            start ++;
        }
        else if(sum > target) {
            end --;
        }
        else {
            start ++;
        }
    }

    cout << answer;
    
    return 0;
}