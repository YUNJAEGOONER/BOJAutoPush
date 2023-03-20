#include <iostream>
#include <vector>
using namespace std;
vector<int> visit;
vector<vector<int>>result_vec;

void per_recursive(vector<int> permu){
    if(permu.size() == visit.size()){
        result_vec.push_back(permu);
        return;
    }
    else{
        for(int i = 0 ; i < visit.size(); i ++ ){
            if(visit[i] != 1){
                permu.push_back(i + 1);
                visit[i] = 1;
                per_recursive(permu);
                visit[i] = 0;
                permu.erase(permu.end() - 1);
            }
        }
    }
}

int main(){
    int N;
    cin >> N;

    for(int i = 0 ; i < N ; i ++){
        visit.push_back(0);
    }

    vector<int> basket;
    per_recursive(basket);

    for(auto a : result_vec){
        for(auto b : a){
            cout << b << " ";
        }
        cout << '\n';
    }
}