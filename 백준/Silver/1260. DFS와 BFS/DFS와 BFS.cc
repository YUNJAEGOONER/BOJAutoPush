#include <iostream>
#include <vector>
using namespace std;

int adjm[1001][1001];

vector<int> my_stack;
vector<int> dfs_result;
int check_dfs[1001] = {0,};

vector<int> my_queue;
vector<int> bfs_result;
int check_bfs[1001] = {0,};
int node;

void dfs(){
    while(!my_stack.empty()){
        for(int i = 1 ; i < node + 1 ; i ++ ){
            if(adjm[*(my_stack.end()-1)][i] == 1 and check_dfs[i] == 0){
                check_dfs[i] = 1;
                my_stack.push_back(i);
                dfs_result.push_back(i);
                i = 0;
            }
        }
        my_stack.erase(my_stack.end()-1);
    }
}

void bfs(){
    while(!my_queue.empty()){
        bfs_result.push_back(*(my_queue.begin()));
        for(int i = 1 ; i < node+1; i ++){
            if(adjm[*(my_queue.begin())][i] == 1 and check_bfs[i] == 0){
                check_bfs[i] = 1;
                my_queue.push_back(i);
            }
        }
        my_queue.erase(my_queue.begin());
    }
}


int main(){
    int N,M,V;
    cin >> N >> M >> V;

    node = N;

    while(M--){
        int node_a, node_b;
        cin >> node_a >> node_b;
        adjm[node_a][node_b] = 1;
        adjm[node_b][node_a] = 1;
    }

    //start_node_dfs
    check_dfs[V] = 1;
    dfs_result.push_back(V);
    my_stack.push_back(V);
    dfs();

    //start_node_bfs;
    check_bfs[V] = 1;
    bfs_result.push_back(V);
    for(int i = 1 ; i < node + 1; i ++ ){
        if(adjm[V][i] == 1 && check_bfs[i] == 0){
            check_bfs[i] = 1;
            my_queue.push_back(i);
        }
    }
    bfs();

    for(auto a : dfs_result){
        cout << a << ' ';
    }
    cout << '\n';

    for(auto a : bfs_result){
        cout << a << ' ';
    }

}