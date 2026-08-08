package com.mahesh.portfolio.model;

public class Project {

    private String title;
    private String description;
    private String technologies;
    private String image;
    private String githubLink;
    private String liveLink;

    public Project() {
    }

    public Project(
            String title,
            String description,
            String technologies,
            String image,
            String githubLink,
            String liveLink) {

        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.image = image;
        this.githubLink = githubLink;
        this.liveLink = liveLink;
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

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }
}