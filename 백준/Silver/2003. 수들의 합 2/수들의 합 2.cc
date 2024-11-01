#include<iostream>
#include<vector>
using namespace std;

int main(){
    int n;
    int result;
    cin >> n >> result;
    
    vector<int> nums;
    for(int i = 0 ; i < n ; i ++ ){
        int e;
        cin >> e;
        nums.push_back(e);
    }
    
    int count = 0;
    
    for(int i = 0 ; i < n ; i ++ ){
        int sum = 0;
        for(int j = i ; j < n ; j ++ ){
            sum = sum + nums[j];
            if(sum == result){
                count ++ ;
            }
            else if(sum > result){
                break;
            }
        }
    }
    
    cout << count;
}
