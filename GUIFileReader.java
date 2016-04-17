package prj5;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Reads in the survey and song data to create a SongList.
 *
 * @author Sean McHugh
 * @version 4/16/2016
 */
public class GUIFileReader {
    
    /**
     * Takes in survey data and song data to create a SongList, and uses it
     * to create a new GUIDisplayWindow. 
     * @param personFile    survey data
     * @param songFile    song data
     */
    public GUIFileReader(String personFile, String songFile)
    {        
        LinkedList<Song> songs = readData(personFile, songFile);
        SongList newSongList = new SongList(songs);
        //new DisplayWindow(newSongList);
        printData(newSongList);
    }

    /**
     * Parses the data into a SongList.
     * @param personFile    survey data
     * @param songFile    song data
     * @return a SongList
     */
    public LinkedList<Song> readData(String personFile, String songFile) {
        try {
            Scanner songScanner = new Scanner(new File(songFile));
            Scanner personScanner = new Scanner(new File(personFile));
            
            LinkedList<Person> personList = new LinkedList<Person>();
            LinkedList<Song> songList = new LinkedList<Song>();
            
            personScanner.nextLine();
            
            while (personScanner.hasNextLine()) {                
                String[] input = personScanner.nextLine().split(",");
                
                if (input.length >= 5) {    //if survey data valid
                    
                    String major = input[2];
                    String region = input[3];
                    String hobby = input[4];
                    List<String> critique = new ArrayList<String>();
                                    
                    for (int i = 5; i < input.length; i++)
                    {
                        critique.add(input[i]);
                    }
                    critique.add(""); //used in cases where didnt answer last q
                    
                    String[] critArray = Arrays.copyOf(critique.toArray(),
                                                      critique.toArray().length,
                                                       String[].class);
                    
                    
                    if (!major.equals("") &&
                        !region.equals("") &&
                        !hobby.equals(""))
                    {
                        personList.add(new Person(major, region, hobby,
                                                  critArray));             
                    }
                }
            }
            personScanner.close();
                                    
            songScanner.nextLine();
            int i = 0;
            while (songScanner.hasNextLine())
            {                
                String[] input = songScanner.nextLine().split(",");
                
                String title = input[0];
                String artist = input[1];
                String year = input[2];
                String genre = input[3];
                
                Song temp = new Song(title, genre, artist, year, personList, i);
                songList.add(temp);
                i += 2;
            }
            songScanner.close();
                        
            return songList;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
            return null;
        }
    }
    
    /**
     * Used for debugging purposes. Prints the SongList.
     * @param songList    list of Songs
     */
    public void printData(SongList songList)
    {
        songList.sortBy("genre");
        for (Song song : songList)
        {
            System.out.println("Song Title: " + song.getTitle());
            System.out.println("Song Artist: " + song.getArtist());
            System.out.println("Song Genre " + song.getGenre());
            System.out.println("Song Year: " + song.getYear());
            System.out.println("Heard");
            System.out.println("reading:" + song.getByHobby(HobbyEnum.READ,
                "heard") + " art:" + song.getByHobby(HobbyEnum.ART, "heard") +
                " sports:" + song.getByHobby(HobbyEnum.SPORTS, "heard") +
                " music:" + song.getByHobby(HobbyEnum.MUSIC, "heard"));
            System.out.println("Likes");
            System.out.println("reading:" + song.getByHobby(HobbyEnum.READ,
                "liked") + " art:" + song.getByHobby(HobbyEnum.ART, "liked") +
                " sports:" + song.getByHobby(HobbyEnum.SPORTS, "liked") +
                " music:" + song.getByHobby(HobbyEnum.MUSIC, "liked"));
            System.out.println("");
        }
        
        songList.sortBy("title");
        for (Song song : songList)
        {
            System.out.println("Song Title: " + song.getTitle());
            System.out.println("Song Artist: " + song.getArtist());
            System.out.println("Song Genre " + song.getGenre());
            System.out.println("Song Year: " + song.getYear());
            System.out.println("Heard");
            System.out.println("reading:" + song.getByHobby(HobbyEnum.READ,
                "heard") + " art:" + song.getByHobby(HobbyEnum.ART, "heard") +
                " sports:" + song.getByHobby(HobbyEnum.SPORTS, "heard") +
                " music:" + song.getByHobby(HobbyEnum.MUSIC, "heard"));
            System.out.println("Likes");
            System.out.println("reading:" + song.getByHobby(HobbyEnum.READ,
                "liked") + " art:" + song.getByHobby(HobbyEnum.ART, "liked") +
                " sports:" + song.getByHobby(HobbyEnum.SPORTS, "liked") +
                " music:" + song.getByHobby(HobbyEnum.MUSIC, "liked"));
            System.out.println("");
        }
    }
}

