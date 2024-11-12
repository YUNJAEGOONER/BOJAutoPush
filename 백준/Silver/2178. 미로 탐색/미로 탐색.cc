#include<iostream>
#include<vector>
using namespace std;

int main() {
    int n,m;
    cin >> n >> m;


    vector<vector<int>> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        string s;
        cin >> s;
        vector<int> row;
        for(int j = 0 ; j < s.length() ; j ++ ) {
            row.push_back(s[j] - '0');
        }
        vec.push_back(row);
    }

    //좌표, 거리
    vector<pair<pair<int, int>, int>> myqueue;

    myqueue.push_back(make_pair(make_pair(0, 0), 1));

    while(!vec.empty()) {
        int dis = myqueue.front().second;
        int cur_i = myqueue.front().first.first;
        int cur_j = myqueue.front().first.second;
        vec[cur_i][cur_j] = 0;
        myqueue.erase(myqueue.begin());

        if(cur_i == n - 1 && cur_j == m - 1) {
            cout << dis;
            break;
        }
        //top
        if(cur_i - 1 >=0 && vec[cur_i - 1][cur_j]) {
            myqueue.push_back(make_pair(make_pair(cur_i - 1, cur_j), dis + 1));
            vec[cur_i - 1][cur_j] = 0;
        }
        if(cur_i + 1 < n && vec[cur_i + 1][cur_j]) {
            myqueue.push_back(make_pair(make_pair(cur_i + 1, cur_j), dis + 1));
            vec[cur_i + 1][cur_j] = 0;
        }
        //right
        if(cur_j + 1 < m && vec[cur_i][cur_j + 1]) {
            myqueue.push_back(make_pair(make_pair(cur_i, cur_j + 1), dis + 1));
            vec[cur_i][cur_j + 1] = 0;
        }
        if(cur_j - 1 >=0 && vec[cur_i][cur_j - 1]) {
            myqueue.push_back(make_pair(make_pair(cur_i, cur_j - 1), dis + 1));
            vec[cur_i][cur_j - 1] = 0;
        }

    }
    return 0;
}