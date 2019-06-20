/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null)
            return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;
        Node nhead = new Node(head.val, null, null);
        Node nnode = nhead;

        while(true) {
            map.put(node, nnode); 
            node = node.next;
            if(node!=null) {
                nnode.next = new Node(node.val, null, null);
                nnode = nnode.next;
            }
            else
                break;
        }
        
        node = head;
        nnode = nhead;
        while(node!=null && nnode!=null){
            if(null!= node.random && map.containsKey(node.random)){
                nnode.random = map.get(node.random);
            }
            nnode = nnode.next;
            node = node.next;
        }
        
        return nhead;
    }
}
