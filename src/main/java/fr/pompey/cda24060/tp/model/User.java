package fr.pompey.cda24060.tp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="id_users")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsers;

    @Column(name="user_first_name")
    private String userFisrtName;

    @Column(name="user_last_name")
    private String userLastName;
}
