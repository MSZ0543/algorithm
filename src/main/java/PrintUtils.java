/**
 * @program: algorithm
 * @description:
 * @author: szm
 * @create: 2020-02-16 10:20
 **/

public class PrintUtils {


    public static void print2d(Object[][] grif) {
        for (Object[] og : grif) {
            System.out.print("[");
            for (Object o : og) {
                System.out.print(o.toString());
            }
            System.out.println("]");
        }
    }
}
