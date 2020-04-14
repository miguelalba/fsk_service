package domain;

public class PublicationType {

    private final String id;
    private final String shortName;
    private final String fullName;
 
    public PublicationType(String id, String shortName, String fullName) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }
}