#include <string>
#include <vector>
#include <iostream>
#include <map>


using namespace std;
//pair<string, string>

vector<string> get_info(string str){
    vector<string> result;
    
    vector<string> info;
    string temp = "";
    for(int i = 0 ; i < str.size(); i ++){
        if(str[i] == ','){
            info.push_back(temp);
            temp = "";
        }
        else{
            temp += str[i];
        }
    }
    info.push_back(temp);
    
    int play = 0;
    
    int endmin = stoi(info[1].substr(3,2));
    int startmin = stoi(info[0].substr(3,2));
    play += (endmin - startmin);
    
    int endhr = stoi(info[1].substr(0,2));
    int starthr = stoi(info[0].substr(0,2));
    play += (60 * (endhr - starthr));
    
    
    map<int, string> music;
    int idx = 0;
    info[3].push_back('@');
    for(int i = 0 ; i < info[3].size() -1 ; i ++ ){
        string temp = "";
        if(info[3][i + 1] == '#'){
            temp += info[3][i];
            temp += info[3][i + 1];
            i ++ ;
        }
        else{
            temp += info[3][i];
        }
        music[idx] = temp;
        idx ++;
    }
    
    
    string tempstr = "";
    for(int i = 0 ; i < play ; i ++ ){
        tempstr += music[i % music.size()];
    }
    
    //cout << play << ' ' << tempstr << '\n';
    result.push_back(info[2]);
    result.push_back(tempstr);
    result.push_back(to_string(play));
    
    cout << play << ' ';
    
    cout << tempstr << '\n';
    
    return result;
    
}

int mmax = -1;
string solution(string m, vector<string> musicinfos) {
    string answer = "(None)";
    for(int i = 0 ; i < musicinfos.size() ; i ++ ){
        vector<string> res = get_info(musicinfos[i]);
        string title = res[0];
        string music = res[1];
        int playtime = stoi(res[2]);
        
        for(int j = 0 ; j < music.size() ; j ++ ){
            int idx = 0;
            int jdx = j;
            if(music[j] == m[idx]){
                while(music[jdx] == m[idx]){
                    jdx ++;
                    idx ++;
                    if(jdx >= music.size() || idx >= m.size()){
                        break;
                    }
                }
                if(idx == m.size() && (jdx == music.size() || music[jdx] != '#')){
                    if(mmax < playtime){
                        mmax = playtime;
                        answer = title;
                    }
                }
            }
        }
    }
    
  
    
    
    return answer;
}