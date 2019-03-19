package com.epam.learning.handson.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


/**
 * Created by savithasendhil on 3/8/19.
 */
public class Employee {
    @Id
    public ObjectId _id;

    public String name;
    public String title;

    public Employee(ObjectId _id, String name, String title, String createTimeStamp) {
        this._id = _id;
        this.name = name;
        this.title = title;
        this.createTimeStamp = createTimeStamp;
    }

    public String getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(String createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public String createTimeStamp;


    public Employee() {
    }




    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
