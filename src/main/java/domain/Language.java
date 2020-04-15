package domain;

public class Language {

    /** ISO 639-1 two-letter code. */
    private final String code;

    private final String name;
    private final String comment;

    public Language(String code, String name, String comment) {
        this.code = code;
        this.name = name;
        this.comment = comment;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
