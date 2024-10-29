#include<iostream>
#include<vector>
using namespace std;

int main(){
	int N;
    cin >> N;

    for(int itr = 0 ; itr < N ; itr ++){
      
    	int n, m;
        cin >> n >> m;
        vector<vector<int>>myvec;
        
        for(int i = 0 ; i < n ; i ++ ){
        	vector<int> element;
            for(int j = 0 ; j < n ; j ++ ){
            	int e;
                cin >> e;
                element.push_back(e);
            }
            myvec.push_back(element);
        }
        
        int answer = 0;
        int max = 0;
        
        for(int i = 0 ; i < n - m + 1 ; i ++){
            for(int j = 0; j < n - m + 1 ; j ++){
                answer = 0;
                for(int k = i ; k < i + m ; k ++){
                    for(int l = j ; l < j + m ; l ++){
                    	answer = answer + myvec[k][l];
                    }
            	}
                if(max < answer){
                	max = answer;
                }
            }
        } 
        cout << '#' << itr + 1 << ' ' << max <<'\n' ;
    }
}