package org.example;
import org.hibernate.annotations.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "User")
public class jpaUser {
    @Id
    private String email;
    private String name;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    protected jpaUser(){

    }

    public jpaUser(String email, String name, LocalDateTime createDate){
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }
}
