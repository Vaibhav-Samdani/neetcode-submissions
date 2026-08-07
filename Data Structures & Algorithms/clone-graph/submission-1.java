/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> mp;

    public Node cloneGraph(Node node) {
        mp = new HashMap<>();

        Node temp = dfs(node);

        return temp;
    }

    Node dfs(Node node) {
        if (node == null) return node;

        if (mp.containsKey(node)) return mp.get(node);

        Node temp = new Node(node.val);
        mp.put(node, temp);

        List<Node> neighbors = node.neighbors;

        for (int i = 0; i < neighbors.size(); i++) {
            if (!mp.containsKey(neighbors.get(i))) {
                dfs(neighbors.get(i));
            }
        }

        List<Node> newNeigh = new ArrayList<>();

        for (int i = 0; i < neighbors.size(); i++) {
            newNeigh.add(mp.get(neighbors.get(i)));
        }

        temp.neighbors = newNeigh;

        return temp;
    }
}
