#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    int N;
    cin >> N;
    vector<int> myvec;
    while(N--){
    	int e;
        cin >> e;
        myvec.push_back(e);
    }
    sort(myvec.begin(), myvec.end());
    cout << myvec[myvec.size()/2];
}