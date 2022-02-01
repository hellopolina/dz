package org.example.autotests_backend;

import java.io.IOException;

public class UserBuilder {

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String birthday;

    public UserBuilder() throws IOException {
    }

    public UserBuilder setName(String name) throws IOException {
        this.name = name;
        return this;
    }

    public UserBuilder setSurname(String name) {
        this.surname = surname;
        return this;
    }

    public UserBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    User user1 = new UserBuilder()
            .setName("Ivan")
            .setSurname("Ivanon")
            .build();

    public User build() {
        User user = new User();
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setName(name);
        user.setPhone(phone);
        user.setSurname(surname);
        return user;
    }

}
