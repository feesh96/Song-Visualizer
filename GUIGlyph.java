package prj5;

import CS2114.Window;

import java.awt.Color;

import CS2114.Shape;
import CS2114.TextShape;

/**
 * Glyph class adds shapes to window takes input window, song, how to represent
 * song, x and y coordinates creates glyph using x, y, representation and song
 * data places glyph shapes directly on window
 *
 * @author Mostafa Elemary <melemary>
 * @version Apr 27, 2016
 */
public class GUIGlyph {

    private Song song;
    private Window window;
    private String representBy;

    private TextShape title;
    private TextShape sortBy;
    private Shape separator;
    private Shape purpleHeard;
    private Shape purpleLiked;
    private Shape blueHeard;
    private Shape blueLiked;
    private Shape yellowHeard;
    private Shape yellowLiked;
    private Shape greenHeard;
    private Shape greenLiked;

    private int xPos;
    private int yPos;

    private static final int BAR_HEIGHT = 10;


    /**
     * Glyph default constructor uses helper method to get data based on the
     * representBy param creates shapes and separators based on data of song and
     * places on window
     * 
     * @param inWindow
     *            window with shapes being added
     * @param inSong
     *            song being looked at
     * @param inRepresentBy
     *            way data will be represented
     * @param inXPos
     *            x position (manipulated in window class with for loop)
     * @param inYPos
     *            y position (also manipulated in window class)
     */
    public GUIGlyph(Window inWindow, Song inSong, String inRepresentBy,
            int inXPos, int inYPos) {
        window = inWindow;
        song = inSong;
        representBy = inRepresentBy;

        xPos = inXPos;
        yPos = inYPos;

        title = new TextShape(xPos + 108, yPos + 10, song.getTitle());
        title.setX(xPos + 108 - title.getWidth() / 2);

        sortBy = new TextShape(xPos + 108, yPos + 30, "by " + song.getArtist());
        sortBy.setX(xPos + 108 - sortBy.getWidth() / 2);

        separator = new Shape(xPos + 108, yPos + 50, BAR_HEIGHT,
                4 * BAR_HEIGHT);
        separator.setBackgroundColor(Color.black);

        if (representBy.equals("Hobby")) {
            setBarsByHobby();
        }
        else if (representBy.equals("Region")) {
            setBarsByRegion();
        }
        else {
            setBarsByMajor();
        }

        purpleHeard.setBackgroundColor(Color.magenta);
        purpleLiked.setBackgroundColor(Color.magenta);
        blueHeard.setBackgroundColor(Color.blue);
        blueLiked.setBackgroundColor(Color.blue);
        yellowHeard.setBackgroundColor(Color.yellow);
        yellowLiked.setBackgroundColor(Color.yellow);
        greenLiked.setBackgroundColor(Color.green);
        greenHeard.setBackgroundColor(Color.green);
        sortBy.setBackgroundColor(Color.white);
        title.setBackgroundColor(Color.white);

        window.addShape(separator);
        window.addShape(sortBy);
        window.addShape(purpleHeard);
        window.addShape(purpleLiked);
        window.addShape(blueHeard);
        window.addShape(blueLiked);
        window.addShape(yellowHeard);
        window.addShape(yellowLiked);
        window.addShape(greenLiked);
        window.addShape(greenHeard);
        window.addShape(title);
    }

    /**
     * Representation Helper Method
     * 
     * @param representBy
     *            input switch for how to represent bars
     */
    public void setBarsBy(String representBy) {
        switch (representBy) {
            case ("Hobby"):
                setBarsByHobby();
                break;
            case ("Region"):
                setBarsByRegion();
                break;
            case ("Major"):
                setBarsByMajor();
                break;
        }
    }

    /**
     * Major bar setter method Sets data of bars (how long they are) based on
     * data given from song class
     * Places bars correctly on either side of the separator
     */
    public void setBarsByMajor() {
        purpleHeard = new Shape(xPos, yPos + 50,
                song.getByMajor(MajorEnum.COMPUTER_SCIENCE, "heard"),
                BAR_HEIGHT);

        purpleLiked = new Shape(xPos + separator.getWidth() + 108, yPos + 50,
                song.getByMajor(MajorEnum.COMPUTER_SCIENCE, "liked"),
                BAR_HEIGHT);

        blueHeard = new Shape(xPos, yPos + 50 + BAR_HEIGHT,
                song.getByMajor(MajorEnum.OTHER_ENGINEERING, "heard"),
                BAR_HEIGHT);

        blueLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + BAR_HEIGHT,
                song.getByMajor(MajorEnum.OTHER_ENGINEERING, "liked"),
                BAR_HEIGHT);

