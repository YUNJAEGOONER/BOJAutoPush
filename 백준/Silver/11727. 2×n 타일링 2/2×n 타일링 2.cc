#include<iostream>
#include<vector>
using namespace std;

vector<int> vec;

int dp2(int n){
    if(n == 1 || n == 0) return vec[n] = 1;
    if(vec[n] != 0) return vec[n];
    return vec[n] = (dp2(n - 1) + 2 * dp2(n - 2)) % 10007 ;
}

int main(){
    int n;
    cin >> n;
    for(int i = 0 ; i < n + 1 ; i ++ ) vec.push_back(0);
    cout << dp2(n);
}