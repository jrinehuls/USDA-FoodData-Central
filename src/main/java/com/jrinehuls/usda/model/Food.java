package com.jrinehuls.usda.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Food {

    private Long fdcId;
    private String footnote;
    private String description;
    private String publicationDate;
    /* Do someday
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private LocalDate publicationDate;
    */
    private String dataType;
    private String foodClass;
    private String scientificName;
    private Integer ndbNumber; // maybe Long
    private Boolean isHistoricalReference;

    public Food() {

    }

    public Long getFdcId() {
        return fdcId;
    }

    public void setFdcId(Long fdcId) {
        this.fdcId = fdcId;
    }

    public String getFootnote() {
        return footnote;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getFoodClass() {
        return foodClass;
    }

    public void setFoodClass(String foodClass) {
        this.foodClass = foodClass;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public Integer getNdbNumber() {
        return ndbNumber;
    }

    public void setNdbNumber(Integer ndbNumber) {
        this.ndbNumber = ndbNumber;
    }

    public Boolean getHistoricalReference() {
        return isHistoricalReference;
    }

    public void setHistoricalReference(Boolean historicalReference) {
        isHistoricalReference = historicalReference;
    }
}
