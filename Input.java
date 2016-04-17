package prj5;

/**
 * ProjectRunner runs the program by calling QueueReader
 * 
 * @author Matthew Fishman <feesh96>
 * 
 * @version 2016.04.12
 */
public class Input {

    /**
     * main method to start the program with the given String argument
     * 
     * @param args
     *            the String version of the queue
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            new GUIFileReader(args[0], args[1]);
        }
        else {
            new GUIFileReader("SongList.csv", "MusicSurvey.csv");
        }
    }
}
