#include<iostream>
using namespace std;

int main(){
	int test;
    cin >> test;
    for(int i = 0 ; i < test ; i ++){
    	int a, b;
        cin >> a >> b;
        char result;
        if(a == b){
        	result = '=';
        }
        else if (a > b){
        	result = '>';
        }
        else{
        	result = '<';
        }
        
        cout << '#' << i + 1 << ' '<< result << '\n';
    }
}