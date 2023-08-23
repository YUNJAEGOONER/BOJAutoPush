#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int input = n;
    int town = 0;
    
    vector<vector<int>> map;
    vector<int> result;
    
    while(input--){
        vector<int> row;
        string input_row;
        cin >> input_row;
        for(int i = 0; i < n ; i ++ ){
            row.push_back(input_row[i]-48);
        }
        map.push_back(row);
    }
    
    vector<int> visit;
    
    for(auto a : map){
        for(auto b : a){
            visit.push_back(1);
        }
    }
    
    int village_num = 5;
    
    for(int i = 0 ; i < visit.size() ; i ++ ){
        if(visit[i] == 1 && map[i/n][i%n] == 1){
            int count = 0;
            town ++;
            vector<int> myq;
            myq.push_back(i);
            while(myq.size()){
                int current = *(myq.begin());
                int index_i = current / n ;
                int index_j = current % n ;
                map[index_i][index_j] = village_num;
                //left
                if((0 <= (index_j-1) && (index_j-1) < n) && (0 <= index_i && index_i < n)){
                    if(map[index_i][index_j-1] == 1 && visit[index_i * n + index_j-1] == 1){
                        visit[index_i * n + index_j-1] = 0;
                        myq.push_back(index_i * n + index_j-1);
                        count ++;
                    }
                }
                //right
                if((0 <= (index_j+1) && (index_j+1) < n) && (0 <= index_i && index_i < n)){
                    if(map[index_i][index_j+1] == 1 && visit[index_i * n + index_j+1] == 1){
                        visit[index_i * n + index_j+1] = 0;
                        myq.push_back(index_i * n + index_j+1);
                        count ++;    
                    }
                }
                //up 
                if((0 <= (index_j) && (index_j) < n) && (0 <= (index_i - 1) && (index_i - 1) < n)){
                    if(map[index_i-1][index_j] == 1 && visit[(index_i - 1) * n + index_j] == 1){
                        visit[(index_i - 1) * n + index_j] = 0;
                        myq.push_back((index_i - 1) * n + index_j);
                        count ++;
                    }
                }
                //down
                if((0 <= (index_j) && (index_j) < n) && (0 <= (index_i + 1) && (index_i + 1) < n)){
                    if(map[index_i+1][index_j] == 1 && visit[(index_i + 1) * n + index_j] == 1){
                        visit[(index_i + 1) * n + index_j] = 0;
                        myq.push_back((index_i + 1) * n + index_j);
                        count ++;
                    }
                }
                myq.erase(myq.begin());
               
            }
            village_num ++;
            count ++;
            result.push_back(count);
        }
    }
    sort(result.begin(), result.end());
    cout << town << '\n';
    for(auto a : result){
        cout << a << '\n';
    }
}
