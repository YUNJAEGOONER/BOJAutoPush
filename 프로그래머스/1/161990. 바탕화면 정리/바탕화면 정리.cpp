#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    
    vector<int> x;
    vector<int> y;
    
    for(int i = 0 ; i < wallpaper.size(); i ++){
        for(int j = 0 ; j < wallpaper[i].size() ; j ++ ){
            if(wallpaper[i][j] == '#'){
                x.push_back(i);
                x.push_back(i + 1);
                y.push_back(j);
                y.push_back(j + 1);
            }
        }
    }
    
    sort(x.begin(), x.end());
    sort(y.begin(), y.end());
    
    answer.push_back(x[0]);
    answer.push_back(y[0]);  
    
    answer.push_back(x[x.size() - 1]);
    answer.push_back(y[y.size() - 1]);     

    return answer;
}