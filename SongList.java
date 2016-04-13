package songvisualizer;

import java.util.Iterator;

public class SongList {
    
    private LinkedList<Song> songList;
    private Iterator<Song> iter;
    
    public SongList(LinkedList<Song> songList) {
        this.songList = songList;
        iter = songList.iterator();
    }
    
    public void sortBy(String sortCriteria)
    {
        switch (sortCriteria) {
            case "artist":
                while (iter.hasNext())
                {
                    iter.next().getArtist();
                }
            case "genre":
                something
            case "year":
                something
            default: //title
                something
        }
    }
}
