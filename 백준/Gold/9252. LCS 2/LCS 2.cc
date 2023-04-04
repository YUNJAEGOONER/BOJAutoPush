#include <iostream>
using namespace std;
#include <vector>

int main(){
    string A, B;
    cin >> A >> B;

    vector<char> sequence;

    int dp [A.size() + 1][B.size() + 1];

    for(int i = 0 ; i  < A.size() + 1 ; i ++ ){
        for(int j = 0 ; j < B.size() + 1; j ++ ){
            dp[i][j] = 0;
        }
    }

    for(int i = 1 ; i < A.size() + 1; i ++ ){
        for(int j = 1; j  < B.size() + 1 ; j ++ ){
            if(A[i-1] == B[j-1]){
                dp[i][j] = dp[i-1][j-1] + 1;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
    }

    cout << dp[A.size()][B.size()] << '\n';
    
    int i = A.size();
    int j = B.size();

    while(i != 0 and j != 0){
        if(dp[i][j-1] == dp[i][j]){
            j = j - 1;
        }
        else if(dp[i-1][j] == dp[i][j]){
            i = i - 1;
        }
        else{
            sequence.push_back(A[i-1]);
            i = i - 1;
            j = j - 1;
        }
    }

    for (auto itr = sequence.end() - 1  ; itr > sequence.begin() - 1 ; itr --){
        cout << *itr;
    }


}