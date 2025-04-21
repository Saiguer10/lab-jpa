package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "person")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int edad;

    // Constructores

    public Person() {}

    public Person(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y setters

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override

    public String toString() {
        return "Person{id=" + id + ", nombre='" + nombre + "', edad=" + edad + "}";
    }
}
