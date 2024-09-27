
import java.util.Arrays;

public class MyArrayList<T> {
    
    private Object[] array;  // Internal array to store elements
    private int size = 0;    // Number of elements in the list
    private int capacity;    // Capacity of the internal array

    // Constructor to initialize the array with a default capacity
    public MyArrayList() {
        capacity = 10; // Default capacity
        array = new Object[capacity];
    }

    // Constructor to initialize with a custom capacity
    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        capacity = initialCapacity;
        array = new Object[capacity];
    }

    // Method to add a new element to the ArrayList
    public void add(T element) {
        // If the array is full, we need to resize it
        if (size == capacity) {
            resize();
        }
        array[size] = element; // Add the element
        size++; // Increase the size
    }

    // Method to get an element at a specific index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (T) array[index]; // Return the element
    }

    // Method to update the element at a specific index
    @SuppressWarnings("unchecked")
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        array[index] = element; // Set the element
    }

    // Method to remove an element from the ArrayList
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        T removedElement = (T) array[index]; // Save the removed element

        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null; // Clear the last element
        size--; // Reduce the size

        return removedElement; // Return the removed element
    }

    // Method to get the number of elements in the ArrayList
    public int size() {
        return size;
    }

    // Method to resize the internal array when it's full
    private void resize() {
        capacity = capacity * 2; // Double the capacity
        array = Arrays.copyOf(array, capacity); // Copy the elements to a new array with a larger capacity
    }

    // Method to display the elements of the ArrayList
    public void display() {
        System.out.print("ArrayList: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the MyArrayList implementation
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Display the ArrayList
        list.display();  // Output: ArrayList: 10 20 30 40 50 

        // Access elements
        System.out.println("Element at index 2: " + list.get(2));  // Output: 30

        // Update an element
        list.set(2, 100);
        list.display();  // Output: ArrayList: 10 20 100 40 50 

        // Remove an element
        list.remove(1);
        list.display();  // Output: ArrayList: 10 100 40 50 

        // Show the size
        System.out.println("Size: " + list.size());  // Output: 4
    }
}
