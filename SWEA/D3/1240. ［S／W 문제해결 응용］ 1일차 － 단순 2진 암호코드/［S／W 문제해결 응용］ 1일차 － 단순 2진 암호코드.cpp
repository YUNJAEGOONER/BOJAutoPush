#include<iostream>
#include<vector>
#include<map>
using namespace std;

int main(){
    
    int t;
    cin >> t;
    
    map<string, int> decode;
    decode["1101000"] = 9;
    decode["1110110"] = 8;
    decode["1101110"] = 7;
     decode["1111010"] = 6;
     decode["1000110"] = 5;
     decode["1100010"] = 4;
     decode["1011110"] = 3;
     decode["1100100"] = 2;
     decode["1001100"] = 1;
     decode["1011000"] = 0;
    
    for(int i = 0 ; i < t ; i ++){
        int flag = 1;
        int answer = 0;
        int n,m;
    	cin >> n  >> m;
        
        for(int j = 0 ; j  < n ; j ++ ){
            string row;
        	cin >> row;
            
            int sum = 0;
            int last_idx = -1;
            for(int k = 0 ; k < row.size() ; k ++){
                sum = sum + (row[k] - '0');
                if(row[k] =='1') last_idx = k;
            }
            vector<string> password;
            
            if(sum && flag){
               int count = 0;
               vector<char> temp;
               for(int k = last_idx ; k > last_idx - 56 ; k --){
                   temp.push_back(row[k]);
                   count ++;
                   if(count % 7 == 0){             
                      //password.push_back(string(temp.rbegin(), temp.rend());
                       string mystr = string(temp.begin(), temp.end());
                      password.push_back(mystr);
					  temp.clear();
                 	}
               }
                int decode_sum = 0;
                int sum_num = 0;
                for(int i = 0 ; i < password.size() ; i ++){
                    int current = decode[password[i]];           
                    if(i % 2) decode_sum = decode_sum + (3 * current);
                    else decode_sum = decode_sum + current;
                    sum_num = sum_num + current;
                }            
                if(decode_sum % 10 == 0) answer = sum_num;
                flag = 0;
            }
        }
	cout << '#' << i + 1<< ' ' << answer << '\n';
    }
}