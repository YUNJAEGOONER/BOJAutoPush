#include <iostream>
using namespace std;

int main(){
    char array_2d[5][16];

    for(int j = 0 ; j < 5 ; j ++ ){
        for (int i = 0; i < 15 ; ++i){
            array_2d[j][i] = ' ';
        }
    }

    for(int i = 0 ; i < 5 ; i ++ ){
        string word;
        cin >> word;
        int j = 0;
        while(word[j] != '\0'){
            array_2d[i][j++] = word[j];
        }
    }

    for(int j = 0 ; j < 15 ; j ++ ){
        for (int i = 0; i < 5 ; ++i){
            if (array_2d[i][j] != 32){
                cout << array_2d[i][j];
            }
        }
    }
    
}
