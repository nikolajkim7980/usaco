/*
import java.util.StringTokenizer;
ID: nkkim201
LANG: JAVA
TASK: pprime
*/

//complete
import java.io.*;
import java.util.*;

class pprime {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[]vals = {2, 3, 5, 7,11};
        for(int v: vals){
            if(v>=start){
                out.println(v);
            }
        }

        boolean aWorks = true;
        boolean bWorks = true;

        for(int i = 10; i < 9999; i++){
            if(!aWorks && !bWorks) break;
            if(aWorks){
                int a = Integer.parseInt(create1(Integer.toString(i)));
                if(a < start) continue;
                if(a > end) aWorks =false;
                else {
                    if(isPrime(a)) out.println(a);
                }
            }
            if(bWorks){
                int b = Integer.parseInt(create2(Integer.toString(i)));
                if(b < start) continue;
                if(b > end) bWorks =false;
                else {
                    if(isPrime(b)) out.println(b);
                }
            }
        }
        out.close();
    }
    public static String create1(String x){
        int len = x.length();
        s = "";
        for(int i = len-1; i>=0;i--){
            s+=x.charAt(i);
        }
        return x+s;
    }
    public static String create2(String x){
        int len = x.length();
        s = "";
        for(int i = len-2; i>=0;i--){
            s+=x.charAt(i);
        }
        return x+s;
    }

    public static boolean isPrime(int x) {
        if (x % 2 == 0 && x != 2) {
            return false;
        }
    
        int sqr = (int)Math.sqrt(x);
        for (int i = 3; i <= sqr; i += 2) {
            if(x % i == 0) {
                return false;
             }
         }
        return true;
    }
}
