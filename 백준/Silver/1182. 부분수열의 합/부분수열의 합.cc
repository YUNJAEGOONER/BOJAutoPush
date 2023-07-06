#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

int main(){
        int n, target;
        cin >> n >> target;
        vector<int> numbers;
        int len = n;
        int element;
        int count = 0;
        while(n --){
                cin >> element;
                numbers.push_back(element);
        }
        vector<vector<int>> nodes;
        for(int i = 0 ; i  < len + 1 ; i ++){
                vector<int> row;
                nodes.push_back(row);
        }

        nodes[0].push_back(0);

        for(int i = 1 ; i < len + 1 ; i ++ ){
                for(int j = 0 ; j < pow(2, i) ; j ++ ){
                        if(j % 2 == 0){
                                int value = nodes[i-1][j/2] + numbers[i-1];
                                if(value == target){count ++ ;}
                                nodes[i].push_back(value);
                        }
                        else{
                                nodes[i].push_back(nodes[i-1][j/2]);
                        }
                }
        }

        cout << count ;


}