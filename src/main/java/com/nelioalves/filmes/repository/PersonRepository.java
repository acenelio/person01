package com.nelioalves.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelioalves.filmes.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}

