#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

map<int, int> servers; //id, 시간;

int get_size(){
    int cnt = 0;
    for(int i = 0 ; i < servers.size() ; i ++ ){
        if(servers[i] != 0){
            cnt ++;
        }
    }
    return cnt;
}

void time_spend(){
    for(int i = 1; i < servers.size() ; i ++ ){
        if(servers[i] > 0){
            servers[i]--;
        }
    }
}

void add_server(int n, int k){
    int id = servers.size();
    for(int i = id ; i < id + n ; i ++ ){
        servers[i] = k;
    }
}

int solution(vector<int> players, int m, int k) {
    int answer = 0;
    
    servers[0] = k; 
    
    for(int i = 0 ; i < players.size() ; i ++ ){
        int n = get_size();
        if((n * m - 1) < players[i]){
            //서버증설
            int add = ((players[i] - (n * m)) / m) + 1;
            answer += add;
            add_server(add, k);
        }
        //1시간씩 차감
        time_spend();
    }
    
    return answer;
}