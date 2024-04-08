package com.xworkz.tour.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table(name="team")
public class TourDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String country;
    private String captain;
    @Column(name = "category_type")
    private String categoryType;


}
