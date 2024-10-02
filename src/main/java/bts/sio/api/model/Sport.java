package bts.sio.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sport")
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;

    @Column(name="descriptif")
    private String descriptif;

    @ManyToOne
    @JoinColumn(name = "olympiade_id", nullable = false)
    private Olympiade olympiade;

    @OneToMany(mappedBy = "sport")
    private List<Athlete> athletes;

}
