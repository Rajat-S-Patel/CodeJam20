#include <bits/stdc++.h>
using namespace std;
int main()
{

    int t, k;
    cin >> t;
    for (int k = 0; k < t; k++)
    {
        string ans;
        int i, n;
        cin >> n;
        vector<std::pair<int, std::pair<int, int> > > v;
        int s[n], e[n];
        for (int i = 0; i < n; i++)
        {

            cin >> s[i] >> e[i];
            v.push_back({s[i], {e[i], i}});
            ans += 'C';
        }

        sort(v.begin(), v.end());
        int c = 0, j = 0, flag = 0;
        for (int i = 0; i < v.size(); i++)
        {

            if (v[i].first >= c)
            {
                ans[v[i].second.second] = 'C';
                c = v[i].second.first;
            }

            else if (v[i].first >= j)
            {
                ans[v[i].second.second] = 'J';
                j = v[i].second.first;
            }

            else
            {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
        {
            cout << "Case #" << k + 1 << ": "
                      << "IMPOSSIBLE" << endl;
            continue;
        }
        cout << "Case #" << k + 1 << ": " << ans << endl;
    }
    return 0;
}