package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

import student.TestCase;

/**
 * Tests LinkedList.
 *
 * @author Sean McHugh (seanfmch)
 * @version 03/25/2016
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> list;
    
    /**
     * Instantiates the list.
     */
    public void setUp()
    {
        list = new LinkedList<String>();
    }

    /**
     * Tests size().
     */
    public void testSize()
    {
        assertEquals(0, list.size());
        list.add("hello");
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }

    /**
     * Tests add().
     */
    public void testAdd()
    {
        Exception thrown = null;
        try {
            String nullStr = null;
            list.add(nullStr);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        try {
            String nullStr = null;
            list.add(-1, nullStr);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        try {
            list.add(0, "hello");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        try {
            list.add(-1, "hello");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        
        try {
            list.add(99, "hello");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
       
        
        list.add("hi");
        list.add("hello");
        list.add(1, "yo");
        assertEquals(list.get(1), "yo");
    }
    
    /**
     * Tests adding by specifying 0 index.
     */
    public void testAdd2()
    {
        list.add("hi");
        list.add(0, "hello");
        assertEquals(list.get(0), "hello");
    }
    
    /**
     * Tests isEmpty().
     */
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add("hello");
        assertFalse(list.isEmpty());
    }
    
    /**
     * Tests remove().
     */
    public void testRemove()
    {
        list.add("yeet");
        list.add("hi");
        list.add("yo");
        list.add("hey");
        list.add("blah");
        assertFalse(list.remove("yoooo"));
        assertTrue(list.remove("yo"));
        assertTrue(list.remove("hey"));
        assertTrue(list.remove("blah"));
        assertTrue(list.remove("hi"));
        assertTrue(list.remove("yeet"));
        assertFalse(list.remove("hi"));
        assertEquals(list.size(), 0);
    }
    
    /**
     * Tests remove().
     */
    public void testRemove2()
    {
        Exception thrown = null;
        try {
            list.remove(1);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        
        list.add("hi");
        list.add("yo");
        list.add("hey");
        assertTrue(list.remove(2));
        assertTrue(list.remove(1));
        assertTrue(list.remove(0));
        assertFalse(list.contains("hi"));
        
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        
        try {
            list.remove(4);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests get().
     */
    public void testGet()
    {
        list.add("hi");
        list.add("yo");
        list.add("hey");
        
        assertEquals("hey", list.get(2));
        assertEquals("yo", list.get(1));
        assertEquals("hi", list.get(0));
        
        Exception thrown = null;
        try {
            list.get(3);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        
    }
    
    /**
     * Tests contains().
     */
    public void testContains()
    {
        list.add("hi");
        list.add("yo");
        list.add("hey");
        
        assertTrue(list.contains("hey"));
        assertTrue(list.contains("yo"));
        assertTrue(list.contains("hi"));
        assertFalse(list.contains("heeee"));
    }
    
    /**
     * Tests clear().
     */
    public void testClear()
    {
        list.clear();
        list.add("hi");
        list.add("yo");
        list.add("hey");
        list.clear();
        assertEquals(list.size(), 0);
    }
    
    /**
     * Tests lastIndexOf().
     */
    public void testLastIndexOf()
    {
        list.add("hi");
        list.add("yo");
        list.add("hey");
        
        assertEquals(2, list.lastIndexOf("hey"));
        assertEquals(-1, list.lastIndexOf("asdf"));
        assertEquals(0, list.lastIndexOf("hi"));
    }
    
    /**
     * Tests toString().
     */
    public void testToString()
    {
        assertEquals("{}", list.toString());
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals("{A, B, C, D}", list.toString());
        list.remove("D");
        list.remove("A");
        assertEquals("{B, C}", list.toString());
    }
        
    /**
     * Tests iterator().
     */
    public void testIterator()
    {
        list.add("one");
        list.add("two");
        list.add("three");
        
        Iterator<String> iterator = list.iterator();
        
        assertEquals("one", iterator.next());
        assertEquals("two", iterator.next());
        assertEquals("three", iterator.next());
        
        Exception thrown = null;
        try {
            iterator.next();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NoSuchElementException);
    }
}

