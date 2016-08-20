
import java.io.*;
import java.util.*;

/**
 * Competitive Java Template
 *
 * @author hkhoi
 */
public class Main {

    private static final boolean LOCAL = false;
    private static BufferedReader in;
    private static StringTokenizer token;
    private static PrintWriter out;

    static {
        if (LOCAL) {
            try {
                in = new BufferedReader(new FileReader("_in"));
                out = new PrintWriter(new FileOutputStream("_out"), false);
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

        static int amount, day, month, year;

        static void solve() throws Exception {
            while (true) {
                amount = Next.Int();
                day = Next.Int();
                month = Next.Int();
                year = Next.Int();

                if (amount == 0 &&
                        day == 0 &&
                        month == 0 &&
                        year == 0) {
                    break;
                }
                
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month - 1, day);
                calendar.add(Calendar.DATE, amount);

                out.println(
                        calendar.get(Calendar.DATE) + " "
                        + (calendar.get(Calendar.MONTH) + 1) + " "
                        + calendar.get(Calendar.YEAR));
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
