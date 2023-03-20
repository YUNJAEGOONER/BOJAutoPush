#include <iostream>
#include <vector>
using namespace std;
int N, B, W;

vector<vector<char>>matrix;

void my_recursion(int start, int end, int high, int low){
    char standard = matrix[start][high];
    bool colored_paper = true;

    for(int i = start; i < end + 1 ; i ++ ){
        for(int j = high ; j < low + 1 ; j ++ ){
            if(standard != matrix[i][j]){
                colored_paper = false;
                break;
            }
        }
    }
    if(colored_paper){
        if(standard == '1'){
            B ++;
        }
        else{
            W ++;
        }
    }
    else{
        int interval = ((end - start) + 1) / 2;
        //1
        my_recursion(start, (start + interval - 1) , high, (high + interval - 1));
        //2
        my_recursion(start, (start + interval - 1), (high + interval), low);
        //3
        my_recursion(start + interval, end, high + interval, low);
        //4
        my_recursion(start + interval, end, high, (high + interval - 1));
    }

}

int main(){

    cin >> N;

    B = 0;
    W = 0;

    for(int i = 0 ; i < N ; i ++ ){
        vector<char> myvec;
        for(int j = 0 ; j < N; j ++ ){
            int element;
            cin >> element;
            myvec.push_back(element + 48);
        }
        matrix.push_back(myvec);
    }
    
    my_recursion(0, N - 1, 0, N - 1);
    cout << W << '\n' << B;

}