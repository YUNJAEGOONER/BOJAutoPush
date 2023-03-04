#include <iostream>
#include <vector>
using namespace std;

int N;
int M;

vector<vector<int>> btvec;

void BT(vector<int> vec, vector<int> check){
    if(vec.size() == M){
        btvec.push_back(vec);
        return;
    }
    for(int i = 1 ; i < N + 1; i ++ ) {
        if (check[i] != 1) {
            check[i] = 1;
            vec.push_back(i);
            BT(vec, check);
            //return문 이후 실행되는 명령문 -> 마지막에 추가된 원소 삭제
            check[i] = 0;
            vec.erase(vec.end()-1);
        }
    }
}

int main(){
    cin >> N >> M;
    vector<int> vec;
    vector<int> check(N+1);
    BT(vec, check);

    for(auto a: btvec){
        for(auto b : a){
            cout << b << " ";
        }
        cout << '\n';
    }
    return 0;
}