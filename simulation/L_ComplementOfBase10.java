package org.example.leetcode;

public class ComplementOfBase10 {
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
        System.out.println(bitwiseComplement(2));
        System.out.println(bitwiseComplement(10));
    }
    public static int bitwiseComplement(int N) {
        if(N == 0)
            return 1;

        int two = 2;
        while(N >= two) {
            two *= 2;
        }
        return two-1-N;
    }
}
