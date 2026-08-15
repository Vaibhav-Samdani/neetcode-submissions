class Solution {

    class Pair {
        String word;
        int dis;

        Pair(String word, int dis) {
            this.word = word;
            this.dis = dis;
        }
    }

    Set<String> words;
    Queue<Pair> q;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        words = new HashSet<>();
        q = new LinkedList<>();

        q.offer(new Pair(beginWord, 1));

        for (String d : wordList) {
            if (beginWord.equals(d))
                continue;
            words.add(d);
        }

        while (!q.isEmpty()) {
            Pair node = q.poll();

            if (node.word.equals(endWord)) {
                return node.dis;
            }

            for (int i = 0; i < node.word.length(); i++) {
                solve(node.word, i, node.dis + 1);
            }

        }

        return 0;
    }

    void solve(String word, int pos, int dis) {
        String start = pos == 0 ? "" : word.substring(0, pos);
        String end = pos == word.length() - 1 ? "" : word.substring(pos + 1, word.length());

        for (char i = 'a'; i <= 'z'; i++) {
            String newWord = start + i + end;
            if (words.contains(newWord)) {
                q.offer(new Pair(newWord, dis));
                words.remove(newWord);
            }
        }
    }
}
