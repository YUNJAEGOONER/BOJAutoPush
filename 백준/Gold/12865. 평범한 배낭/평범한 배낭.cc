#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n, W;
    cin >> n >> W;
    int key = 0;
    map<int, vector<int>> items;
    vector<vector<int>> sorted_item;

    while(key < n){
        int weight, value;
        cin >> weight >> value;
        items[weight].push_back(value);
        key++;
    }

    vector<int> zero;
    zero.push_back(0);
    zero.push_back(0);
    sorted_item.push_back(zero);

    for(auto a: items){
        sort(a.second.begin(), a.second.end());
        for(auto b : a.second){
            vector<int> item_info;
            item_info.push_back(a.first);
            item_info.push_back(b);
            sorted_item.push_back(item_info);
        }
    }

    int bag[n+1][W+1];

    for(int i = 0 ; i < n + 1 ; i ++ ){
        for(int j = 0; j < W + 1 ; j ++ ){
            bag[i][j] =0;
        }
    }

    for(int item = 1 ; item < n + 1; item ++ ){
        for(int weight = 1 ; weight < W + 1 ;  weight ++ ){
            if(weight - sorted_item[item][0] >= 0){
                if(bag[item-1][weight-sorted_item[item][0]] + sorted_item[item][1] > bag[item-1][weight]){
                    bag[item][weight] = bag[item-1][weight-sorted_item[item][0]] + sorted_item[item][1];
                }
                else{
                    bag[item][weight] = bag[item-1][weight];
                }
            }
            else{
                bag[item][weight] = bag[item-1][weight];
            }
        }
    }

    cout << bag[n][W];

}