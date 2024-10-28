#include<iostream>
#include<vector>
#include<cmath>
using namespace std;

int main(){
	int test;
    cin >> test;
    for(int i = 0 ; i < test ; i ++){
     	float answer = 0;
        vector<int> myvec;
        for(int j = 0 ; j < 10 ; j ++){
        	int e;
            cin >> e;
            answer = answer + e ;
        }
        cout << '#' << i + 1 << ' ' << round(answer/10) << '\n' ;
    }
}