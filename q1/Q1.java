package q1;

import Template.Template;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        try {
            List<String> input = Template.readInputFile("q1", "input1.txt");
            char[] chars = input.get(0).toCharArray();

            int potions = 0;
            for (char c : chars) {
                if (c == 'B') {
                    potions += 1;
                } else if (c == 'C') {
                    potions += 3;
                } 
            }
            System.out.println(potions);

            input = Template.readInputFile("q1", "input2.txt");
            chars = input.get(0).toCharArray();
            potions = 0;
            char[] pairs = new char[2];
            for (int i = 0; i < chars.length/2; i++) {
                pairs[0] = chars[i*2];
                pairs[1] = chars[i*2+1];
                if (pairs[0] == 'x') {
                    potions += ev(pairs[1]);
                } else if (pairs[1] == 'x') {
                    potions += ev(pairs[0]);
                } else {
                    potions += ev(pairs[0]) + ev(pairs[1]) + 2;
                }
            }
            System.out.println(potions);

            input = Template.readInputFile("q1", "input3.txt");
            chars = input.get(0).toCharArray();
            potions = 0;
            char[] triplet = new char[3];
            for (int i = 0; i < chars.length/3; i++) {
                triplet[0] = chars[i*3];
                triplet[1] = chars[i*3+1];
                triplet[2] = chars[i*3+2];
                if (triplet[0] == 'x' && triplet[1] == 'x' && triplet[2] == 'x') {
                    potions += 0;
                } else if (triplet[0] == 'x' && triplet[1] == 'x') {
                    potions += ev(triplet[2]);
                } else if (triplet[1] == 'x' && triplet[2] == 'x') {
                    potions += ev(triplet[0]);
                } else if (triplet[0] == 'x' && triplet[2] == 'x') {
                    potions += ev(triplet[1]);
                } else if (triplet[0] == 'x') {
                    potions += ev(triplet[1]) + ev(triplet[2]) + 2;
                } else if (triplet[1] == 'x') {
                    potions += ev(triplet[0]) + ev(triplet[2]) + 2;
                } else if (triplet[2] == 'x') {
                    potions += ev(triplet[0]) + ev(triplet[1]) + 2;
                } else {
                    potions += ev(triplet[0]) + ev(triplet[1]) + ev(triplet[2]) + 6;
                }
            }
            System.out.println(potions);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int ev(char c) {
        if (c == 'B') {
            return 1;
        } else if (c == 'C') {
            return 3;
        } else if (c == 'D') {
            return 5;
        } else {
            return 0;
        }
    }
}