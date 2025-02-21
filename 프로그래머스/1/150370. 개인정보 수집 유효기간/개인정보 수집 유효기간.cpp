#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <string>

using namespace std;

string to_str(string str){
    string mstr = "";
    for(int i = 0 ; i < str.size() ; i ++ ){
        if(str[i] != '.'){
            mstr += str[i];
        }
    }
    return mstr;
}

string ntos(int n){
    string rstr = "";  
    if(n < 10){
        rstr += '0';
    }
    rstr += to_string(n);
    return rstr;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    string t = to_str(today);
    
    cout << t << '\n';
    
//     today = "2009.12.28";
//     terms ={"A 13"};
//     privacies ={"2008.11.03 A"};
    
    
    map<char, int> tmap; //약관종류, 유효기간
    for(int i = 0 ; i < terms.size() ; i ++ ){
        char level = terms[i][0];
        int duration = stoi(terms[i].substr(2));
        tmap[level] = duration;
    }
    
    for(int i = 0 ; i < privacies.size() ; i ++ ){
        string temp = to_str(privacies[i].substr(0, 10));
        //cout << temp << ' ';
        
        //get_terms
        int td = tmap[privacies[i][11]];
        //cout << td << ' ';
        
        //month & year
        int day = stoi(temp.substr(6,2));
        int month = stoi(temp.substr(4,2));
        int year = stoi(temp.substr(0,4));
        
        day = day - 1;
        
        if(day == 0){
            day = 28;
            month = month - 1;
            if(month == 0){
                month = 12;
                year = year - 1;
            }
        }
        
        month = month + td;
        while(month > 12){
            month -=12;
            year ++;
        }
        
        string result = "";
        
        string syear = to_string(year);
        string smonth = ntos(month);
        string sday = ntos(day);
        
        result += syear;
        result += smonth;
        result += sday;
        
        if(t > result){
            answer.push_back(i + 1);
        }
        // cout << result << '\n';
        
    }
    
    return answer;
}