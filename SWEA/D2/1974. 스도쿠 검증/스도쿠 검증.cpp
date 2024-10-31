#include<iostream>
#include<vector>
#include<set>
using namespace std;

int main(){
    int test;
    cin >> test;
    
    for(int t = 0 ; t < test ; t ++){
		int result = 1;
        vector<vector<int>>myvec;
        
        for(int i = 0 ; i < 9 ; i ++){
           vector<int> element;
        	for(int j = 0 ; j < 9 ; j ++){
            	int num;
                cin >> num;
                element.push_back(num);
            }
            myvec.push_back(element);
        }
        
        for(int i = 0 ; i < 9 ; i ++ ){
        	set<int> row;
            for(int j = 0 ; j < 9 ; j ++){
            	row.insert(myvec[i][j]);
            }
            if(row.size() != 9){
            	result = 0;
                break;
            }
        }
        
        
        
        
        if(result){
            for(int j = 0 ; j < 9; j ++){
                set<int> column;
            	for(int i = 0 ; i < 9 ; i ++){
                    column.insert(myvec[i][j]);
            	}
            	if(column.size() != 9){
            		result = 0;
                    break;                	
            	}
        	}
        }
        
        if(result){
            for(int i = 0 ; i < 9 ; i = i + 3){
            	for(int j = 0 ; j < 9 ; j = j + 3){
               		set<int> sq;
                    for(int k = i ; k < i + 3 ; k ++){
                    	for(int l = j ; l < j + 3 ; l++){
                        	sq.insert(myvec[k][l]);
                        }
                    }
                    if(sq.size() != 9){
                    	result = 0;
                        break;
                    }
                }
            }
        }
        
    	cout << '#' << t + 1 << ' ' << result << '\n';
    }
    return 0;
}