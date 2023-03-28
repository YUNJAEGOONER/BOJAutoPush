#include <iostream>
using namespace std;

int main(){
    int N;
    cin >> N;
    int size = N;
    int array [size];
    int index = 0;

    while(N--){
        int element;
        cin >> element;
        array[index ++] = element;
    }

    int max = 0;
    int sum = 0;
    int max_element = array[0];

    for(int i = 0 ; i < size ; i ++ ){
        if(max_element < array[i]) {
            max_element = array[i];
        }
        sum = sum + array[i];
        if(sum > max){
            max = sum;
        }
        else if(sum < 0){
            sum = 0;
        }
    }

    if(max != 0){
        cout << max;
    }
    else{
        cout << max_element;
    }
}