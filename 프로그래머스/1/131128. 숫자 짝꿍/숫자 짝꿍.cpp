#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

string solution(string X, string Y) {
    string answer = "";

    map<char, int> Xmap;
    for(int i = 0 ; i < X.size() ; i ++ ){
        Xmap[X[i]] ++;
    }
    
    map<char, int> Ymap;
    for(int i = 0 ; i < Y.size() ; i ++ ){
        Ymap[Y[i]] ++;
    }
    
    //vector <char> mvec;
    for(int i = '9' ; i > '0' - 1 ; i -- ){
        int rt = 0;
        if(Xmap[i] > Ymap[i]){
            rt = Ymap[i];
        }
        else{
            rt = Xmap[i];
        }
        for(int j = 0 ; j < rt ; j ++ ){
            answer += (char)i;
        }
    }
    
    if(answer == ""){
        answer = "-1";
    }
    if(answer[0] == '0'){
        answer = "0";
    }
    
    return answer;
}