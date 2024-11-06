#include<iostream>

using namespace std;

int main(){
	int test;
    cin >> test;
    int answer = 0;
    
    for(int i = 0 ; i < test ; i ++ ){
    	string str;
        cin >> str;
      	
        for(int j = 1 ; j < 11 ; j ++){
            int tf = 1;
            for(int k = 0 ; k < j ; k ++){
                if(str[k] != str[k + j]){
                    tf = 0;
                }
            } 
            if(tf){
            	answer = j;
                cout << '#' << i + 1 << ' ' << answer <<'\n';
                break;
            }
        }
    }	
}