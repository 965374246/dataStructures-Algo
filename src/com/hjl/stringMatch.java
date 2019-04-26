package com.hjl;

/**
 * @author jiale.he
 * @date 2019/04/24
 * @email jiale.he@mail.hypers.com
 */
public class stringMatch {
    private static final int SIZE = 256;

    public static void main(String[] args) {
        String a = "qwerwer";
        String b = "qwerqw";

        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();

        int bm = bm(as, as.length, bs, bs.length);
        System.out.println(bm);

        int[] suffix = new int[1];

    }

    private static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        // 初始化suffix和prefix
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        // 遍历模式串
        for (int i = 0; i < m - 1; i++) {
            // j 表示公共后缀子串的起始下标， 如果j==0，说明公共后缀子串也是模式串的前缀子串，记录prefix为true
            int j = i;
            int k = 0;// 公共后缀子串的长度
            while (j >= 0 && b[j] == b[m - 1 - k]) {
                --j;
                ++k;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }

    }


    /**
     * 坏字符匹配
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串长度
     * @return 移动的目标下标
     */
    private static int bm(char[] a, int n, char[] b, int m) {
        // 散列表，记录模式串中每个字符最后出现的位置
        int[] bc = new int[SIZE];
        generateBC(b, b.length, bc);// 构建坏字符哈希表

        int index = 0;// 表示主串与模式串匹配的第一个字符下标

        while (index <= n - m) {
            int j;//模式串的下标
            //模式串从后往前匹配
            for (j = m - 1; j >= 0; j--) {
                if (b[j] != a[j]) break;//找到坏字符下标 j
            }
            if (j < 0) return index;//模式串匹配结束之后 j<0说明 已经匹配上了 返回index下标
            // 计算要后移的步数
            index = index + (bc[a[index + j]]);

        }
        return index;
    }


    /**
     * 散列模式串
     * 下标为ascii值， 值为模式串各个字符的下标
     *
     * @param b  模式串
     * @param m  模式串长度
     * @param bc 散列表
     */
    private static void generateBC(char[] b, int m, int[] bc) {
        //初始化散列表 全为-1
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        //计算模式串ASCII存入散列表
        for (int i = 0; i < m; i++) {
            int ascii = (int) b[i];
            bc[ascii] = i;
        }
    }
}
