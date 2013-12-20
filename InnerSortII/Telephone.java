/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InnerSortII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class Telephone {
    static class Data {
        String val;
        int cnt;
        Data(String v, int c) {
            val = v;
            cnt = c;
        }
    }
    static class MyComparator implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.val.compareTo(o2.val);
        }       
    }
    public static void main(String ...args) {
        String[] base = {"ABC","DEF","GHI","JKL","MNO","PRS","TUV","WXY"};
        HashMap<Character, Character> dict = new HashMap<Character, Character>();
        for (int i = 0; i < 8; i++)
            for (char c : base[i].toCharArray())
                dict.put(c, (char)(i+'2'));
        HashMap<String, Integer> record = new HashMap<String, Integer>();
        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        int temp = cnt;
        while (temp-- > 0) {
            String line = scan.nextLine().replaceAll("-", "");
            char[] cs = line.toCharArray();
            for (int i = 0; i < cs.length; i++)
                if (cs[i] > '9')
                    cs[i] = dict.get(cs[i]);
            line = String.copyValueOf(cs);
            if (record.containsKey(line)) {
                int c = record.get(line);
                record.remove(line);
                record.put(line, ++c);
            } else
                record.put(line, 1);
        }
        if (record.size() == cnt)
            System.out.println("No duplicates.");
        else {
            int len = 0;
            for (int i : record.values())
                if (i > 1)
                    len++;
            Data[] datas = new Data[len];
            int i = 0;
            for (Entry<String, Integer> entry : record.entrySet())
                if (entry.getValue() > 1)
                    datas[i++] = new Data(entry.getKey(), entry.getValue());
            Arrays.sort(datas, new MyComparator());
            for (Data d : datas)
                System.out.println(d.val.substring(0, 3)+"-"+d.val.substring(3)+" "+d.cnt);
        }
    }
}
