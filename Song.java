package songvisualizer;

public class Song {
    private String title;
    private String genre;
    private String artist;
    private String releaseYear;
    
    public Song(String title, String genre, String artist, String releaseYear) {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.releaseYear = releaseYear;
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
}
