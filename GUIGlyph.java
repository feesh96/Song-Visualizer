package prj5;

import CS2114.Window;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * Describe your class.
 *
 * @author Sean McHugh (seanfmch)
 * @version Apr 15, 2016
 */
public class GUIGlyph {
    
    private Song song;
    private Window window;
    private String representBy;
    
    private TextShape title;
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
   

    public GUIGlyph(Window inWindow, Song inSong, String inRepresentBy,
                 int inXPos, int inYPos)
    {
        inWindow = new Window();
        song = inSong;
        representBy = inRepresentBy;
        
        xPos = inXPos;
        yPos = inYPos;
        
        title = new TextShape(xPos, yPos, song.getTitle());
        
        separator = new Shape(xPos, yPos + 10, 4 * BAR_HEIGHT);
                        
        if (representBy.equals("hobby"))
        {
            setBarsByHobby();
        }
        if (representBy.equals("region"))
        {
            setBarsByRegion();
        }
        else
        {
            setBarsByMajor();
        }
        
        window.addShape(purpleHeard);
        window.addShape(purpleLiked);
        window.addShape(blueHeard);
        window.addShape(blueLiked);
        window.addShape(yellowHeard);
        window.addShape(yellowLiked);
        window.addShape(greenLiked);
        window.addShape(greenHeard);
    }
    
    public void setBarsByMajor()
    {
        purpleHeard = new Shape(xPos, yPos + BAR_HEIGHT,
                         song.getByMajor(MajorEnum.COMPUTER_SCIENCE, "heard"));
        
        purpleLiked = new Shape(xPos, yPos + BAR_HEIGHT,
                  song.getByMajor(MajorEnum.COMPUTER_SCIENCE, "liked"));
        
        blueHeard = new Shape(xPos, yPos + 2 * BAR_HEIGHT,
                  song.getByMajor(MajorEnum.OTHER_ENGINEERING, "heard"));
        
        blueLiked = new Shape(xPos, yPos + 2 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.OTHER_ENGINEERING, "liked"));
        
        yellowHeard = new Shape(xPos, yPos + 3 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.MATH_OR_CMDA, "heard"));
        
        yellowLiked = new Shape(xPos, yPos + 3 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.MATH_OR_CMDA, "liked"));
        
        greenHeard = new Shape(xPos, yPos + 4 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.OTHER, "heard"));
        
        greenLiked = new Shape(xPos, yPos + 4 * BAR_HEIGHT,
                song.getByMajor(MajorEnum.OTHER, "liked"));
    }
    
    public void setBarsByHobby()
    {
        purpleHeard = new Shape(xPos, yPos + BAR_HEIGHT,
                song.getByHobby(HobbyEnum.READ, "heard"));

        purpleLiked = new Shape(xPos, yPos + BAR_HEIGHT,
                 song.getByHobby(HobbyEnum.READ, "liked"));
        
        blueHeard = new Shape(xPos, yPos + 2 * BAR_HEIGHT,
                 song.getByHobby(HobbyEnum.ART, "heard"));
        
        blueLiked = new Shape(xPos, yPos + 2 * BAR_HEIGHT,
               song.getByHobby(HobbyEnum.ART, "liked"));
        
        yellowHeard = new Shape(xPos, yPos + 3 * BAR_HEIGHT,
               song.getByHobby(HobbyEnum.SPORTS, "heard"));
        
        yellowLiked = new Shape(xPos, yPos + 3 * BAR_HEIGHT,
               song.getByHobby(HobbyEnum.SPORTS, "liked"));
        
        greenHeard = new Shape(xPos, yPos + 4 * BAR_HEIGHT,
               song.getByHobby(HobbyEnum.MUSIC, "heard"));
        
        greenLiked = new Shape(xPos, yPos + 4 * BAR_HEIGHT,
               song.getByHobby(HobbyEnum.MUSIC, "liked"));
    }
    
    public void setBarsByRegion()
    {
        purpleHeard = new Shape(xPos, yPos + BAR_HEIGHT,
                song.getByRegion(RegionEnum.NORTHEAST, "heard"));

        purpleLiked = new Shape(xPos, yPos + BAR_HEIGHT,
                 song.getByRegion(RegionEnum.NORTHEAST, "liked"));
        
        blueHeard = new Shape(xPos, yPos + 2 * BAR_HEIGHT,
                 song.getByRegion(RegionEnum.SOUTHEAST, "heard"));
        
        blueLiked = new Shape(xPos, yPos + 2 * BAR_HEIGHT,
               song.getByRegion(RegionEnum.SOUTHEAST, "liked"));
        
        yellowHeard = new Shape(xPos, yPos + 3 * BAR_HEIGHT,
               song.getByRegion(RegionEnum.REST_OF_US, "heard"));
        
        yellowLiked = new Shape(xPos, yPos + 3 * BAR_HEIGHT,
               song.getByRegion(RegionEnum.REST_OF_US, "liked"));
        
        greenHeard = new Shape(xPos, yPos + 4 * BAR_HEIGHT,
               song.getByRegion(RegionEnum.OUTSIDE_US, "heard"));
        
        greenLiked = new Shape(xPos, yPos + 4 * BAR_HEIGHT,
               song.getByRegion(RegionEnum.OUTSIDE_US, "liked"));
    }
    
    

}