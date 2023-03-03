#include <iostream>
#include <vector>
using namespace std;

int main(){
    int node;
    cin >> node;

    vector<int> visit(node);

    vector<int> nodes(node);
    vector<vector<int>> graph;

    for(int i = 0 ; i < node ; i ++ ){
        graph.push_back(nodes);
    }

    int link;
    cin >> link;


    while(link--){
        int node_A, node_B;
        cin >> node_A >> node_B;
        graph[node_A-1][node_B-1] = 1;
        graph[node_B-1][node_A-1] = 1;
    }

    vector<int>mystack;

    visit[0] = 1;
    for(int i = 0 ; i < node ; i ++ ){
        if(graph[0][i] != 0){
            mystack.push_back(i+1);
            visit[i] = 1;
        }
    }

    while(!mystack.empty()){
        visit[*(mystack.end()-1)-1] = 1;
        int top = *(mystack.end()-1);
        mystack.erase(mystack.end()-1);
        for(int i = 0 ; i < node ; i ++ ){
            if(graph[top-1][i] == 1 and visit[i] == 0){
                mystack.push_back(i+1);
            }
        }
    }

    int count = 0;
    for(int i = 1 ; i < node ; i ++ ){
        if(visit[i] == 1){
            count ++;
        }
    }

    cout << count;


}
