using namespace std;
#include <iostream>

int main(){
    
    int N, X;
    cin >> N >> X;
    
    int array[N];
    int index = 0;
    
    while(index < N){
        int element;
        cin >> element;
        array[index++] = element;
    }
    
    for(int i = 0 ;  i < N ; i ++ ){
        if(array[i] < X){
            cout << array[i] << " ";
        }
    }
}