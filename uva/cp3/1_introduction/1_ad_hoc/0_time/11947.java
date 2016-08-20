
import java.io.*;
import java.util.*;

/**
 * Competitive Java Template
 *
 * @author hkhoi
 */
public class Main {

    private static final boolean LOCAL = true;
    private static BufferedReader in;
    private static StringTokenizer token;
    private static PrintWriter out;

    static {
        if (LOCAL) {
            try {
                in = new BufferedReader(new FileReader("_in"));
                out = new PrintWriter(new FileOutputStream("_out"), false);
//                out = new PrintWriter("_out");
            } catch (Exception e) {
                // Catch shit
            }
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out, false);
        }
    }

    public static void main(String[] args) throws Exception {
        Task.solve();
        
        out.close();
        in.close();
    }

    static class Task {
        static int t;
        static String line;
        static int d, m, y;
        static void solve() throws Exception {
//            System.out.println("DEBUG: begin");
            t = Next.Int();
            
            while(t-- > 0) {
//                System.out.println("DEBUG: " + t);
                line = Next.Line();
                m = Integer.parseInt(line.substring(0, 2));
                d = Integer.parseInt(line.substring(2, 4));
                y = Integer.parseInt(line.substring(4, 8));
                Calendar calendar = Calendar.getInstance();
                calendar.set(y, m - 1, d);
                calendar.add(Calendar.WEEK_OF_YEAR, 40);
                
                out.println((1 + calendar.get(Calendar.MONTH)) + "/" +
                        calendar.get(Calendar.DATE) + "/" + 
                        calendar.get(Calendar.YEAR));
            }
        }
    }

    private static class Next {

        public static String Token() throws Exception {
            try {
                while (token == null || !token.hasMoreTokens()) {
                    token = new StringTokenizer(in.readLine());
                }
                return token.nextToken();
            } catch (NullPointerException e) {
                return null;
            }
        }

        public static String Line() throws Exception {
            try {
                String line = in.readLine();
                while (line.isEmpty()) {
                    line = in.readLine();
                }
                return line;
            } catch (NullPointerException e) {
                return null;
            }
        }

        public static int Int() throws Exception {
            return Integer.parseInt(Token());
        }

        public static long Long() throws Exception {
            return Integer.parseInt(Token());
        }

        public static float Float() throws Exception {
            return Float.parseFloat(Token());
        }

        public static double Double() throws Exception {
            return Double.parseDouble(Token());
        }
    }
}
