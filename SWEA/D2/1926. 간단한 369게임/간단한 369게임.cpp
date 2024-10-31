#include<iostream>
#include<string>
using namespace std;

int check(int num){
    int answer = 0;
    string str= to_string(num);
    for(int i = 0 ; i < str.size(); i ++){
    	if(str[i] == '3' || str[i] == '6' || str[i] == '9') answer ++;
    }
    return answer;
}

int main(){
	int n;
    cin >> n;
    for(int i = 1 ; i < n + 1; i ++ ){
    	int result = check(i);
        if(result){
        	for(int j = 0 ; j < result ; j ++ ) cout << '-';
        }
        else{
        	cout << i;
        }
        cout<<' ';
    }
}