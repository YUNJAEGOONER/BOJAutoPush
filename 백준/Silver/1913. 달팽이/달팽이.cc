#include<iostream>
using namespace std;
#include<vector>

int main(){

    int s;
    cin >> s;
    int find;
    cin >> find;
    
    vector<vector<int>> myvec;
    for(int i = 0 ; i < s ; i++) {
        vector<int> vec;
        for(int j = 0 ; j < s ; j++) {
            vec.push_back(0);
        }
        myvec.push_back(vec);
    }

    int num = s * s;
    int i = 0, j = 0;
    int direction = 0;
    while(num != 0) {
        //down
        if(direction % 4 == 0) {
            if(myvec[i][j] == 0) {
                myvec[i][j] = num--;
                i ++;
            }
            if(i > s - 1 || myvec[i][j] != 0) {
                direction++;
                i --;
                j ++;
            }
        }
        else if(direction % 4 == 1) {
            if(myvec[i][j] == 0) {
                myvec[i][j] = num--;
                j ++;
            }
            if(j > s - 1 || myvec[i][j] != 0) {
                direction++;
                j --;
                i --;
            }
        }
        else if(direction % 4 == 2) {
            if(myvec[i][j] == 0) {
                myvec[i][j] = num--;
                i --;
            }
            if(i < 0 || myvec[i][j] != 0) {
                direction++;
                i ++;
                j --;
            }
        }
        else {
            if(myvec[i][j] == 0) {
                myvec[i][j] = num--;
                j --;
            }
            if(j < 0 || myvec[i][j] != 0) {
                direction++;
                j ++;
                i ++;
            }
        }
    }

    for(int i = 0 ; i < s ; i++) {
        for(int j = 0 ; j < s ; j++) {
            cout << myvec[i][j] << " ";
        }
        cout << endl;
    }
    

    for(int i = 0 ; i < s ; i ++ ) {
        for(int j = 0 ; j < s ; j++) {
            if(myvec[i][j] == find) {
                cout << i + 1 << ' ' << j + 1 << endl;
            }
        }
    }
    return 0;
}