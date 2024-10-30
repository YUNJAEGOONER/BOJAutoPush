#include<iostream>
#include<vector>
using namespace std;

int main(){
    int N;
    cin>>N;
    vector<vector<int>> map;
    vector<int> dis;

    for(int i = 0 ; i < N ; i ++ ) {
        vector<int> temp;
        for(int j = 0 ; j < N ; j ++ ) {
            temp.push_back(0);
        }
        map.push_back(temp);
        dis.push_back(-1);
    }

    int s,e;
    cin >> s >> e;

    int r;
    cin >> r;
    while(r--) {
        int a, b;
        cin >> a >> b;
        map[a-1][b-1] = 1;
        map[b-1][a-1] = 1;
    }


    vector<vector<int>>st;
    int start = s - 1;
    vector<int> temp;
    temp.push_back(start);
    temp.push_back(0);//count;
    st.push_back(temp);

    while(!st.empty()) {
        int cur_idx = st.back()[0];
        int count = st.back()[1];
        dis[cur_idx] = count;
        st.pop_back();

        for(int i = 0 ; i < N ; i ++ ) {
            vector<int> temp;
            if(map[cur_idx][i] == 1 && dis[i] == -1) {
                temp.push_back(i);
                temp.push_back(count + 1);
                st.push_back(temp);
            }
        }
    }

    cout << dis[e - 1] << endl;


    return 0;
}
