package songvisualizer;

public class SongList {

    private LinkedList<Song> songList;

    public SongList(LinkedList<Song> songList) {
        this.songList = songList;
    }

    public void sortBy(String sortCriteria) {
        switch (sortCriteria) {
            case "artist":
                for (int i = 1; i < songList.size(); i++) // Insert i'th record
                    for (int j = i; (j > 0)
                            && songList.get(j).getArtist().compareTo(
                                    songList.get(j - 1).getArtist()) < 0; j--)
                        swap(j, j - 1);
            case "genre":
                for (int i = 1; i < songList.size(); i++) // Insert i'th record
                    for (int j = i; (j > 0) && songList.get(j).getGenre()
                            .compareTo(songList.get(j - 1).getGenre()) < 0; j--)
                        swap(j, j - 1);
            case "year":
                for (int i = 1; i < songList.size(); i++) // Insert i'th record
                    for (int j = i; (j > 0) && songList.get(j).getYear()
                            .compareTo(songList.get(j - 1).getYear()) < 0; j--)
                        swap(j, j - 1);
            default: // title
                for (int i = 1; i < songList.size(); i++) // Insert i'th record
                    for (int j = i; (j > 0) && songList.get(j).getTitle()
                            .compareTo(songList.get(j - 1).getTitle()) < 0; j--)
                        swap(j, j - 1);
        }


    }

    public void swap(int first, int second) {
        Song temp = songList.get(first);
        songList.remove(first);
        songList.add(second, temp);
    }
}
