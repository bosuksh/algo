package org.example.trie;

public class SearchLyrics {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] result = solution(words,queries);
        for(int val: result) {
            System.out.print(val+" ");
        }
        System.out.println();
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie[] tries = new Trie[10001];
        Trie[] reverseTries = new Trie[10001];
        for(String word: words) {
            int length = word.length();
            if(tries[length] == null) {
                tries[length] = new Trie();
            }
            tries[length].insert(word.toCharArray());
            if(reverseTries[length] == null) {
                reverseTries[length] = new Trie();
            }
            reverseTries[length].insert(new StringBuilder(word).reverse().toString().toCharArray());
        }

        for(int i = 0; i< queries.length; i++) {
            int length = queries[i].length();
            if(queries[i].startsWith("?")) {
                if (reverseTries[length] == null) {
                    answer[i] = 0;
                    continue;
                }
                answer[i] = reverseTries[length].search(new StringBuilder(queries[i]).reverse().toString().toCharArray());
                continue;
            }
            if (tries[length] == null) {
                answer[i] = 0;
                continue;
            }
            answer[i] = tries[length].search(queries[i].toCharArray());
        }

        return answer;
    }

    public static class Trie {
        private int count;
        private Trie[] children;
        private boolean isTerminal;

        public Trie() {
            this.count = 0;
            this.children = new Trie[26];
            this.isTerminal = false;
        }

        public void insert(char[] word) {
            if(search(word) != 0) return;
            Trie current = this;
            for(char unit: word) {
                current.count++;
                if(current.children[unit - 'a'] == null) {
                    current.children[unit - 'a'] = new Trie();
                }
                current = current.children[unit - 'a'];
            }
            current.isTerminal = true;
        }

        public int search(char[] word) {
            Trie current = this;
            for(char unit: word) {
                if(unit == '?') {
                    return current.count;
                }
                if(current.children[unit - 'a'] == null) {
                    return 0;
                }
                current = current.children[unit - 'a'];
            }
            return current.count;
        }
    }
}
