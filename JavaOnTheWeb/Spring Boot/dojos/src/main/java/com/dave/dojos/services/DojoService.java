package com.dave.dojos.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.dave.dojos.models.Dojo;
import com.dave.dojos.models.Ninja;
import com.dave.dojos.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepository;
	public DojoService(DojoRepository dojoRepository){
		this.dojoRepository = dojoRepository;
	}
	public void addDojo(Dojo dojo){
		dojoRepository.save(dojo);
	}
	public List<Dojo> allDojos() {
		return (List<Dojo>) dojoRepository.findAll();
	}
	public Dojo findByDojoById(long id) {
		return dojoRepository.findOne(id);
	}

}
