package com.example.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class PetDto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4676905652686424400L;

    @JsonProperty("id")
    private String id;

    private String name;

    private String status;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    private Date dateCreated;

    private String transactionId;

    public PetDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Pet id =");
        sb.append(id+", name =");
        sb.append(name+", status =");
        sb.append(status+", transactionId =");
        sb.append(transactionId+", dateCreated =");
        sb.append(dateCreated);

        return sb.toString();
    }
}
