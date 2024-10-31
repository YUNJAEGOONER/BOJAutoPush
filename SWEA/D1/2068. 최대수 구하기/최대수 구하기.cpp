#include<iostream>
using namespace std;

int main(){
    int test;
    cin >> test;
    for(int i = 0 ; i < test ; i ++ ){
        int max = -1;
        for(int j = 0 ; j < 10 ; j ++){
        	int e;
            cin >> e;
            if(e > max) max = e;
        }
         
    	cout << '#' << i + 1 << ' '  << max << '\n';
    }
}