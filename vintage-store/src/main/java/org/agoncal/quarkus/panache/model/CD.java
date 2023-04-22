package org.agoncal.quarkus.panache.model;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_cds")
public class CD extends Item {
    @Column(name = "music_company")
    public String musicCompany;
    @Column(length = 100)
    public String genre;

    @OneToMany(mappedBy = "cd")
    public List<Track> tracks = new ArrayList<>();
}
