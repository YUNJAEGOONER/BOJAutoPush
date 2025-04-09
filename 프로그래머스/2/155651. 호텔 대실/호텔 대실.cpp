#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<vector<int>> toInteger(vector<vector<string>> vec){
    vector<vector<int>> rvec(vec.size()); 
    for(int i = 0 ; i < vec.size() ; i ++){
        string start = "";
        string h1 = vec[i][0].substr(0, 2);
        string m1 = vec[i][0].substr(3, 2);
        start += h1;
        start += m1;
             
        string end = "";
        int h2 = stoi(vec[i][1].substr(0, 2));
        int m2 = stoi(vec[i][1].substr(3, 2));
        
        //청소 시간
        m2 += 9; 
        if(m2 >= 60){
            m2 -= 60;
            h2 += 1;
        }
        
        if(h2 < 10) end += ("0" + to_string(h2));
        else end += to_string(h2);
        
        if(m2 < 10) end += ("0" + to_string(m2));
        else end += to_string(m2);
        
        rvec[i].push_back(stoi(start));
        rvec[i].push_back(stoi(end));
    }
    return rvec;
}

bool cmp(vector<int> a, vector<int> b){
   if (a[0] == b[0]) return a[1] > b[1];

    return a[0] < b[0];
}

int solution(vector<vector<string>> book_time) {
    
    vector<vector<int>> vec = toInteger(book_time);
    sort(vec.begin(), vec.end(), cmp);
    
    vector<int> rooms;
    rooms.push_back(vec[0][1]);
    
    for(int i = 1 ; i < vec.size() ; i ++){
        bool addnew = true;
        for(int j = 0 ; j < rooms.size() ; j ++ ){
            if(rooms[j] < vec[i][0]){
                rooms[j] = vec[i][1];
                addnew = false;
                break;
            }
        }
        if(addnew) rooms.push_back(vec[i][1]);
        
    }
    
    return rooms.size();

}