#include <iostream>
#include <vector>
using namespace std;

int main(){

    int N;
    cin >> N;
    int rotate = N - 1;

    int visist[100001];
    int parent[100001];
    vector<vector<int>>adjm(100000);
    vector<int> myqueue;

    for(int i = 0 ; i < N +1; i ++ ){
        vector<int> myvec;
        adjm.push_back(myvec);
        visist[i] = 0;
        parent[i] = 0;
    }

    while(rotate--){
        int node_A, node_B;
        cin >> node_A >> node_B;
        adjm[node_A].push_back(node_B);
        adjm[node_B].push_back(node_A);
    }

    myqueue.push_back(1);
    visist[1] = 1;

    while(!myqueue.empty()){
        int cur_node = *myqueue.begin();
        myqueue.erase(myqueue.begin());
        for(int i = 0; i < adjm[cur_node].size(); i ++ ){
            if(visist[adjm[cur_node][i]] == 0){
                visist[adjm[cur_node][i]] = 1;
                myqueue.push_back(adjm[cur_node][i]);
                parent[adjm[cur_node][i]] = cur_node;
            }
        }
    }

    for(int i = 2; i < N +1 ; i ++ ){
        cout << parent[i] << '\n';
    }

}