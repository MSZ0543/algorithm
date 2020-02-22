import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: szm
 * @create: 2020-02-16 10:20
 **/
public class FormatUtils {
    private static void test(String fileDir, String targetFile) {
        List<File> fileList = new ArrayList<File>();
        File file = new File(fileDir);
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
        if (files == null) {// 如果目录为空，直接退出
            return;
        }
        // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                copy01(f, targetFile);
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath());
                test(f.getAbsolutePath(), targetFile);
            }
        }
        for (File f1 : fileList) {
            System.out.println(f1.getName());
        }
    }

    public static void copy01(File sourceFile, String targetFile) {
//	创建对象
        FileReader fr = null;
        FileWriter fw = null;
        BufferedWriter output = null;
        try {
            fr = new FileReader(sourceFile);
            fw = new FileWriter(targetFile, true);
//            output = new BufferedWriter(fw);
//		循环读和循环写
            int len = 0;
            while ((len = fr.read()) != -1) {
                fw.write((char) len);
            }
//            output.flush();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }


        }
    }


    public static void main(String[] args) {
        test("/Users/maoweize/Desktop/ideaObject/saas-cms/cms-core/src/main/java/cn/creditease/bdp/newcms", "/Users/maoweize/Desktop/商通贷CMS源代码.txt");
    }
}
