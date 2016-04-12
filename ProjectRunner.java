package songvisualizer;

/**
 * ProjectRunner runs the program by calling QueueReader
 * 
 * @author Matthew Fishman <feesh96>
 * 
 * @version 2016.04.12
 */
public class ProjectRunner {

    /**
     * main method to start the program with the given String argument
     * 
     * @param args
     *            the String version of the queue
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            new FileReader(args[0], args[1]);
        }
        else {
            new FileReader("SongList.txt", "MusicSurvey.txt");
        }
    }
}
