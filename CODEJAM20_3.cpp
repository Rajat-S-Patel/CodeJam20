#include <bits/stdc++.h>
int main(int argc, char const *argv[])
{

    int t, k;
    std::cin >> t;
    for (int k = 0; k < t; k++)
    {
        std::string s1;
        int i, n;
        std::cin >> n;
        std::vector<std::pair<int, std::pair<int, int>>> v;
        int s[n], e[n];
        for (int i = 0; i < n; i++)
        {

            std::cin >> s[i] >> e[i];
            v.push_back({s[i], {e[i], i}});
            s1 += 'C';
        }

        std::sort(v.begin(), v.end());
        int c = 0, j = 0, flag = 0;
        for (int i = 0; i < v.size(); i++)
        {

            if (v[i].first >= c)
            {
                s1[v[i].second.second] = 'C';
                c = v[i].second.first;
            }

            else if (v[i].first >= j)
            {
                s1[v[i].second.second] = 'J';
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
            std::cout << "Case #" << k + 1 << ": "
                      << "IMPOSSIBLE" << std::endl;
            continue;
        }
        std::cout << "Case #" << k + 1 << ": " << s1 << std::endl;
    }
    return 0;
}