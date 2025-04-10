//
// Created bYunjae on 2025-04-10.
//
#include <iostream>
#include <map>
#include <vector>
#include <set>
using namespace std;

int main() {
    int n;
    cin >> n;

    map<int, int> mmap;
    for(int i = 1; i < n + 1 ; i ++ ) {
        int e;
        cin >> e;
        mmap[i] = e;
    }

    set<int> answer;

    for(int i = 1; i < n + 1 ; i ++ ) {

        vector<int> visited(n + 1, 1);
        int cur = i;

        set <int> A;
        set <int> B;

        while(true) {
            if(visited[cur] == 0) {
                break;
            }
            visited[cur] = 0;
            A.insert(cur);
            B.insert(mmap[cur]);
            cur = mmap[cur];
        }

        if(A == B) {
            for(auto a : A) {
                answer.insert(a);
            }
        }

    }

    cout << answer.size() << '\n';
    for(auto e : answer) cout << e << '\n';

    return 0;
}