package songvisualizer;

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
    private String songCritique[];

    public Person(String major, String region, String hobby,
            String[] songCritique) {
        setMajor(major);
        setRegion(region);
        setHobby(hobby);
        this.songCritique = songCritique;
    }

    public void setMajor(String major) {
        switch (major) {
        case ("Computer Science"):
            this.major = MajorEnum.COMPUTER_SCIENCE;
            break;
        case ("Mat or CMDA"):
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

    public void setRegion(String region) {
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

    public void setHobby(String hobby) {
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

    public MajorEnum getMajor() {
        return major;
    }

    public RegionEnum getRegion() {
        return region;
    }

    public HobbyEnum getHobby() {
        return hobby;
    }

    public String getCritiqueAt(int index) {
        return songCritique[index];
    }
}
