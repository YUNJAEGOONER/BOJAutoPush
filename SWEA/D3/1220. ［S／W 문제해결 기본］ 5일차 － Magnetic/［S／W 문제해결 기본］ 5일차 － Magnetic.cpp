#include<iostream>
#include<vector>
using namespace std;

int main(){
	for(int t = 0 ; t < 10 ; t++){
        int N;
        cin >> N;
        vector<vector<int>>vec;
        int count = 0;
        
        for(int i = 0 ; i < N ; i ++){
        	vector<int> row;
            for(int j = 0 ; j < N ; j ++){
                int e;
                cin >> e;
                row.push_back(e);
            }
            vec.push_back(row);
        }
        
        for(int j = 0 ; j < N ; j ++){
        	for(int i = 0 ; i < N ; i ++){
                if(vec[i][j]==1){
                	for(int k = i + 1 ; k < N; k ++){
                    	if(vec[k][j] == 2){
                            count++;
                            i = k;
                            break;
                        }
                    }
                }
            }
        }
        
    	cout << "#" << t + 1 << ' ' << count << '\n' ;
    }
}