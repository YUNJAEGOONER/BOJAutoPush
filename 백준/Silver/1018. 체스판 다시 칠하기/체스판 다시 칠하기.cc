#include <iostream>
using namespace std;

int main(){
    int N, M;
    cin >> N >> M;

    char White[M + 1];
    char Black[M + 1];

    for(int i = 0 ; i < 8 ; i ++ ){
        if(i % 2 == 0){
            White[i] = 'W';
            Black[i] = 'B';
        }
        else{
            White[i] = 'B';
            Black[i] = 'W';
        }
    }
    White[M] = '\0';
    Black[M] = '\0';

    string pattern[] = {White, Black};

    int case_1 = N * M;
    int case_2 = N * M;

    string my_board[N];

    for(int i = 0; i < N ; i ++ ) {
        string chess_board;
        cin >> chess_board;
        my_board[i] = chess_board;
    }


    for(int i = 0 ; i < (N - 8 + 1); i ++ ) {
        for (int j = 0; j < (M - 8 + 1); j++) {
            int white = 0;
            int black = 1;
            int s_w = 0;
            int s_b = 0;
            for (int k = i; k < i + 8; k++) {
                int index = 0;
                for (int l = j; l < j + 8; l++) {
                    if (my_board[k][l] != pattern[white % 2][index]) {
                        s_w++;
                    }
                    if (my_board[k][l] != pattern[black % 2][index]) {
                        s_b++;
                    }
                    index ++;
                }
                white++;
                black++;
            }
            if(case_1 > s_w){
                case_1 = s_w;
            }
            if(case_2 > s_b){
                case_2 = s_b;
            }
        }
    }

    if(case_1 < case_2){
        cout << case_1;
    }
    else{
        cout << case_2;
    }

}



