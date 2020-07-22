package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "fist_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
