#include <iostream>
#include <vector>
using namespace std;

int main() {
    int test;
    cin >> test;
    for(int t = 0 ; t < test; t++ ) {
        int n;
        cin >> n;

        vector<vector<int>> vec(n);

        for(int i = 0 ; i < n ; i ++ ) {
            string rows;
            cin >> rows;
            for(int j = 0 ; j < rows.size() ; j ++ ) {
                vec[i].push_back(rows[j] - '0');
            }
        }

        int answer =  0;
        for(int i = 0 ; i < n ; i ++ ) {
            if(i <= n / 2) {
                for(int j = 0 ; j < n ; j ++ ) {
                    if( n / 2 - i <= j && j <= n / 2 + i) {
                        answer = answer + vec[i][j];
                    }
                }
            }
            else {
                for(int j = 0 ; j < n ; j ++ ) {
                    if(i - n / 2 <= j && j < n -(i - n/2)) {
                        answer = answer + vec[i][j];
                    }
                }
            }
        }
        cout << "#" << t + 1 << " " << answer << endl;
    }


    return 0;
}