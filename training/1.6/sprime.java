/*
import java.util.StringTokenizer;
ID: nkkim201
LANG: JAVA
TASK: sprime
*/

//complete
import java.io.*;
import java.util.*;

class sprime {
    static int n;
    static TreeSet<Integer> s;
    static int cnt;
    static int test;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        n = Integer.parseInt(f.readLine());
        s = new TreeSet<>();
        solve(2, 1);
        solve(3, 1);
        solve(5, 1);
        solve(7, 1);
        for(int v: s){
          out.println(v);
        }
        out.close();
    }

    static void solve(int x, int cnt){
        if(!isPrime(x)){
            return;
        }
        if(cnt == n){
            s.add(x);
        } 
        solve(x*10+1, cnt+1);
        solve(x*10+3, cnt+1);
        solve(x*10+5, cnt+1);
        solve(x*10+7, cnt+1);
        solve(x*10+9, cnt+1);
    }

    public static boolean isPrime(int x) {
        int sqr = (int)Math.sqrt(x);
        for (int i = 3; i <= sqr; i += 2) {
            if(x % i == 0) {
                return false;
             }
         }
        return true;
    }
}
