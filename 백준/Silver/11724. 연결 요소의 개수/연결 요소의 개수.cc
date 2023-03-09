#include <iostream>
#include <vector>
using namespace std;

int main(){

    int N, M;
    cin >> N >> M;

    vector<int> myqueue;
    int component = 0;
    int bfs_visit[N+1];
    int adjm[N+1][N+1];

    for(int i = 0 ; i  < N + 1 ; i ++){
        for(int j = 0 ; j < N + 1 ;  j ++ ){
            adjm[i][j] = 0;
        }
        bfs_visit[i] = 0;
    }

    while(M--){
        int node_a, node_b;
        cin >> node_a >> node_b;
        adjm[node_a][node_b] = 1;
        adjm[node_b][node_a] = 1;
    }
    
    for(int i = 1 ; i < N + 1; i ++ ){
        if (bfs_visit[i] == 0){
            component++;
            bfs_visit[i] = 1;
            myqueue.push_back(i);
            while(!myqueue.empty()){
                int cur_node = *(myqueue.begin());
                myqueue.erase(myqueue.begin());
                for(int j = 1; j < N + 1; j ++ ){
                    if(adjm[cur_node][j] == 1 and bfs_visit[j] == 0){
                        bfs_visit[j] = 1;
                        myqueue.push_back(j);
                    }
                }
            }
        }
    }

    cout << component;
}