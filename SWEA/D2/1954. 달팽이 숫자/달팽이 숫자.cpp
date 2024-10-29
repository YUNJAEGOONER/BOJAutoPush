#include<iostream>
using namespace std;
#include<vector>

int main(){

    int test;
    cin >> test;

    for(int t = 0 ; t < test ; t++) {
        int N;
        cin >> N;
        vector<vector<int>> snail;
        for(int i = 0 ; i < N ; i ++){
            vector<int> element;
            for(int j = 0 ; j < N ; j ++){
                element.push_back(0);
            }
            snail.push_back(element);
        }

        int i = 0;
        int j = 0;

        int direction = 0;
        int num = 0;

        while(num != N * N){
            //right
            if(direction % 4 == 0){
                if(snail[i][j] == 0){
                    snail[i][j] = ++num;
                    j = j + 1;
                }
                if(j >= N || snail[i][j] != 0){
                    direction ++;
                    i = i + 1;
                    j = j - 1;
                }
            }
            //down
            else if (direction % 4 == 1){
                if(snail[i][j] == 0){
                    snail[i][j] = ++num;
                    i ++ ;
                }
                if(i >= N || snail[i][j] != 0){
                    direction ++;
                    j = j - 1;
                    i = i - 1;
                }
            }
            //left
            else if (direction % 4 == 2){
                if(snail[i][j] == 0){
                    snail[i][j--] = ++num;
                }
                if(j < 0 || snail[i][j] != 0){
                    direction ++;
                    i = i - 1;
                    j = j + 1;
                }
            }
            //top
            else{
                if(snail[i][j] == 0){
                    snail[i--][j] = ++num;
                }
                if(i < 0 || snail[i][j] != 0){
                    direction ++;
                    i = i + 1;
                    j = j + 1;
                }
            }
        }
        cout << '#' << t + 1 << '\n';
        for(auto e : snail) {
            for(auto v : e) {
                cout << v << " ";
            }
            cout << '\n';
        }
    }

    return 0;
}