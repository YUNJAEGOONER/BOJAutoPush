#include<iostream>
#include<vector>
using namespace std;

int main()
{

    vector<int> storage;

    int n;
    cin >> n;
    while(n --)
    {
        string cmd;
        cin >> cmd;
        if(cmd == "pop_front")
        {
            if(!storage.size())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << *(storage.begin()) << '\n';
                storage.erase(storage.begin());
            }
        }
        else if (cmd == "pop_back")
        {
            if(!storage.size())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << storage.back() << '\n';
                storage.pop_back();
            }
        }
        else if(cmd == "size")
        {
            cout << storage.size() << '\n';
        }
        else if (cmd == "empty")
        {
            if(!storage.size())
            {
                cout << 1 << '\n';
            }
            else
            {
                cout << 0 << '\n';
            }
        }
        else if (cmd == "front")
        {
            if(!storage.size())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << *(storage.begin()) << '\n';
            }
        }
        else if (cmd == "back")
        {
            if(!storage.size())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << storage.back() << '\n';
            }
        }
        else
        {
            int element;
            cin >> element;
            if (cmd[5] == 'b')
            {
                storage.push_back(element);
            }
            else
            {
                vector<int> temp;
                temp.push_back(element);
                for(int i = 0 ; i < storage.size() ; i ++ )
                {
                    temp.push_back(storage[i]);
                }
                storage = temp;
            }
        }
    }


    return 0;
}
