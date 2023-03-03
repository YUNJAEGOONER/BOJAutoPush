#include <iostream>
using namespace std;

int array[1000001] = {0,};

void make_one(int x){
    for(int i = 4; i < x + 1 ; i ++ ){
        int min = array[i-1] + 1;
        if(i % 3 == 0){
            int div_3 = array[i/3] + 1;
            if(min > div_3){
                min = div_3;
            }
        }
        if (i % 2 == 0){
            int div_2 = array[i/2] + 1;
            if(min > div_2){
                min = div_2;
            }
        }
        array[i] = min;
        //cout << i << " :  " << min << '\n';

    }
}

int main(){
    array[2] = 1;
    array[3] = 1;
    int N;
    cin >> N;
    make_one(N);
    cout << array[N];
}