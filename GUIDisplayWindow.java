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
    private Button sortByGenre;
    private Button next;
    private Button representHobby;
    private Button representMajor;
    private Button representRegion;
    private Button quit;

    private String globalRepresentBy;
    private String globalSortBy;
    
    private int pageNum;

    /**
     * Instantiates field.
     * 
     * @param songs
     *            SongList
     */
    public GUIDisplayWindow(SongList songs) {
        window = new Window("Project 5");
        window.setSize(800, 400);
        songList = songs;

        prev = new Button("Previous");
        sortByArtist = new Button("Sort by Artist Name");
        sortByTitle = new Button("Sort by Song Title");
        sortByYear = new Button("Sort by Release Year");
        sortByGenre = new Button("Sort by Genre");
        next = new Button("Next");
        representHobby = new Button("Represent Hobby");
        representMajor = new Button("Represent Major");
        representRegion = new Button("Represent Region");
        quit = new Button("Quit");

        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sortByArtist, WindowSide.NORTH);
        window.addButton(sortByTitle, WindowSide.NORTH);
        window.addButton(sortByYear, WindowSide.NORTH);
        window.addButton(sortByGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(representHobby, WindowSide.SOUTH);
        window.addButton(representMajor, WindowSide.SOUTH);
        window.addButton(representRegion, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
        
        pageNum = 0;
        globalSortBy = "Title";
        prev.disable();
        
        prev.onClick(this, "clickedPrev");
        sortByArtist.onClick(this, "clickedArtist");
        sortByTitle.onClick(this, "clickedTitle");
        sortByYear.onClick(this, "clickedYear");
        sortByGenre.onClick(this, "clickedGenre");
        next.onClick(this, "clickedNext");
        representHobby.onClick(this, "clickedHobby");
        representMajor.onClick(this, "clickedMajor");
        representRegion.onClick(this, "clickedRegion");
        quit.onClick(this, "clickedQuit");
    }

    /**
     * Creates the legend.
     */
    public void createLegend(String representBy) {
        Shape border = new Shape(650, 100, 100, 150, Color.WHITE);
        border.setForegroundColor(Color.BLACK);

        TextShape legendTitle = new TextShape(652, 105, "Hobby Legend");
        legendTitle.setBackgroundColor(Color.WHITE);

        TextShape songTitle = new TextShape(668, 190, "Song Title");
        songTitle.setBackgroundColor(Color.WHITE);

        Shape separate = new Shape(700, 210, 4, 30, Color.BLACK);

        TextShape heard = new TextShape(652, 215, "Heard");
        heard.setBackgroundColor(Color.WHITE);

        TextShape likes = new TextShape(708, 215, "Likes");
        likes.setBackgroundColor(Color.WHITE);
        
        TextShape purple, blue, orange, green;
        
        if (representBy == "Hobby") {
            purple = new TextShape(652, 120, "Read");
            purple.setForegroundColor(Color.MAGENTA);
            purple.setBackgroundColor(Color.WHITE);
    
            blue = new TextShape(652, 135, "Art");
            blue.setForegroundColor(Color.BLUE);
            blue.setBackgroundColor(Color.WHITE);
    
            orange = new TextShape(652, 150, "Sports");
            orange.setForegroundColor(Color.ORANGE);
            orange.setBackgroundColor(Color.WHITE);
    
            green = new TextShape(652, 165, "Music");
            green.setForegroundColor(Color.GREEN);
            green.setBackgroundColor(Color.WHITE);
        }
        else if (representBy == "Major")
        {
            purple = new TextShape(652, 120, "Comp Sci");
            purple.setForegroundColor(Color.MAGENTA);
            purple.setBackgroundColor(Color.WHITE);

            blue = new TextShape(652, 135, "Other Eng");
            blue.setForegroundColor(Color.BLUE);
            blue.setBackgroundColor(Color.WHITE);

            orange = new TextShape(652, 150, "Math/CMDA");
            orange.setForegroundColor(Color.ORANGE);
            orange.setBackgroundColor(Color.WHITE);

            green = new TextShape(652, 165, "Other");
            green.setForegroundColor(Color.GREEN);
            green.setBackgroundColor(Color.WHITE);
        }
        else
        {
            purple = new TextShape(652, 120, "Northeast");
            purple.setForegroundColor(Color.MAGENTA);
            purple.setBackgroundColor(Color.WHITE);

            blue = new TextShape(652, 135, "Southeast");
            blue.setForegroundColor(Color.BLUE);
            blue.setBackgroundColor(Color.WHITE);

            orange = new TextShape(652, 150, "Rest of US");
            orange.setForegroundColor(Color.ORANGE);
            orange.setBackgroundColor(Color.WHITE);

            green = new TextShape(652, 165, "Outside of US");
            green.setForegroundColor(Color.GREEN);
            green.setBackgroundColor(Color.WHITE);
        }

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

    /*
    public void testGlyph() {
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
    */
    
    public void clickedHobby(Button button) {
        globalRepresentBy = "Hobby";
        updateGlyphList(globalRepresentBy, globalSortBy);
    }
    
    public void clickedMajor(Button button) {
        globalRepresentBy = "Major";
        updateGlyphList(globalRepresentBy, globalSortBy);
    }
    
    public void clickedRegion(Button button) {
        globalRepresentBy = "Region";
        updateGlyphList(globalRepresentBy, globalSortBy);
    }
    
    public void updateGlyphList(String representBy, String sortBy) {
        window.removeAllShapes();
        createLegend(representBy);
        
        int x = 10;
        int y = 0;
        
        for (int i = pageNum * 6; i < pageNum * 6 + 6; i++) {
            Song song = songList.getSong(i);

            GUIGlyph temp = new GUIGlyph(window, song, representBy, x, y);
            temp.setSortBy(sortBy);
            if (x == 440)
            {
                y = 125;
                x = 10;
            }
            else {
                x += 215;
            }
        }
        
        if (pageNum == 0) {
            prev.disable();
        }
        else {
            prev.enable();
        }
        
        if (Math.ceil(songList.size()/6) - 1 == pageNum) {
            next.disable();
        }
        else {
            next.enable();
        }
    }
    
    public void clickedArtist(Button button) {
        songList.sortBy("Artist");
        globalSortBy = "Artist";
        updateGlyphList(globalRepresentBy, globalSortBy);
    }
    
    public void clickedTitle(Button button) {
        songList.sortBy("Title");
        globalSortBy = "Title";
        updateGlyphList(globalRepresentBy, globalSortBy);
    }
    
    public void clickedGenre(Button button) {
        songList.sortBy("Genre");
        globalSortBy = "Genre";
        updateGlyphList(globalRepresentBy, globalSortBy);
        
    }
    
    public void clickedYear(Button button) {
        songList.sortBy("Year");
        globalSortBy = "Year";
        updateGlyphList(globalRepresentBy, globalSortBy);
    }
    
    public void clickedNext(Button button) {
        pageNum++;
        updateGlyphList(globalRepresentBy, globalSortBy);
    }
    
    public void clickedPrev(Button button) {
        pageNum--;
        updateGlyphList(globalRepresentBy, globalSortBy);
    }
    
    public void clickedQuit(Button button) {
        System.exit(0);
    }
}