        yellowHeard = new Shape(xPos, yPos + 50 + 2 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.MATH_OR_CMDA, "heard"), BAR_HEIGHT);

        yellowLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + 2 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.MATH_OR_CMDA, "liked"), BAR_HEIGHT);

        greenHeard = new Shape(xPos, yPos + 50 + 3 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.OTHER, "heard"), BAR_HEIGHT);

        greenLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + 3 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.OTHER, "liked"), BAR_HEIGHT);

        purpleHeard.setX(xPos + 108 - purpleHeard.getWidth());
        blueHeard.setX(xPos + 108 - blueHeard.getWidth());
        yellowHeard.setX(xPos + 108 - yellowHeard.getWidth());
        greenHeard.setX(xPos + 108 - greenHeard.getWidth());
    }

    /**
     * Hobby bar setter method sets data of bars (how long they are) based on
     * data given from song class on hobbies of survey responders
     * Places bars correctly on either side of the separator
     */
    public void setBarsByHobby() {
        purpleHeard = new Shape(xPos, yPos + 50,
                song.getByHobby(HobbyEnum.READ, "heard"), BAR_HEIGHT);

        purpleLiked = new Shape(xPos + 108 + separator.getWidth(), yPos + 50,
                song.getByHobby(HobbyEnum.READ, "liked"), BAR_HEIGHT);

        blueHeard = new Shape(xPos, yPos + 50 + BAR_HEIGHT,
                song.getByHobby(HobbyEnum.ART, "heard"), BAR_HEIGHT);

        blueLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + BAR_HEIGHT, song.getByHobby(HobbyEnum.ART, "liked"),
                BAR_HEIGHT);

        yellowHeard = new Shape(xPos, yPos + 50 + 2 * BAR_HEIGHT,
                song.getByHobby(HobbyEnum.SPORTS, "heard"), BAR_HEIGHT);

        yellowLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + 2 * BAR_HEIGHT,
                song.getByHobby(HobbyEnum.SPORTS, "liked"), BAR_HEIGHT);

        greenHeard = new Shape(xPos, yPos + 50 + 3 * BAR_HEIGHT,
                song.getByHobby(HobbyEnum.MUSIC, "heard"), BAR_HEIGHT);

        greenLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + 3 * BAR_HEIGHT,
                song.getByHobby(HobbyEnum.MUSIC, "liked"), BAR_HEIGHT);

        purpleHeard.setX(xPos + 108 - purpleHeard.getWidth());
        blueHeard.setX(xPos + 108 - blueHeard.getWidth());
        yellowHeard.setX(xPos + 108 - yellowHeard.getWidth());
        greenHeard.setX(xPos + 108 - greenHeard.getWidth());
    }

    /**
     * Region bar setter method sets data of bars (how long they are) based on
     * data given from song class based on region of survey responders
     * Places bars correctly on either side of the separator
     */
    public void setBarsByRegion() {
        purpleHeard = new Shape(xPos, yPos + 50,
                song.getByRegion(RegionEnum.NORTHEAST, "heard"), BAR_HEIGHT);

        purpleHeard.setX(xPos + 108 - purpleHeard.getWidth());

        purpleLiked = new Shape(xPos + 108 + separator.getWidth(), yPos + 50,
                song.getByRegion(RegionEnum.NORTHEAST, "liked"), BAR_HEIGHT);

        blueHeard = new Shape(xPos, yPos + 50 + BAR_HEIGHT,
                song.getByRegion(RegionEnum.SOUTHEAST, "heard"), BAR_HEIGHT);

        blueHeard.setX(xPos + 108 - blueHeard.getWidth());

        blueLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + BAR_HEIGHT,
                song.getByRegion(RegionEnum.SOUTHEAST, "liked"), BAR_HEIGHT);

        yellowHeard = new Shape(xPos, yPos + 50 + 2 * BAR_HEIGHT,
                song.getByRegion(RegionEnum.REST_OF_US, "heard"), BAR_HEIGHT);

        yellowHeard.setX(xPos + 108 - yellowHeard.getWidth());

        yellowLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + 2 * BAR_HEIGHT,
                song.getByRegion(RegionEnum.REST_OF_US, "liked"), BAR_HEIGHT);

        greenHeard = new Shape(xPos, yPos + 50 + 3 * BAR_HEIGHT,
                song.getByRegion(RegionEnum.OUTSIDE_US, "heard"), BAR_HEIGHT);

        greenHeard.setX(xPos + 108 - greenHeard.getWidth());

        greenLiked = new Shape(xPos + 108 + separator.getWidth(),
                yPos + 50 + 3 * BAR_HEIGHT,
                song.getByRegion(RegionEnum.OUTSIDE_US, "liked"), BAR_HEIGHT);
    }

    /**
     * Changes text under title based on what is being represented
     * @param inSortBy what is being represented
     */
    public void setSortBy(String inSortBy) {
        if (inSortBy.equals("Year")) {
            sortBy.setText(song.getYear());
        }
        else if (inSortBy.equals("Genre")) {
            sortBy.setText("genre: " + song.getGenre());
        }
        else {
            sortBy.setText("by " + song.getArtist());
        }
        sortBy.setX(xPos + 108 - sortBy.getWidth() / 2);
    }
}
