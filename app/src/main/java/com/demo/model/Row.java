package com.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vijayaraj_s on 26/03/18.
 */

public class Row {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("imageHref")
    @Expose
    private String imageHref;

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return set title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return set description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return image url
     */
    public String getImageHref() {
        return imageHref;
    }

    /**
     * @return set image url
     */
    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }
}
