package prj5;

import java.security.InvalidParameterException;
import java.util.Iterator;

/**
 * Represents a single Song. 
 *
 * @author Sean McHugh (seanfmch)
 * @version 04/25/2016
 */
public class Song {

    private String title;
    private String genre;
    private String artist;
    private String releaseYear;
    private int originalIndex;
    private LinkedList<Person> personList;


    /**
     * Creates a song and fills its fields. 
     * @param title    title of song
     * @param genre    genre of song
     * @param artist    artist of song
     * @param releaseYear    year song was released
     * @param personList    list of all the person data
     * @param originalIndex    the point the song appears in the data
     */
    public Song(String title, String genre, String artist, String releaseYear,
            LinkedList<Person> personList, int originalIndex)
    {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.originalIndex = originalIndex;
        this.personList = personList;
    }

    /**
     * Returns the title.
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the genre. 
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the artist
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets the release year. 
     * @return release year
     */
    public String getYear() {
        return releaseYear;
    }

    /**
     * Gets the likes/heards of a major. 
     * @param major    what major
     * @param likedOrHeard    liked or heard
     * @return    likes or heards by a major
     */
    public int getByMajor(MajorEnum major, String likedOrHeard) {
        if (likedOrHeard.equals("liked")) {
            return getLikedByMajor(major);
        }
        else if (likedOrHeard.equals("heard")) {
            return getHeardByMajor(major);
        }
        else {
            throw new InvalidParameterException(
                    "Did not write 'liked' or 'heard'");
        }
    }

    /**
     * Gets the likes/heards for a region
     * @param region    region specified
     * @param likedOrHeard    likes or heards
     * @return likes or heards by a specified region
     */
    public int getByRegion(RegionEnum region, String likedOrHeard) {
        if (likedOrHeard.equals("liked")) {
            return getLikedByRegion(region);
        }
        else if (likedOrHeard.equals("heard")) {
            return getHeardByRegion(region);
        }
        else {
            throw new InvalidParameterException(
                    "Did not write 'liked' or 'heard'");
        }
    }

    /**
     * Gets likes or heards by a specified hobby. 
     * @param hobby    hobby
     * @param likedOrHeard    get likes or heards
     * @return    likes or heards by specified hobby
     */
    public int getByHobby(HobbyEnum hobby, String likedOrHeard) {
        if (likedOrHeard.equals("liked")) {
            return getLikedByHobby(hobby);
        }
        else if (likedOrHeard.equals("heard")) {
            return getHeardByHobby(hobby);
        }
        else {
            throw new InvalidParameterException(
                    "Did not write 'liked' or 'heard'");
        }
    }

    /**
     * Get likes for a major.
     * @param major    major specified
     * @return    likes for that major
     */
    private int getLikedByMajor(MajorEnum major) {
        int liked = 0;
        int numPeople = 0;
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getMajor().equals(major)) {
                if (person.getCritiqueAt(originalIndex + 1).equals("Yes")) {
                    liked++;
                    numPeople++;
                }
                else if (person.getCritiqueAt(originalIndex + 1).equals("No"))
                {
                    numPeople++;
                }
            }
        }
        if (numPeople != 0)
        {
            return (int) Math.floor(100 * (float) liked / numPeople);
        }
        else
        {
            return 0;
        }
    }

    /**
     * Gets heards by a major
     * @param major    the major specified
     * @return the heards for that major
     */
    private int getHeardByMajor(MajorEnum major) {
        int heard = 0;
        int numPeople = 0;
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getMajor().equals(major)) {
                if (person.getCritiqueAt(originalIndex).equals("Yes")) {
                    heard++;
                    numPeople++;
                }
                else if (person.getCritiqueAt(originalIndex).equals("No"))
                {
                    numPeople++;
                }
            }
        }
        if (numPeople != 0)
        {
            return (int) Math.floor(100 * (float) heard / numPeople);
        }
        else
        {
            return 0;
        }
    }

    /**
     * Gets likes by a specified region
     * @param region    specified region
     * @return likes for that region
     */
    private int getLikedByRegion(RegionEnum region) {
        int liked = 0;
        int numPeople = 0;
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getRegion().equals(region)) {
                if (person.getCritiqueAt(originalIndex + 1).equals("Yes")) {
                    liked++;
                    numPeople++;
                }
                else if (person.getCritiqueAt(originalIndex + 1).equals("No"))
                {
                    numPeople++;
                }
            }
        }
        if (numPeople != 0)
        {
            return (int) Math.floor(100 * (float) liked / numPeople);
        }
        else
        {
            return 0;
        }
    }

    /**
     * Gets heards for a region. 
     * @param region    specified region
     * @return heards for that region
     */
    private int getHeardByRegion(RegionEnum region) {
        int heard = 0;
        int numPeople = 0;
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getRegion().equals(region)) {
                if (person.getCritiqueAt(originalIndex).equals("Yes")) {
                    heard++;
                    numPeople++;
                }
                else if (person.getCritiqueAt(originalIndex).equals("No"))
                {
                    numPeople++;
                }
            }
        }
        if (numPeople != 0)
        {
            return (int) Math.floor(100 * (float) heard / numPeople);
        }
        else
        {
            return 0;
        }
    }

    /**
     * Gets likes for a hobby.
     * @param hobby    specified hobby
     * @return likes
     */
    private int getLikedByHobby(HobbyEnum hobby) {
        int liked = 0;
        int numPeople = 0;
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getHobby().equals(hobby)) {
                if (person.getCritiqueAt(originalIndex + 1).equals("Yes")) {
                    liked++;
                    numPeople++;
                }
                else if (person.getCritiqueAt(originalIndex + 1).equals("No"))
                {
                    numPeople++;
                }
            }
        }
        if (numPeople != 0)
        {
            return (int) Math.floor(100 * (float) liked / numPeople);
        }
        else
        {
            return 0;
        }
    }

    /**
     * Gets heards by a hobby.
     * @param hobby    specified hobby
     * @return heards by hobby
     */
    private int getHeardByHobby(HobbyEnum hobby) {
        int heard = 0;
        int numPeople = 0;
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getHobby().equals(hobby)) {
                if (person.getCritiqueAt(originalIndex).equals("Yes")) {
                    heard++;
                    numPeople++;
                }
                else if (person.getCritiqueAt(originalIndex).equals("No"))
                {
                    numPeople++;
                }
            }
        }
        if (numPeople != 0)
        {
            return (int) Math.floor(100 * (float) heard / numPeople);
        }
        else
        {
            return 0;
        }
    }
}

