package com.rechenggit.core.dal.mongodbobject;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="t_customer")
public class Customer {

    private String id;
    private String carNumber;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
