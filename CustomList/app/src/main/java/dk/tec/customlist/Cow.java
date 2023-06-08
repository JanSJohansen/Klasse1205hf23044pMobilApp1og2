package dk.tec.customlist;

public class Cow {
    String title;
    String description;
    int pictureId;

    public Cow(String title, String description, int pictureId) {
        this.title = title;
        this.description = description;
        this.pictureId = pictureId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPictureId() {
        return pictureId;
    }
}
