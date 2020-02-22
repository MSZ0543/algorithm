package algorithm.array;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 每日温度
 * @author: szm
 * @create: 2020-02-20 20:55
 **/
public class Leetcode739 {

    @Test
    public void test() {
        System.out.println("----------start-----------");

        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j += result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

//     return result;
// }
//    public int[] dailyTemperatures(int[] T) {
//        int length = T.length;
//        int[] res = new int[length];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        LinkedList<Integer> stack = new LinkedList<>();
//        for(int i = length - 1; i >= 0; i --) {
//            int nw = T[i];
//            for(int w : stack) {
//                if(w > nw) {
//                    res[i] = map.get(w) - i;
//                    break;
//                }
//            }
//            stack.addFirst(nw);
//            map.put(nw, i);
//        }
//        return res;
//    }

}
