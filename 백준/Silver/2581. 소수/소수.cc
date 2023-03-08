#include <iostream>
#define MAX_NUM 10000
using namespace std;

int main(){

    int n, m;
    cin >> n >> m;

    int array[MAX_NUM + 1] = {0,};

    for(int i = 2 ; i < m + 1 ; i ++ ){
        if(array[i-1] == 0){
            int a = 2;
            while((i * a) <= m){
                array[(i*a)-1] = 1;
                a ++;
            }
        }
    }

    array[0] = 1;
    int sum = 0;
    int min;
    for(int i = n ; i < m + 1 ; i ++ ){
        if(array[i-1] == 0){
            if(sum == 0){
                min = i;
            }
            sum = sum + i;
        }
    }

    if(sum == 0){
        cout << -1;
    }
    else{
        cout << sum << '\n' << min;
    }


}