package domain;

public class PublicationStatus {

    private final String id;
    private final String name;
    private final String comment;

    public PublicationStatus(String id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
