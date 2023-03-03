#include <iostream>
#include <vector>
using namespace std;

int main(){
    int N, M;
    cin >> N;
    M = N;

    vector<int> A;
    vector<int> B;

    while(N--){
        int element;
        cin >> element;
        A.push_back(element);
    }

    while(M--){
        int element;
        cin >> element;
        B.push_back(element);
    }

    //quick_sort
    for(int i = 0 ; i < A.size() - 1 ; i ++ ){
        for(int j = 0 ; j < A.size() - 1 - i ; j ++ ){
            if(A[j] > A[j+1]){
                int temp = A[j];
                A[j] = A[j+1];
                A[j+1] = temp;
            }
        }
    }
   
    for(int i = 0 ; i < B.size() - 1 ; i ++ ){
        for(int j = 0 ; j < B.size() - 1 - i ; j ++ ){
            if(B[j] < B[j+1]){
                int temp = B[j];
                B[j] = B[j+1];
                B[j+1] = temp;
            }
        }
    }

    int result = 0;
    for(int i = 0 ; i < A.size()  ; i ++ ){
        result = result + (A[i] * B[i]);
    }

    cout << result;
}