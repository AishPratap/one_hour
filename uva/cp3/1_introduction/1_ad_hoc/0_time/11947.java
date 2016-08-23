
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

    private static void setDate(Calendar cur, int y, int m, int d) {
        cur.set(y, m, d, 0, 0, 0);
    }

    static class Task {

        static int t;
        static String curline;

        static int[] startDay = {21, 20, 21, 21, 22, 22, 23, 22, 24, 24, 23, 23};
        static int[] endDay = {19, 20, 20, 21, 21, 22, 21, 23, 23, 22, 22, 20};
        static String signs[] = {"aquarius",
            "pisces",
            "aries",
            "taurus",
            "gemini",
            "cancer",
            "leo",
            "virgo",
            "libra",
            "scorpio",
            "sagittarius",
            "capricorn"};

        static void solve() throws Exception {
            t = Next.Int();
            for (int i = 1; i <= t; ++i) {
                curline = Next.Line();
                int month = Integer.parseInt(curline.substring(0, 2)) - 1;
                int day = Integer.parseInt(curline.substring(2, 4));
                int year = Integer.parseInt(curline.substring(4, 8));
                
                Calendar date = Calendar.getInstance();
                date.set(year, month, day);
                date.add(Calendar.WEEK_OF_MONTH, 40);
                printCal(date, i);
            }
        }

        private static void printCal(Calendar date, int ks) {
            out.printf("%d %02d/%02d/%d %s\n", ks, date.get(Calendar.MONTH) + 1,
                    date.get(Calendar.DATE),
                    date.get(Calendar.YEAR),
                    getSign(date));
        }

        private static String getSign(Calendar date) {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            
            int startYear = date.get(Calendar.YEAR);
            int endYear = startYear;
            
            for (int i = 0; i < 11; ++i) {
                if (i == 11) {
                    endYear += 1;
                }
                start.set(startYear, i, startDay[i]);
                end.set(endYear, (i + 1) % 12, endDay[i]);

                if (inBetween(date, start, end)) {
                    return signs[i];
                }
            }
            
            return signs[11];
        }

        private static boolean inBetween(Calendar date, Calendar start, Calendar end) {
            return isBefore(date, end) && isAfter(date, start);
        }

        private static boolean isBefore(Calendar date, Calendar end) {
            int dateYear = date.get(Calendar.YEAR);
            int endYear = end.get(Calendar.YEAR);
            
            if (dateYear < endYear) {
                return true;
            } else if (dateYear == endYear) {
                int dateMonth = date.get(Calendar.MONTH);
                int endMonth = end.get(Calendar.MONTH);
                if (dateMonth < endMonth) {
                    return true;
                } else if (dateMonth == endMonth) {
                    return date.get(Calendar.DATE) <= end.get(Calendar.DATE);
                }
                return false;
            } else {
                return false;
            }
        }

        private static boolean isAfter(Calendar date, Calendar start) {
            int dateYear = date.get(Calendar.YEAR);
            int endYear = start.get(Calendar.YEAR);
            
            if (dateYear > endYear) {
                return true;
            } else if (dateYear == endYear) {
                int dateMonth = date.get(Calendar.MONTH);
                int endMonth = start.get(Calendar.MONTH);
                if (dateMonth > endMonth) {
                    return true;
                 } else if (dateMonth == endMonth) {
                    return date.get(Calendar.DATE) >= start.get(Calendar.DATE);
                }
                return false;
            } else {
                return false;
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
