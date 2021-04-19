package baekjoon.dynamic_programming.generations_of_tribbles_9507;
import java.io.*;

class Main{
    static long[] koong;

    public static void main(String[] args) throws IOException{
        init(68);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(koong[num] + "\n");
        }
        bw.flush();
    }

    static void init(int l) {
        koong = new long[l];

        koong[0] = 1;
        koong[1] = 1;
        koong[2] = 2;
        koong[3] = 4;

        for (int n=4; n<koong.length; n++)
            koong[n] = koong[n-1] + koong[n-2] + koong[n-3] + koong[n-4];
    }
}