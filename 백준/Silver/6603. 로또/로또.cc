#include<iostream>
#include<vector>
using namespace std;
vector<int> flag_;
vector<int> nums;

void dfs_lottery(int start, int end, int count)
{
    if(count == 6)
    {
        for(int i = 0 ; i < end ; i ++ )
        {
            if(flag_[i] == 1)
            {
                cout << nums[i] << ' ';
            }
        }
        cout << '\n';
    }
    for(int i = start ; i < end ; i ++)
    {
        //방문했다면 다음거 방문
        if(flag_[i] == 1)continue;
        flag_[i] = 1;
        //다음거 방문한 상태에서 -> 재귀
        dfs_lottery(i, end, count + 1);
        //현재상태에서 방문할 수 있는거 다 방문함
        //backtraking
        flag_[i] = 0;
    }
}

int main()
{

    while(true)
    {
        int n;
        cin >> n;
        if(!n) break;
        for(int i = 0 ; i < n ; i ++ )
        {
            int rnum;
            cin >> rnum;
            flag_.push_back(0);
            nums.push_back(rnum);
        }

        dfs_lottery(0, n, 0);
        flag_.clear();
        nums.clear();
        cout << '\n';
    }
    return 0;
}
