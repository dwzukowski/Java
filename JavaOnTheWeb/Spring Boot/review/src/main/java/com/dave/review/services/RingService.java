package com.dave.review.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dave.review.models.Ring;
import com.dave.review.repositories.RingRepository;

@Service
public class RingService {
	private RingRepository ringRepository;
	
	public RingService(RingRepository ringRepository){
		this.ringRepository = ringRepository;
	}
	public void addRing(Ring ring){
		ringRepository.save(ring);
	}
	public List<Ring> allRings(){
		return (List<Ring>) ringRepository.findAll();
	}
	public Ring findById(String name) {
		Long id = Long.parseLong(name);
		return ringRepository.findOne(id);
	}
	public Ring findById(int id) {
		return ringRepository.findOne((long) id);
	}
	public Ring findById(long id) {
		return ringRepository.findOne(id);
	}
	public void dropRing(long id) {
		Ring ring = this.findById(id);
		ring.setUser(null);
		ring.setPickedUp(false);
		ringRepository.save(ring);
	}
	public List<Ring> getRingsWherePickedUp(boolean b) {
		return ringRepository.getRingsWherePickedUp(b);
	}
	
}
