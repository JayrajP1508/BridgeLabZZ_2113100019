package Bridgelabz_2113100011.Assignment23.JUnit;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

// Implementation Class
public class ListManager {
    public void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    public boolean removeElement(List<Integer> list, int element) {
        if (list != null) {
            return list.remove(Integer.valueOf(element)); // Remove by value, not index
        }
        return false;
    }

    public int getSize(List<Integer> list) {
        return (list != null) ? list.size() : 0;
    }
}

// JUnit Test Class
class ListManagerTest {
    ListManager listManager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 10);
        assertEquals(1, list.size());
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        boolean removed = listManager.removeElement(list, 5);
        assertTrue(removed);
        assertFalse(list.contains(5));
        assertEquals(1, list.size());
    }

    @Test
    void testRemoveNonExistentElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        boolean removed = listManager.removeElement(list, 20);
        assertFalse(removed);
        assertEquals(1, list.size());
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, listManager.getSize(list));

        list.add(1);
        list.add(2);
        assertEquals(2, listManager.getSize(list));
    }
}

