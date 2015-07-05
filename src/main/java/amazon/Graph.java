package amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.google.common.base.Preconditions;

/**
 * @author  tasyrkin
 * @since   2013/08/25
 */
public class Graph {

    private static class Node {
        int id;
        int value;

        public Node(final int id, final int val) {
            this.id = id;
            this.value = val;
        }

        public int getId() {
            return id;
        }

        public int getValue() {
            return value;
        }
    }

    List[] edges;
    Node[] nodes;

    public Graph(final int n) {
        nodes = new Node[n];
        edges = new List[n];
    }

    public void addNode(final Node node) {
        Preconditions.checkNotNull(node, "Node is null");
        Preconditions.checkArgument(node.getId() < nodes.length, "Node id is out of range");
        nodes[node.getId()] = node;
    }

    public void addEdge(final int fromId, final int toId) {

        Preconditions.checkArgument(fromId < nodes.length, "From node is out of range");
        Preconditions.checkNotNull(nodes[fromId], "From node is null");

        Preconditions.checkArgument(toId < nodes.length, "To node is out of range");
        Preconditions.checkNotNull(nodes[toId], "To node is null");

        List list = edges[fromId];
        if (list == null) {
            list = new LinkedList<Integer>();
        }

        list.add(toId);
        edges[fromId] = list;
    }

    public boolean isPathBetween(final int fromId, final int toId) {
        Preconditions.checkArgument(fromId < nodes.length, "From node is out of range");
        Preconditions.checkNotNull(nodes[fromId], "From node is null");

        Preconditions.checkArgument(toId < nodes.length, "To node is out of range");
        Preconditions.checkNotNull(nodes[toId], "To node is null");

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(fromId);

        Set<Integer> visited = new HashSet<Integer>();
        while (!queue.isEmpty()) {
            Integer nodeId = queue.poll();
            if (visited.contains(nodeId)) {
                continue;
            }

            visited.add(nodeId);

            if (nodeId == toId) {
                return true;
            }

            List<Integer> neighbours = (List<Integer>) edges[nodeId];
            if (neighbours != null) {
                for (Integer childId : neighbours) {
                    queue.offer(childId);
                }
            }
        }

        return false;
    }

    public static void main(final String[] args) {
        Graph graph = new Graph(5);
        graph.addNode(new Node(0, 100));
        graph.addNode(new Node(1, 200));
        graph.addNode(new Node(2, 300));

        graph.addEdge(0, 1);

        // graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        System.out.println("1->2 ? " + graph.isPathBetween(1, 2));
        System.out.println("2->1 ? " + graph.isPathBetween(2, 1));
        System.out.println("0->2 ? " + graph.isPathBetween(0, 4));
    }

}
