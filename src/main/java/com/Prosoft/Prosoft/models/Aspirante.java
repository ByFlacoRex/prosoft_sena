package com.Prosoft.Prosoft.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "aspirantes")
public class Aspirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "nombre")
    private String Nombre;
    @Getter @Setter @Column(name = "apellido")
    private String Apellido;
    @Getter @Setter @Column(name = "tipodocumento")
    private String Documentos;
    @Getter @Setter @Column(name = "numdocumento")
    private String Documento;
    @Getter @Setter @Column(name = "telefono")
    private String Telefono;
    @Getter @Setter @Column(name = "email")
    private String Email;

}