package com.example.demo.repositories;

import com.example.demo.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonRepositoryTest {


    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSave() {

        //crear instancia de Person

        Person person = new Person("John Doe", 30);

        // guardar persona mediante el repositorio

        Person savedPerson = personRepository.save(person);

        //persona guardada tiene ID asignado

        assertNotNull(savedPerson.getId());

        // datos guardados coinciden con los esperados

        assertEquals("John Doe", savedPerson.getNombre());
        assertEquals(30, savedPerson.getEdad());
    }

    @Test
    public void testFindAll() {

        // guarda nueva persona en la base de datos

        personRepository.save(new Person("Ditto", 30));

        // lista de todas las personas almacenadas en la base de datos

        assertFalse(personRepository.findAll().isEmpty());
    }

    @Test
    public void testDelete() {

        //crea nueva persona y la guarda en la base de datos

        Person person = personRepository.save(new Person("Delete Me", 25));

        personRepository.deleteById(person.getId());
        assertTrue(personRepository.findById(person.getId()).isEmpty());
    }

    @Test
    public void testUpdate() {

        // Crea y guarda nueva persona en la base de datos

        Person person = personRepository.save(new Person("Old Name", 20));

        // Modifica atributos de la persona

        person.setNombre("New Name");
        person.setEdad(30);

        // Guarda persona actualizada en la base de datos

        Person updatedPerson = personRepository.save(person);

        // Verifica que el ID sigue siendo el mismo

        assertNotNull(updatedPerson.getId());

        // Comprueba que los datos se han actualizado de forma correcta

        assertEquals("New Name", updatedPerson.getNombre());
        assertEquals(30, updatedPerson.getEdad());
    }
}
