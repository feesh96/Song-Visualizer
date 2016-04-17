package prj5;

import student.TestCase;

/**
 * Tests Song.
 *
 * @author Sean McHugh (seanfmch)
 * @version Apr 15, 2016
 */
public class SongTest extends TestCase {

    private Song song;
    private Song unrated;
    
    /**
     * Creates a song, and the people data it requires. 
     */
    public void setUp()
    {
        LinkedList<Person> people = new LinkedList<Person>();
        
        Person person1 = new Person("Computer Science", "Northeast", "art", 
                                    new String[]{"Yes", "No", "", ""});
        Person person2 = new Person("Math or CMDA", "Southeast", "music",
                                    new String[]{"No", "Yes", "", ""});         
        Person person3 = new Person("Other Engineering",
                                    "Outside of United States", "sports",
                                    new String[]{"Yes", "Yes", "", ""});
        Person person4 = new Person("Other", "Rest of United States", "read",
                                    new String[]{"No", "No", "", ""});
        Person person5 = new Person("Computer Science", "Northeast", "art", 
                                    new String[]{"No", "Yes", "", ""});
        Person person6 = new Person("Math or CMDA", "Southeast", "music",
                                    new String[]{"Yes", "No", "", ""});         
        Person person7 = new Person("Other Engineering",
                                    "Outside of United States", "sports",
                                    new String[]{"No", "No", "", ""});
        Person person8 = new Person("Other", "Rest of United States", "read",
                                    new String[]{"Yes", "Yes", "", ""});
        
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);
        
        song = new Song("Californication", "rock", "Red Hot Chili Peppers",
                        "1999", people, 0);
        unrated = new Song("not in survey", "rock", "Red Hot Chili Peppers",
                "1999", people, 2);
        
    }

    /**
     * Tests getTitle().
     */
    public void testGetTitle()
    {
        assertEquals("Californication", song.getTitle());
    }
    
    /**
     * Tests getGenre().
     */
    public void testGetGenre()
    {
        assertEquals("rock", song.getGenre());
    }
    
    /**
     * Tests getArtist().
     */
    public void testGetArtist()
    {
        assertEquals("Red Hot Chili Peppers", song.getArtist());
    }
    
    /**
     * Tests getYear().
     */
    public void testGetYear()
    {
        assertEquals("1999", song.getYear());
    }
    
    /**
     * Tests getByMajor().
     */
    public void testGetByMajor()
    {
        assertEquals(50, song.getByMajor(MajorEnum.COMPUTER_SCIENCE, "liked"));
        assertEquals(50, song.getByMajor(MajorEnum.COMPUTER_SCIENCE, "heard"));
        
        Exception thrown = null;
        try {
            song.getByMajor(MajorEnum.COMPUTER_SCIENCE, "illegal arg");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        assertEquals(0, unrated.getByMajor(MajorEnum.COMPUTER_SCIENCE,
                                           "liked"));
        assertEquals(0, unrated.getByMajor(MajorEnum.COMPUTER_SCIENCE,
                                           "heard"));
    }
    
    /**
     * Tests getByHobby().
     */
    public void testGetByHobby()
    {
        assertEquals(50, song.getByHobby(HobbyEnum.READ, "liked"));
        assertEquals(50, song.getByHobby(HobbyEnum.READ, "heard"));
        
        Exception thrown = null;
        try {
            song.getByHobby((HobbyEnum.READ), "illegal arg");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        assertEquals(0, unrated.getByHobby(HobbyEnum.READ,
                                           "liked"));
        assertEquals(0, unrated.getByHobby(HobbyEnum.READ,
                                           "heard"));
    }
    
    /**
     * Tests getByHobby().
     */
    public void testGetByRegion()
    {
        assertEquals(50, song.getByRegion(RegionEnum.NORTHEAST, "liked"));
        assertEquals(50, song.getByRegion(RegionEnum.NORTHEAST, "heard"));
        
        Exception thrown = null;
        try {
            song.getByRegion(RegionEnum.NORTHEAST, "illegal arg");
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        assertEquals(0, unrated.getByRegion(RegionEnum.NORTHEAST,
                                           "liked"));
        assertEquals(0, unrated.getByRegion(RegionEnum.NORTHEAST,
                                           "heard"));
    }

}
