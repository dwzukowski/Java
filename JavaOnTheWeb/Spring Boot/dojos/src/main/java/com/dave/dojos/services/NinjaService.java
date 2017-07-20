package com.dave.dojos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dave.dojos.models.Ninja;
import com.dave.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepository;
	public NinjaService(NinjaRepository ninjaRepository){
		this.ninjaRepository = ninjaRepository;
	}

	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	public List<Ninja> allNinjas(){
		return (List<Ninja>) ninjaRepository.findAll();
	}

	//public List<Ninja> findByDojoEquals(long id) {
		// TODO Auto-generated method stub
		//return (List<Ninja>) ninjaRepository.findByDojoEquals(id);
	//}

}
