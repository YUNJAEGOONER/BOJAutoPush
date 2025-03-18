#include <string>
#include <map>
#include <iostream>

using namespace std;

int solution(string str1, string str2) {
    int answer = 0;
    
    for(int i = 0 ; i < str1.size() ; i ++){
        if('A' <= str1[i] && str1[i] <= 'Z'){
            str1[i] = (str1[i] + 32);
        }
    }
    
    for(int i = 0 ; i < str2.size() ; i ++){
        if('A' <= str2[i] && str2[i] <= 'Z'){
            str2[i] = (str2[i] + 32);
        }
    }
    
    map<string, int> map1;
    for(int i = 0 ; i < str1.size() - 1 ; i ++ ){
        string temp = "";
        if(('a'<= str1[i] && str1[i] <= 'z') && ('a' <= str1[i + 1] && str1[i + 1] <= 'z')){
            temp += str1[i];
            temp += str1[i + 1];
            map1[temp] ++;
        }
        
    }
    
    map<string, int> map2;
    for(int i = 0 ; i < str2.size() - 1 ; i ++ ){
        string temp = "";
        if(('a'<= str2[i] && str2[i] <= 'z') && ('a' <= str2[i + 1] && str2[i + 1] <= 'z')){
            temp += str2[i];
            temp += str2[i + 1];
            map2[temp] ++;
        }
    }
    
    //union
    map<string, int> unions;
    
    for(auto a : map1){ 
        unions[a.first] = a.second; 
    }
    
    for(auto b : map2){
        if(unions[b.first] != 0){
            int max = unions[b.first];
            if(max < b.second){
                max = b.second;
            }
            unions[b.first] = max;
        }
        else{
            unions[b.first] = b.second;
        }
    }
    
    //intersect
    map<string, int> inter;
    for(auto a : map1){
        if(map2[a.first] != 0){
            int min = map1[a.first];
            if(min > map2[a.first]){
                min = map2[a.first];
            }
            inter[a.first] = min;
        }
    }
    
    float u = 0;
    for(auto a : unions){
        u += a.second;
    }
    
    float i = 0;
    for(auto b : inter){
        i += b.second;
    }

    //cout << i << "union " << u << ' ';
    
    if(i == 0 && u == 0){
        return 65536;
    }
    answer = (i / u) * 65536;
    
    return answer;
}