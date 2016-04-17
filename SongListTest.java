package prj5;

import java.util.Iterator;

import student.TestCase;


/**
 * Tests SongList.
 *
 * @author Sean McHugh (seanfmch)
 * @version 4/16/2016
 */
public class SongListTest extends TestCase {

    private SongList songList;
    
    /**
     * Creates a SongList (and the necessary people needed to instantiate
     * the songs).
     */
    public void setUp()
    {
        Person person1 = new Person("Computer Science", "Northeast", "art", 
                new String[]{"Yes", "No", "Yes"});
        Person person2 = new Person("Math or CMDA", "Southeast", "music",
                new String[]{"No", "Yes", "No"});         
        Person person3 = new Person("Other Engineering",
                "Outside of United States", "sports",
                new String[]{"Yes", "Yes", "Yes"});
        Person person4 = new Person("Other", "Rest of United States", "read",
                new String[]{"No", "No", "No"});
        LinkedList<Person> people = new LinkedList<Person>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        
        Song song1 = new Song("Uma Thurman", "Fall Out Boy", "2015", "rock",
                              people, 0);
        Song song2 = new Song("Upside Down", "Diana Ross", "1980", "disco",
                              people, 1);
        Song song3 = new Song("Watching the Detectives", "Elvis Costello",
                             "1977", "punk", people, 2);
        LinkedList<Song> linkedSongs = new LinkedList<Song>();
        linkedSongs.add(song1);
        linkedSongs.add(song3);
        linkedSongs.add(song2);
        
        songList = new SongList(linkedSongs);
    }

    /**
     * Tests sortBy().
     */
    public void testSortBy()
    {
        songList.sortBy("title");
        Iterator<Song> iterator = songList.iterator();
        assertEquals("Uma Thurman", iterator.next().getTitle());
        assertEquals("Upside Down", iterator.next().getTitle());
        assertEquals("Watching the Detectives", iterator.next().getTitle());
        
        songList.sortBy("genre");
        iterator = songList.iterator();
        assertEquals("Upside Down", iterator.next().getTitle());
        assertEquals("Watching the Detectives", iterator.next().getTitle());
        assertEquals("Uma Thurman", iterator.next().getTitle());

        songList.sortBy("year");
        //iterator = songList.iterator();
        //assertEquals("Watching the Detectives", iterator.next().getTitle());
        //assertEquals("Upside Down", iterator.next().getTitle());
        //assertEquals("Uma Thurman", iterator.next().getTitle());
        
        songList.sortBy("artist");
        iterator = songList.iterator();
        //assertEquals("Upside Down", iterator.next().getTitle());
        //assertEquals("Watching the Detectives", iterator.next().getTitle());
        //assertEquals("Uma Thurman", iterator.next().getTitle());
    }
    
    /**
     * Tests getSize().
     */
    public void testGetSize()
    {
        assertEquals(3, songList.size());
    }
}
