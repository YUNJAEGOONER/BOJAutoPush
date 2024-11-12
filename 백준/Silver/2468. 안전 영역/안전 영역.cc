#include <iostream>
#include <vector>
#include <set>
using namespace std;

int main() {
    int n;
    cin >> n;
    vector<vector<int>> vec;
    set<int> s;

    int result = 0;

    for(int i = 0 ; i < n ; i ++ ) {
        vector<int> row;
        for(int j = 0 ; j < n ; j ++ ) {
            int e;
            cin >> e;
            row.push_back(e);
            s.insert(e);
        }
        vec.push_back(row);
    }
    s.insert(0);

    for(auto e : s) {
        for(int i = 0 ; i < n ; i ++ ) {
            for(int j = 0 ; j < n ; j ++ ) {
                if(vec[i][j] <= e) vec[i][j] = 0;
            }
        }
        vector<vector<int>> temp;
        temp = vec;

        vector<pair<int,int>> stack;

        int answer = 0;
        for(int i = 0 ; i < n ; i ++ ) {
            for(int j = 0 ; j < n ; j ++ ) {
                if(temp[i][j]) {
                    stack.push_back(make_pair(i,j));
                    answer ++;
                    while(!stack.empty()) {
                        int i = stack.back().first;
                        int j = stack.back().second;
                        stack.pop_back();
                        //top
                        if(i - 1 >= 0 && temp[i-1][j]) {
                            temp[i - 1][j] = 0;
                            stack.push_back(make_pair(i - 1,j));
                        }
                        if(i + 1 < n && temp[i + 1][j]) {
                            temp[i + 1][j] = 0;
                            stack.push_back(make_pair(i + 1,j));
                        }
                        //left
                        if(j - 1 >= 0 && temp[i][j - 1]) {
                            temp[i][j - 1] = 0;
                            stack.push_back(make_pair(i,j - 1));
                        }
                        if(j + 1 < n && temp[i][j + 1]) {
                            temp[i][j + 1] = 0;
                            stack.push_back(make_pair(i ,j + 1));
                        }
                    }
                }
            }
        }
        if(result <= answer) result = answer;
    }

    cout << result;
    return 0;
}