package fr.pompey.cda24060.tp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name="Users")
public class User {

    @Id
    @Column(name="idUsers")
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int idUsers;

    @Column(name="user_firstName")
    private String userFisrtName;

    @Column(name="user_lastName")
    private String userLastName;
}
