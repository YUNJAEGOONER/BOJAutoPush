#include<iostream>
#include<vector>
using namespace std;

int main(){
    int test = 10;
    while(test--){
    	int N;
        cin >> N;
        vector<int> buildings;
        while(N--){
        	int e;
            cin >> e;
            buildings.push_back(e);
        }
        
        int count = 0;
        
        for(int i = 0 ; i < buildings.size() ; i ++ ){
        	int current = buildings[i];
            int max = 0;
            for(int j = i - 2 ; j <= i + 2 ; j ++){
                if( 0 <= j && j <= buildings.size() -1 && j != i){
                	if(max < buildings[j]){
                    	max = buildings[j];
                    }
                }
            }
            if(max < current){
            	count = count + (current - max);
            }
        }
        cout << '#' << (10 - test) << ' ' << count << '\n';
    }
}