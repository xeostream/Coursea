
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Question: http://dsalgo.openjudge.cn/dsmoochw2/1/
 * @author Arthur
 */
public class Main {

    static class Node {

        int number;
        int power;

        Node(int n, int p) {
            number = n;
            power = p;
        }
    }

    public static void main(String... args) {
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n2.power - n1.power;
            }
        };
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        for (int c = 0; c < cnt; c++) {
            ArrayList<Node> one = new ArrayList<>();
            ArrayList<Node> two = new ArrayList<>();
            int n = scan.nextInt();
            int p = scan.nextInt();
            while (p >= 0) {
                if (n != 0) {
                    boolean key = false;
                    for (Node node : one) {
                        if (node.power == p) {
                            node.number += n;
                            key = true;
                            break;
                        }
                    }
                    if (!key) {
                        one.add(new Node(n, p));
                    }
                }
                n = scan.nextInt();
                p = scan.nextInt();
            }
            n = scan.nextInt();
            p = scan.nextInt();
            while (p >= 0) {
                if (n != 0) {
                    boolean key = false;
                    for (Node node : two) {
                        if (node.power == p) {
                            node.number += n;
                            key = true;
                            break;
                        }
                    }
                    if (!key) {
                        two.add(new Node(n, p));
                    }
                }
                n = scan.nextInt();
                p = scan.nextInt();
            }
            Collections.sort(one, comparator);
            Collections.sort(two, comparator);
            ArrayList<Node> result = new ArrayList<>();
            int i = 0, j = 0;
            while (i < one.size() && j < two.size()) {
                Node n1 = one.get(i);
                Node n2 = two.get(j);
                if (n1.power == n2.power && n1.number + n2.number != 0) {
                    n1.number = n1.number + n2.number;
                    result.add(n1);
                    i++;
                    j++;
                } else if (n1.power > n2.power) {
                    result.add(n1);
                    i++;
                } else if (n1.power < n2.power) {
                    result.add(n2);
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
            while (i < one.size()) {
                result.add(one.get(i++));
            }
            while (j < two.size()) {
                result.add(two.get(j++));
            }
            if (result.isEmpty()) {
                System.out.println();
                continue;
            }
            for (int in = 0; in < result.size() - 1; in++) {
                if (result.get(in).number != 0)
                    System.out.print("[ " + result.get(in).number + " " + result.get(in).power + " ] ");
            }
            if (result.get(result.size()-1).number != 0)
                System.out.print("[ " + result.get(result.size() - 1).number + " " + result.get(result.size() - 1).power + " ]");
            System.out.println();
        }
    }
}
