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
    private Major major;
    private Region region;
    private Hobby hobby;
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
            this.major = Major.COMPUTER_SCIENCE;
            break;
        case ("Mat or CMDA"):
            this.major = Major.MATH_OR_CMDA;
            break;
        case ("Other Engineering"):
            this.major = Major.OTHER_ENGINEERING;
            break;
        default:
            this.major = Major.OTHER;
            break;
        }
    }

    public void setRegion(String region) {
        switch (region) {
        case ("Northeast"):
            this.region = Region.NORTHEAST;
            break;
        case ("Southeast"):
            this.region = Region.SOUTHEAST;
            break;
        case ("Outside of United States"):
            this.region = Region.OUTSIDE_US;
            break;
        default:
            this.region = Region.REST_OF_US;
            break;
        }
    }

    public void setHobby(String hobby) {
        switch (hobby) {
        case ("art"):
            this.hobby = Hobby.ART;
            break;
        case ("music"):
            this.hobby = Hobby.MUSIC;
            break;
        case ("sports"):
            this.hobby = Hobby.SPORTS;
            break;
        default:
            this.hobby = Hobby.READ;
            break;
        }
    }

    public Major getMajor() {
        return major;
    }

    public Region getRegion() {
        return region;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public String getCritiqueAt(int index) {
        return songCritique[index];
    }
}
