package com.example.springmongo.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "product")
public class Product {

    @MongoId
    private long id;

    //@Indexed(unique = true)
    String title;
    String description;
    String category;
    String imageURL;
    String price;
    private Map<String, String> attributes = new HashMap<String, String>();

    public Product(String title, String description, String category, String imageURL, String price) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.imageURL = imageURL;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public long getId() {
        return id;
    }
}
