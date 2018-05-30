package com.example.ewaew.tvgallery;

/**
 * Created by Ewa Lyko on 26.05.2018.
 */

public class Picture {
    private long id;
    private String title;
    private int image;


    public Picture(String title,int image)
    {
        this.title = title;
        this.image = image;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getImage()
    {
        return image;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
