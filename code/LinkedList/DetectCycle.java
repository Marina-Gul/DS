package LinkedList;

public class DetectCycle extends LinkedList {
    
    // Method to detect if there is a cycle in the list
    public boolean hasCycle() {
        if (head == null || head.next == null) {
            return false; // An empty list or a list with only one node can't have a cycle
        }

        Node slow = head;
        Node fast = head;

        // Move fast by two steps and slow by one step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If the loop terminates, there is no cycle    
        return false;
    }
     // Method to create a cycle in the list for testing purposes
     public void createCycle(int index) {
        if (index < 0 || head == null) {
            return;
        }

        Node cycleNode = head;
        Node temp = head;

        // Find the node at the given index
        for (int i = 0; i < index && cycleNode != null; i++) {
            cycleNode = cycleNode.next;
        }

        // Find the last node in the list
        while (temp.next != null) {
            temp = temp.next;
        }

        // Create a cycle by linking the last node to the node at the given index
        temp.next = cycleNode;
    }
    public static void main(String[] args) {
        DetectCycle list = new DetectCycle();

        // Adding elements to the list
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        list.addToBack(4);
        list.addToBack(5);

        // Check for cycle (should be false)
        System.out.println("Cycle detected: " + list.hasCycle()); // Output: false

        // Create a cycle and check again
        list.createCycle(2);
        System.out.println("Cycle detected: " + list.hasCycle()); // Output: true
    }

    
}
