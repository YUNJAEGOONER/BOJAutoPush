using namespace std;
#include <iostream>
#include <vector>

int main(){
    int a, b;
    cin >> a >> b;
    int result = a + b;

    vector<vector<int>> A(111);
    while(a--){
        int element;
        cin >> element;
        A[element%111].push_back(element);
    }

    while(b--){
        int element;
        cin >> element;
        for(int i = 0 ; i < A[element % 111].size() ; i ++ ){
            if(A[element%111][i] == element){
                result = result - 2;
            }
        }
    }

    cout << result;
}