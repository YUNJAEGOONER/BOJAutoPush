#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> myvec;
    vector<int> memo;

    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        myvec.push_back(e);
        memo.push_back(1);
    }


    int answer = 1;

    for(int i = 1 ; i < n ; i ++ ) {
        int max_idx = -1;
        int max_val = -1;
        for(int j = 0 ; j < i ; j ++ ){
            if(myvec[j] < myvec[i]) {
                if(max_val < memo[j]) {
                    max_val = memo[j];
                    max_idx = j;
                }
            }
        }
        if(max_idx != -1) {
            memo[i] = max_val + 1;
            if(answer < memo[i]) answer = memo[i];
        }
    }
    cout << answer;
    // for(auto a : memo) cout << a << ' ';
    return 0;
}