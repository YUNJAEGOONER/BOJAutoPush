#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<vector<int>> to_int(vector<vector<string>> arr){
    vector<vector<int>> intarr;
    
    for(int i = 0 ; i < arr.size() ; i ++ ){
        
        string stime = "";
        string shour = arr[i][0].substr(0,2);
        string smin = arr[i][0].substr(3,2);
        stime += shour;
        stime += smin;
        cout << stime << ' ';
        
        string etime = "";
        
        int ehour = stoi(arr[i][1].substr(0,2));
        int emin = stoi(arr[i][1].substr(3,2));
        emin += 10;
        
        if(emin >= 60){
            emin = emin - 60;
            ehour += 1;
            if(ehour == 24){
                ehour -= 1;
                emin = (emin + 50);
            }
        }
        
        string strmin = "";
        if(emin < 10){
            strmin += '0';
        }
        strmin += to_string(emin);
    
        etime += to_string(ehour);
        etime += strmin;

        vector<int> row;
        row.push_back(stoi(stime));
        row.push_back(stoi(etime));
        intarr.push_back(row);
    }
    return intarr;
}

bool cmp1(vector<int> v1, vector<int> v2){
    return v1[1] < v2[1];
}

int solution(vector<vector<string>> book_time) {
    int answer = 0;
    
    vector<vector<int>> marr = to_int(book_time);
    sort(marr.begin(), marr.end(), cmp1);
    
    vector<int> rooms;
    rooms.push_back(marr[0][1]);
    
    for(int i = 1 ; i < marr.size() ; i ++){
        int cur = marr[i][0];
        int min = 24 * 60;
        int min_idx = -1;
        sort(rooms.begin(), rooms.end());
        for(int j = 0 ; j < rooms.size() ; j ++ ){
            if(rooms[j] <= cur){
                if(cur - rooms[j] < min){
                    min = cur - rooms[j];
                    min_idx = j;
                }
            }
        }
        if(min_idx == - 1) rooms.push_back(marr[i][1]);
        else rooms[min_idx] = marr[i][1];
       
        cout << '\n';
    }
    answer = rooms.size();
  
    return answer;
}