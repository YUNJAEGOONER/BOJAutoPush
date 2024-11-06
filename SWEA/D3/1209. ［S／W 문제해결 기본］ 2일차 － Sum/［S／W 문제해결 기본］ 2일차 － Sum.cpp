#include<iostream>
#include<vector>
using namespace std;

int main(){

    
    for(int t = 0 ; t < 10; t ++){
        
        int test;
        cin >> test;
        
    	vector<vector<int>> whole;
        
        long long max = -1;
        long long  diag = 0;
        long long sum = 0;
        
        for(int i = 0 ; i < 100 ; i ++){
            vector<int> row;
           	sum = 0;
            for(int j = 0 ; j < 100 ; j ++){
                int e;
                cin >> e;
                row.push_back(e);
                sum = sum + e;
            }
            whole.push_back(row);
            diag = diag + whole[i][i];
            if(max <= sum) max = sum;
        }
        
       if(diag >= max) max = diag;
       diag = 0;
        
        for(int j = 0 ; j < 100 ; j ++){
            sum = 0;
            for(int i = 0 ; i < 100 ; i ++){
                sum = sum + whole[i][j];
            }
            if(sum >= max) max = sum;
            diag = diag + whole[99 - j][j];
        }
        
       if(diag >= max) max = diag;
        
    	cout << "#" << test << " " << max << '\n';
    }
}