package web.model;

import javax.persistence.*;

@Entity
@Table(name= "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String surname;
    @Column
    private int age;
    @Column
    private String name;

    public User(String surname, int age, String name) {
        this.surname = surname;
        this.age = age;
        this.name = name;
    }
    public User(){}

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "surname='" + surname + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }
}
