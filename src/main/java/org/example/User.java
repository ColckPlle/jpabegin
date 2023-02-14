package org.example;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "User")
public class User {
    @Id
    private String email;
    private String name;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    protected User(){

    }

    public User(String email, String name, LocalDateTime createDate){
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
