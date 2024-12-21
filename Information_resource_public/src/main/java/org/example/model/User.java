package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    private Integer id;
    private String phoneNumber;
    private String avatar;
    private String password;

    private String name;
    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setAvatar(String avatarAddress)
    {
        this.avatar=avatarAddress;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}

