package prj5;

import java.util.Iterator;

/**
 * Contains a LinkedList of Songs. Provides sorting capability.
 *
 * @author Mostafa Elemary
 * @version 4/16/2016
 */
public class SongList implements Iterable<Song> {

    private LinkedList<Song> songsList;

    /**
     * Instantiates field.
     * @param songsList    LinkedList of Songs
     */
    public SongList(LinkedList<Song> songsList) {
        this.songsList = songsList;
    }

    /**
     * Sorts the songs according to a criteria.
     * @param sortCriteria    a String specifying how to sort.
     */
    public void sortBy(String sortCriteria) {
        switch (sortCriteria) {
            case "artist":
                for (int i = 1; i < songsList.size(); i++) // Insert i'th record
                {
                    for (int j = i; (j > 0)
                            && songsList.get(j).getArtist().compareTo(
                                    songsList.get(j - 1).getArtist()) < 0; j--)
                    {
                        swap(j, j - 1);
                    }
                }
                break;
            case "genre":
                for (int i = 1; i < songsList.size(); i++) // Insert i'th record
                {    
                    for (int j = i; (j > 0) && songsList.get(j).getGenre()
                            .compareTo(songsList.get(j - 1).getGenre()) < 0;
                                       j--)
                    {
                        swap(j, j - 1);
                    }
                }
                break;
            case "year":
                for (int i = 1; i < songsList.size(); i++) // Insert i'th record
                {
                    for (int j = i; (j > 0) && songsList.get(j).getYear()
                            .compareTo(songsList.get(j - 1).getYear()) < 0;
                                       j--)
                    {
                        swap(j, j - 1);
                    }
                }
                break;
            default: // title
                for (int i = 1; i < songsList.size(); i++) // Insert i'th record
                {    
                    for (int j = i; (j > 0) && songsList.get(j).getTitle()
                            .compareTo(songsList.get(j - 1).getTitle()) < 0;
                                       j--)
                    {
                        swap(j, j - 1);
                    }
                }
        }


    }

    /**
     * Swaps the position of two Songs.
     * @param first    first Song
     * @param second    second Song
     */
    private void swap(int first, int second) {
        Song temp = songsList.get(first);
        songsList.remove(first);
        songsList.add(second, temp);
    }
    
    /**
     * Returns the size of the SongList.
     * @return    size
     */
    public int size()
    {
        return songsList.size();
    }
    
    /**
     * Returns an iterator for the SongList.
     * @return    an iterator
     */
    public Iterator<Song> iterator()
    {
        return songsList.iterator();
    }
}