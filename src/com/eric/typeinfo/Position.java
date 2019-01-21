package com.eric.typeinfo;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/18/2019 5:21 PM
 */
public class Position {
    private String title;
    private Person person;

    public Position(String jobTitle, Person employee) {
        this.title = jobTitle;
        this.person = employee;
        if (person == null)
            this.person = Person.Null;
    }

    public Position(String jobTitle) {
        this.title = jobTitle;
        person = Person.Null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        this.person = newPerson;
        if (person == null)
            this.person = Person.Null;
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }
}
