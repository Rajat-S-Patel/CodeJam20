import java.util.*;
import java.io.*;

/**
 * CODEJAM20_5
 */
public class CODEJAM20_5 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static boolean solved;
    static boolean rowSafe[][] = new boolean[60][60];
    static boolean colSafe[][] = new boolean[60][60];
    static int sqr[][] = new int[60][60];
    static int n, k, w;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (w = 1; w <= t; w++) {
            n = sc.nextInt();
            k = sc.nextInt();
            solve(1, 1, 0);
            if (!solved) {
                System.out.println("Case #" + w + ": " + "IMPOSSIBLE");
            }
            solved = false;
        }
    }

    private static void solve(int row, int col, int m) {
        if (row == n && col == n + 1 && m == k && !solved) {
            solved = true;
            System.out.println("Case #" + w + ": POSSIBLE");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; ++j) {
                    System.out.print(sqr[i][j] + " ");
                }
                System.out.println();
            }
            return;
        } else if (row > n) {
            return;
        } else if (col > n) {
            solve(row + 1, 1, m);
        }
        for (int i = 1; i <= n && !solved; i++) {
            if (!rowSafe[row][i] && !colSafe[col][i]) {
                rowSafe[row][i] = colSafe[col][i] = true;
                if (row == col) {
                    m += i;
                }
                sqr[row][col] = i;

                solve(row, col + 1, m);

                rowSafe[row][i] = colSafe[col][i] = false;
                if (row == col) {
                    m -= i;
                }
                sqr[row][col] = 0;
            }
        }
    }
}