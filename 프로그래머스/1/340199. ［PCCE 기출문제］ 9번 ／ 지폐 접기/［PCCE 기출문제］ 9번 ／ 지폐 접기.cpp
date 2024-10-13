#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> wallet, vector<int> bill) {
    int answer = 0;
    
    while(true){
        sort(wallet.rbegin(), wallet.rend());
       
        sort(bill.rbegin(), bill.rend());   
       
        if(wallet[0] < bill[0] || wallet[1] < bill[1]){
            bill[0] = bill[0] / 2;
            answer ++;
        }
        else if(wallet[0] >= bill[0] && wallet[1] >= bill[1]){
            break;
        }
        
       
    }
    
    return answer;
}