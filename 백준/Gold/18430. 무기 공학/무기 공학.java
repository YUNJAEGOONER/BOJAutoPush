import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] mmap;

    static int[][] visited;
    static int[] bVisited;

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Boomerang {
        int score;
        List<Pair> pairList;

        public Boomerang(int score, List<Pair> pairList) {
            this.score = score;
            this.pairList = pairList;
        }
    }

    static int answer = 0;
    static List<Boomerang> boomerangs;

    public static void bt(int start, int max) {
        for (int i = start; i < bVisited.length; i++) {
            if (bVisited[i] == 0) {
                Boomerang cur = boomerangs.get(i);
                List<Pair> pairList = cur.pairList;
                Pair pair0 = pairList.get(0);
                Pair pair1 = pairList.get(1);
                Pair pair2 = pairList.get(2);
                if (visited[pair0.x][pair0.y] == 0 && visited[pair1.x][pair1.y] == 0 && visited[pair2.x][pair2.y] == 0) {
                    visited[pair0.x][pair0.y] = 1;
                    visited[pair1.x][pair1.y] = 1;
                    visited[pair2.x][pair2.y] = 1;
                    bVisited[i] = 1;
                    max += cur.score;
                    if (answer < max) {
                        answer = max;
                    }
                    bt(i + 1, max);
                    max -= cur.score;
                    bVisited[i] = 0;
                    visited[pair0.x][pair0.y] = 0;
                    visited[pair1.x][pair1.y] = 0;
                    visited[pair2.x][pair2.y] = 0;
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        mmap = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                mmap[i][j] = Integer.parseInt(input[j]);
            }
        }

        if (N >= 2 && M >= 2) {
            boomerangs = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if ((i + 1 < N && 0 <= j - 1)) {
                        int score = 0;
                        score += 2 * mmap[i][j];
                        score += mmap[i][j - 1];
                        score += mmap[i + 1][j];
                        List<Pair> pairList = new ArrayList<>();
                        pairList.add(new Pair(i, j));
                        pairList.add(new Pair(i, j - 1));
                        pairList.add(new Pair(i + 1, j));
                        boomerangs.add(new Boomerang(score, pairList));
                    }

                    if ((0 <= i - 1 && 0 <= j - 1)) {
                        int score = 0;
                        score += 2 * mmap[i][j];
                        score += mmap[i][j - 1];
                        score += mmap[i - 1][j];
                        List<Pair> pairList = new ArrayList<>();
                        pairList.add(new Pair(i, j));
                        pairList.add(new Pair(i, j - 1));
                        pairList.add(new Pair(i - 1, j));
                        boomerangs.add(new Boomerang(score, pairList));
                    }

                    if ((0 <= i - 1 && j + 1 < M)) {
                        int score = 0;
                        score += 2 * mmap[i][j];
                        score += mmap[i - 1][j];
                        score += mmap[i][j + 1];
                        List<Pair> pairList = new ArrayList<>();
                        pairList.add(new Pair(i, j));
                        pairList.add(new Pair(i, j + 1));
                        pairList.add(new Pair(i - 1, j));
                        boomerangs.add(new Boomerang(score, pairList));
                    }

                    if ((i + 1 < N && j + 1 < M)) {
                        int score = 0;
                        score += 2 * mmap[i][j];
                        score += mmap[i][j + 1];
                        score += mmap[i + 1][j];
                        List<Pair> pairList = new ArrayList<>();
                        pairList.add(new Pair(i, j));
                        pairList.add(new Pair(i, j + 1));
                        pairList.add(new Pair(i + 1, j));
                        boomerangs.add(new Boomerang(score, pairList));
                    }
                }
            }

            bVisited = new int[boomerangs.size()];
            visited = new int[N][M];
            bt(0, 0);
        }

        System.out.println(answer);
    }
}