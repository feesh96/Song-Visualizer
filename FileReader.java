package songvisualizer;

import java.io.File;
import java.util.Scanner;

public class FileReader {

    
    public SongList readData(String songFile, String personFile) {
        try {
            Scanner songScanner = new Scanner(new File(songFile));
            Scanner personScanner = new Scanner(new File(personFile));
            
            Scanner personCounter = new Scanner(new File(personFile));
            int numberPeople = 0;
            while (personCounter.hasNextLine())
            {
                personCounter.nextLine();
                numberPeople++;
            }
            
            Scanner songCounter = new Scanner (new File (songFile));
            int numberSong = 0;
            while (songCounter.hasNextLine())
            {
                songCounter.nextLine();
                numberSong++;
            }
            
            Person[] personArray = new Person[numberPeople];
            Song[] songArray = new Song[numberSong];
            
            int i = 0;
            while (personScanner.hasNextLine()) {
                personScanner.nextLine();
                personScanner.next();
                personScanner.next();
                
                String major = personScanner.next();
                String region = personScanner.next();
                String hobby = personScanner.next();
                
                int j = 0;
                String[] critique = new String[2*numberSong];
                while (personScanner.hasNext())
                {
                    critique[j] = personScanner.next();
                    j++;
                }
                
                Person temp = new Person(major, region, hobby, critique);
                personArray[i] = temp;
                i++;
                
            }
            personScanner.close();
            
            i = 0;
            while (songScanner.hasNextLine())
            {
                songScanner.nextLine();
                String title = songScanner.next();
                String artist = songScanner.next();
                String year = songScanner.next();
                String genre = songScanner.next();
                
                Song temp = new Song(title, artist, year, genre);
                songArray[i] = temp;
                i++;
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
        return SongList(personArray, songArray);
    }
}
}
