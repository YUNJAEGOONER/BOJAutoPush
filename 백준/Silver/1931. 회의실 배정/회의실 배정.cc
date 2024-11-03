#include <iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(0);

    vector<pair<int, int>>v;
    int N;
    cin >> N;
    while(N --) {
        int a, b;
        cin >> a >> b;
        v.push_back(make_pair(b, a));
    }
    sort(v.begin(), v.end());

    int answer = 0;
    int end = v[0].first;
    answer ++;

    for(int i = 1; i < v.size(); i++) {
        if(end <= v[i].second) {
            answer ++ ;
            end = v[i].first;
        }
    }
    cout << answer;
    return 0;
}