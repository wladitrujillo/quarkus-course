package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "t_tracks")
public class Track extends PanacheEntity {
    @Column(nullable = false)
    public String title;
    public Duration duration;
    public Instant createdDate = Instant.now();
    @ManyToOne
    @JoinColumn(name = "cd_fk")
    public CD cd;
}
