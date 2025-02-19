#include <string>
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

bool isprime(string num){
    long long number = stoll(num);
    if(number >= 2){
        for(int i = 2; i < (int)(sqrt(number) + 1) ; i ++){
            if(number % i == 0) return false;
        }
        return true;
    }
    return false;
    
}

int solution(int n, int k) {
    int answer = 0;

    int temp = n;
    
    
    vector<char> convert;
    while(temp != 0){
        convert.push_back((char)((temp % k) + '0'));
        temp = temp / k;
    }
    
    vector<char> num;
    for(int i = convert.size() - 1; i > -1 ; i --){
        num.push_back(convert[i]);
    }
    
    for(auto a : num){
        cout << a << '\n';
    }
    
    string tempnum = "";
  
    for(int i = 0 ; i < num.size() ; i ++ ){
        if(num[i] == '0'){
            if(tempnum.size() > 0){
                if(isprime(tempnum))answer++;
                cout << tempnum << '\n';
                //cout <<isprime(tempnum) << " - - - "<< tempnum << '\n';
            }
            tempnum = "";
        }
        else{
            tempnum = tempnum + num[i];
        }
    }
    
//     cout <<"temp : "<< tempnum << '\n';
//     cout <<"tsize : " << tempnum.size() << '\n';
        
    if(tempnum.size() > 0){
        if(isprime(tempnum))answer++;
    }
       
   
    
    
    return answer;
}