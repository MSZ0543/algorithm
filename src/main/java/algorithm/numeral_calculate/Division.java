package algorithm.numeral_calculate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @program: algorithm
 * @description: 使用java实现小学除法
 * @author: szm
 * @create: 2020-03-24 10:44
 **/
public class Division {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        System.out.println(division(1, 7));
    }


    private String division(int bei, int chu) {
        String res = "";
        int oldBei = bei;
        int shang = 0, yushu = 0;
        ArrayList<Integer> memoList = new ArrayList<>();
        if(bei < chu) {
            res += "0.";
            bei *= 10;
        }
        Integer xunhuan = 0;
        do{
            if(memoList.contains(shang)) {
                xunhuan = shang;
                break;
            }
            shang = bei / chu;
            yushu = bei % chu;
            res += String.valueOf(shang);
            oldBei *= 10;
            bei = yushu * 10 + oldBei % 10;
            memoList.add(shang);
        } while(bei > 0);
        String tmp = "";
        for(int i = memoList.indexOf(xunhuan); i < memoList.size(); i ++) {
            tmp += memoList.get(i);
        }
        res = res.replaceAll(tmp, "(" + tmp + ")");
        return res;
    }
}
