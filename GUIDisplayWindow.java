package prj5;

import java.awt.Color;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Displays the project.
 *
 * @author Sean McHugh (seanfmch)
 * @version Apr 15, 2016
 */
public class GUIDisplayWindow {
    
    private Window window;
    private SongList songList;
    
    private Button prev;
    private Button sortByArtist;
    private Button sortByTitle;
    private Button sortByYear;
    private Button next;
    private Button representHobby;
    private Button representMajor;
    private Button representRegion;
    private Button quit;
    
    private LinkedList<GUIGlyph> glyphList;
    
    /**
     * Instantiates field.
     * @param songs    SongList
     */
    public GUIDisplayWindow(SongList songs)
    {
        window = new Window("Project 5");
        songList = songs;
        
        prev = new Button("Previous");
        sortByArtist = new Button("Sort by Artist Name");
        sortByTitle = new Button("Sort by Song Title");
        sortByYear = new Button("Sort by Release Year");
        next = new Button("Next");
        representHobby = new Button("Represent Hobby");
        representMajor = new Button("Represent Major");
        representRegion = new Button("Represent Region");
        quit = new Button("Quit");
        
        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sortByArtist, WindowSide.NORTH);
        window.addButton(sortByTitle, WindowSide.NORTH);
        window.addButton(sortByYear, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(representHobby, WindowSide.SOUTH);
        window.addButton(representMajor, WindowSide.SOUTH);
        window.addButton(representRegion, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
        
        createLegend();
        testGlyph();
    }
    
    /**
     * Creates the legend. 
     */
    public void createLegend()
    {
        Shape border = new Shape(500, 120, 100, 150, Color.WHITE);
        border.setForegroundColor(Color.BLACK);
        
        TextShape legendTitle = new TextShape(502, 125, "Hobby Legend");
        legendTitle.setBackgroundColor(Color.WHITE);
        
        TextShape purple = new TextShape(502, 140, "Read");
        purple.setForegroundColor(Color.MAGENTA);
        purple.setBackgroundColor(Color.WHITE);
        
        TextShape blue = new TextShape(502, 155, "Art");
        blue.setForegroundColor(Color.BLUE);
        blue.setBackgroundColor(Color.WHITE);
        
        TextShape orange = new TextShape(502, 170, "Sports");
        orange.setForegroundColor(Color.ORANGE);
        orange.setBackgroundColor(Color.WHITE);
        
        TextShape green = new TextShape(502, 185, "Music");
        green.setForegroundColor(Color.GREEN);
        green.setBackgroundColor(Color.WHITE);
        
        TextShape songTitle = new TextShape(512, 210, "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);
        
        Shape separate = new Shape(550, 230, 4, 30, Color.BLACK);
        
        TextShape heard = new TextShape(502, 235, "Heard");
        heard.setBackgroundColor(Color.WHITE);
        
        TextShape likes = new TextShape(558, 235, "Likes");
        likes.setBackgroundColor(Color.WHITE);
        
        window.addShape(legendTitle);
        window.addShape(purple);
        window.addShape(blue);
        window.addShape(orange);
        window.addShape(green);
        window.addShape(songTitle);
        window.addShape(separate);
        window.addShape(heard);
        window.addShape(likes);
        window.addShape(border);
    }
    
    public void testGlyph()
    {
        TextShape songTitle = new TextShape(30, 10, "Hotel California");
        songTitle.setBackgroundColor(Color.WHITE);
        
        TextShape artist = new TextShape(30, 25, "by The Eagles");
        artist.setBackgroundColor(Color.WHITE);
        
        Shape separator = new Shape(80, 40, 4, 40, Color.BLACK);
        
        Shape purple = new Shape(60, 43, 70, 8, Color.MAGENTA);
        
        Shape blue = new Shape(58, 51, 70, 8, Color.BLUE);
        
        Shape orange = new Shape(53, 59, 80, 8, Color.ORANGE);
        
        Shape green = new Shape(60, 67, 70, 8, Color.GREEN);
        
        
        window.addShape(songTitle);
        window.addShape(artist);
        window.addShape(separator);
        window.addShape(purple);
        window.addShape(blue);
        window.addShape(orange);
        window.addShape(green);
    }
        
        
   
    
    

}
