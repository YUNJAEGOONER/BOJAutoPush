#include <string>
#include <vector>
#include <iostream>

using namespace std;


string convert(int num, int n){
    string result = "";
    if(num == 0){
        result += '0';
    }
    else{
        while(num != 0){
            if(num % n >= 10){
                result += (char)('A' + (num % n) - 10);
            }
            else{
                result += (char)('0' + (num % n));
            }
            num /= n;
        }   
    }
    return result;
}


string solution(int n, int t, int m, int p) {
    string answer = "";
    
    vector<vector<char>> result(m);
    
    int cur = 0;
    int num = 0;
    
    while(result[p-1].size() < t + 1){
        string mstr = convert(num, n);
        //cout << num << " : " << mstr << '\n';
        for(int i = mstr.size() - 1 ; i > -1 ; i -- ){
            result[cur].push_back(mstr[i]);
            cur = cur + 1;
            cur %= m;
        }
        num += 1;
    }
    
    int i = 0;
    while(t--){
        answer += result[p - 1][i++];
    }
    
    return answer;
}