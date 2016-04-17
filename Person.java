package prj5;

/**
 * Person class holds each person's major, region, and hobby. It also holds a
 * String array for this person's song critique.
 * 
 * @author Matthew Fishman <feesh96>
 *
 * @version 2016.04.12
 */
public class Person {
    private MajorEnum major;
    private RegionEnum region;
    private HobbyEnum hobby;
    private String[] songCritique;

    /**
     * Sets a Person's attributes and assigns it a songCritique array.
     * @param major    their major
     * @param region    their region
     * @param hobby    their hobby
     * @param songCritique    their String[] of song critiques (Yes/No)
     */
    public Person(String major, String region, String hobby,
            String[] songCritique) {
        setMajor(major);
        setRegion(region);
        setHobby(hobby);
        this.songCritique = songCritique;
    }

    /**
     * Sets their major to its proper MajorEnum.
     * @param major    major to set to
     */
    private void setMajor(String major) {
        switch (major) {
            case ("Computer Science"):
                this.major = MajorEnum.COMPUTER_SCIENCE;
                break;
            case ("Math or CMDA"):
                this.major = MajorEnum.MATH_OR_CMDA;
                break;
            case ("Other Engineering"):
                this.major = MajorEnum.OTHER_ENGINEERING;
                break;
            default:
                this.major = MajorEnum.OTHER;
                break;
        }
    }

    /**
     * Sets their region to its proper RegionEnum.
     * @param region    their region
     */
    private void setRegion(String region) {
        switch (region) {
            case ("Northeast"):
                this.region = RegionEnum.NORTHEAST;
                break;
            case ("Southeast"):
                this.region = RegionEnum.SOUTHEAST;
                break;
            case ("Outside of United States"):
                this.region = RegionEnum.OUTSIDE_US;
                break;
            default:
                this.region = RegionEnum.REST_OF_US;
                break;
        }
    }

    /**
     * Sets their hobby to its proper HobbyEnum.
     * @param hobby    their hobby
     */
    private void setHobby(String hobby) {
        switch (hobby) {
            case ("art"):
                this.hobby = HobbyEnum.ART;
                break;
            case ("music"):
                this.hobby = HobbyEnum.MUSIC;
                break;
            case ("sports"):
                this.hobby = HobbyEnum.SPORTS;
                break;
            default:
                this.hobby = HobbyEnum.READ;
                break;
        }
    }

    /**
     * Gets their MajorEnum.
     * @return major
     */
    public MajorEnum getMajor() {
        return major;
    }

    /**
     * Gets their RegionEnum.
     * @return region
     */
    public RegionEnum getRegion() {
        return region;
    }

    /**
     * Gets their HobbyEnum.
     * @return hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }

    /**
     * Gets the song critique at index specified. 
     * @param index    index to look at
     * @return Yes or No
     */
    public String getCritiqueAt(int index) {
        if (index < songCritique.length)
        {
            return songCritique[index];
        }
        else
        {
            return "Out of bounds";
        }
    }
}
