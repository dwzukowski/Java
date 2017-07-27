package com.dave.belt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dave.belt.models.Pack;
import com.dave.belt.repositories.PackRepository;

@Service
public class PackService {
	private PackRepository packRepository;
	
	public PackService(PackRepository packRepository){
		this.packRepository = packRepository;
	}
	public void addPack(Pack pack){
		packRepository.save(pack);
	}
	public List<Pack> allPacks() {
		return (List<Pack>) packRepository.findAll();
	}
	public Pack findByName(String name){
		return packRepository.findByName(name);
	}

	public Pack activatePack(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void activatePack(Pack pack) {
		pack.setAvailable(true);
		packRepository.save(pack);	
	}
	public void deactivatePack(Pack pack) {
		pack.setAvailable(false);
		packRepository.save(pack);	
	}
	public void destroyPack(Pack pack) {
		packRepository.delete(pack);
		
	}
	public List<Pack> getPacksWhereAvailable(boolean b) {
		return packRepository.getPacksWhereAvailable(b);
	}
}
