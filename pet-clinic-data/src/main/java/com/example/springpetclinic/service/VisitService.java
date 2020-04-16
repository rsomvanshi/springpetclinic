package com.example.springpetclinic.service;

import com.example.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitService extends CrudService<Visit, Long> {
}
