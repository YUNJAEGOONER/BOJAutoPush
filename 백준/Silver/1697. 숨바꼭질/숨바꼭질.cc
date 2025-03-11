#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    int answer = 0;

    queue<pair<int, int>> mq; //cur, depth;
    mq.push(make_pair(a, 0));

    vector<int> visited(100001);

    while(!mq.empty()) {
        int cur = mq.front().first;
        int depth = mq.front().second;
        mq.pop();

        if(cur == b) {
            answer = depth;
            break;
        }
        if(cur - 1 >= 0 && visited[cur - 1] == 0) {
            mq.push(make_pair(cur - 1,  depth + 1));
            visited[cur - 1] = 1;
        }
        if(cur + 1 <= 100000 && visited[cur + 1] == 0) {
            mq.push(make_pair(cur + 1, depth + 1));
            visited[cur + 1] = 1;
        }
        if(cur * 2 <= 100000 && visited[cur * 2] == 0) {
            mq.push(make_pair(cur * 2, depth + 1));
            visited[cur * 2] = 1;
        }
    }

    cout << answer;

    return 0;
}