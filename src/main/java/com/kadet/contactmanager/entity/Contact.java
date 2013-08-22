package com.kadet.contactmanager.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;

import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 20.08.13
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Entity
@Table(name = "contact")
public class Contact implements com.kadet.contactmanager.entity.Entity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private int version;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private DateTime birthDate;

    @Column(name = "description")
    private String description;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "photo")
    private byte[] photo;


    public void setId (Long id) {
        this.id = id;
    }

    public Long getId () {
        return id;
    }

    public int getVersion () {
        return version;
    }

    public void setVersion (int version) {
        this.version = version;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public DateTime getBirthDate () {
        return birthDate;
    }

    public void setBirthDate (DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public byte[] getPhoto () {
        return photo;
    }

    public void setPhoto (byte[] photo) {
        this.photo = photo;
    }

    @Transient
    public String getBirthDateString () {
        String birthDateString = "";
        if (birthDate != null) {
            birthDateString =
                    org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd").print(birthDate);
        }
        return birthDateString;
    }

    @Override
    public String toString () {
        return "Contact - " +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", description='" + description + '\'' +
                ';';
    }
}
