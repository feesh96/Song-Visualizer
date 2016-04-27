package prj5;

import student.TestCase;

/**
 * Tests Person.
 *
 * @author Sean McHugh (seanfmch)
 * @version Apr 15, 2016
 */
public class PersonTest extends TestCase {

    private Person person;
    private Person person2;
    private Person person3;
    private Person person4;

    /**
     * Instantiates a Person w/ critiques.
     */
    public void setUp()
    {
        person = new Person("Computer Science", "Northeast", "art", 
                            new String[]{"Yes", "No", "Yes"});
        person2 = new Person("Math or CMDA", "Southeast", "music", 
                             new String[]{"Yes", "No", "Yes"});
        person3 = new Person("Other Engineering", "Outside of United States",
                             "sports", new String[]{"Yes", "No", "Yes"});
        person4 = new Person("Other", "Rest of US", "read", 
                             new String[]{"Yes", "No", "Yes"});
    }

    /**
     * Tests getMajor().
     */
    public void testGetMajor()
    {
        assertEquals(MajorEnum.COMPUTER_SCIENCE, person.getMajor());
        assertEquals(MajorEnum.MATH_OR_CMDA, person2.getMajor());
        assertEquals(MajorEnum.OTHER_ENGINEERING, person3.getMajor());
        assertEquals(MajorEnum.OTHER, person4.getMajor());
    }

    /**
     * Tests getRegion().
     */
    public void testGetRegion()
    {
        assertEquals(RegionEnum.NORTHEAST, person.getRegion());
        assertEquals(RegionEnum.SOUTHEAST, person2.getRegion());
        assertEquals(RegionEnum.OUTSIDE_US, person3.getRegion());
        assertEquals(RegionEnum.REST_OF_US, person4.getRegion());
    }
    
    /**
     * Tests getHobby().
     */
    public void testGetHobby()
    {
        assertEquals(HobbyEnum.ART, person.getHobby());
        assertEquals(HobbyEnum.MUSIC, person2.getHobby());
        assertEquals(HobbyEnum.SPORTS, person3.getHobby());
        assertEquals(HobbyEnum.READ, person4.getHobby());
    }
    
    /**
     * Tests getCritiqueAt().
     */
    public void testGetCritiqueAt()
    {
        assertEquals("Yes", person.getCritiqueAt(2));
        assertEquals("Out of bounds", person.getCritiqueAt(999));
    }
}