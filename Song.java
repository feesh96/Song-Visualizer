package songvisualizer;

import java.security.InvalidParameterException;
import java.util.Iterator;

public class Song {
    
    private String title;
    private String genre;
    private String artist;
    private String releaseYear;
    private int originalIndex;
    private Iterator<Person> personIterator;

    
    public Song(String title, String genre, String artist, String releaseYear, LinkedList<Person> personList, int originalIndex) {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.originalIndex = originalIndex;
        personIterator = personList.iterator();
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public String getReleaseYear() {
        return releaseYear;
    }
    
    public int getByMajor(Major major, String likedOrHeard) {
        if (likedOrHeard.equals("liked")) {
            return getLikedByMajor(major);
        }
        else if (likedOrHeard.equals("heard")) {
            return getHeardByMajor(major);
        }
        else {
            throw new InvalidParameterException("Did not write 'liked' or 'heard'");
        }
    }
    
    public int getByRegion(Region region, String likedOrHeard) {
        if (likedOrHeard.equals("liked")) {
            return getLikedByRegion(region);
        }
        else if (likedOrHeard.equals("heard")) {
            return getHeardByRegion(region);
        }
        else {
            throw new InvalidParameterException("Did not write 'liked' or 'heard'");
        }
    }
    
    public int getByHobby(Hobby hobby, String likedOrHeard) {
        if (likedOrHeard.equals("liked")) {
            return getLikedByHobby(hobby);
        }
        else if (likedOrHeard.equals("heard")) {
            return getHeardByHobby(hobby);
        }
        else {
            throw new InvalidParameterException("Did not write 'liked' or 'heard'");
        }
    }
    
    private int getLikedByMajor(Major major) {
        int liked = 0;
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getMajor().equals(major)) {
                if (person.getCritiqueAt(originalIndex * 2 + 1).equals('y')) {
                    liked++;
                }
            }
        }
        return liked;
    }
    
    private int getHeardByMajor(Major major) {
        int heard = 0;
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getMajor().equals(major)) {
                if (person.getCritiqueAt(originalIndex * 2).equals('y')) {
                    heard++;
                }
            }
        }
        return heard;
    }
    
    private int getLikedByRegion(Region region) {
        int liked = 0;
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getRegion().equals(region)) {
                if (person.getCritiqueAt(originalIndex * 2 + 1).equals('y')) {
                    liked++;
                }
            }
        }
        return liked;
    }
    
    private int getHeardByRegion(Region region) {
        int heard = 0;
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getRegion().equals(region)) {
                if (person.getCritiqueAt(originalIndex * 2).equals('y')) {
                    heard++;
                }
            }
        }
        return heard;
    }
    
    private int getLikedByHobby(Hobby hobby) {
        int liked = 0;
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getHobby().equals(hobby)) {
                if (person.getCritiqueAt(originalIndex * 2 + 1).equals('y')) {
                    liked++;
                }
            }
        }
        return liked;
    }
    
    private int getHeardByHobby(Hobby hobby) {
        int heard = 0;
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getHobby().equals(hobby)) {
                if (person.getCritiqueAt(originalIndex * 2).equals('y')) {
                    heard++;
                }
            }
        }
        return heard;
    }
}
