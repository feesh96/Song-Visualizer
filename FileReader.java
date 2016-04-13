package songvisualizer;

import java.io.File;
import java.util.Scanner;

public class FileReader {
    
    public FileReader(String songFile, String personFile)
    {
        LinkedList<Song> songs = readData(songFile, personFile);
        SongList newSongList = new SongList(songs);
        Window window = new Window(newSongList);
    }

    
    public LinkedList<Song> readData(String songFile, String personFile) {
        try {
            Scanner songScanner = new Scanner(new File(songFile));
            Scanner personScanner = new Scanner(new File(personFile));
            
            LinkedList<Person> personList = new LinkedList<Person>();
            LinkedList<Song> songList = new LinkedList<Song>();
            
            while (personScanner.hasNextLine()) {
                personScanner.nextLine();
                
                String[] input = personScanner.nextLine().split(",");
                
                String major = input[2];
                String region = input[3];
                String hobby = input[4];
                String[] critique = new String[input.length - 5];
                
                for (int i = 5; i < input.length; i++)
                {
                    critique[i] = input[i];
                }
                
                Person temp = new Person(major, region, hobby, critique);
                personList.add(temp);
            }
            personScanner.close();
            
            int i = 0;
            while (songScanner.hasNextLine())
            {
                songScanner.nextLine();
                
                String[] input = songScanner.nextLine().split(",");
                
                String title = input[0];
                String artist = input[1];
                String year = input[2];
                String genre = input[3];
                
                Song temp = new Song(title, genre, artist, year, personList, i);
                songList.add(temp);
                i++;
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
}

