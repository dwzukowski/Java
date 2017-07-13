package com.dave.pets.models;

public class Animal implements Pet {
	private String name;
	private String breed;
	private String weight;
	
	public Animal(){
		
	}
	public Animal(String name, String breed, String weight){
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String showAffection(){
		String breed = getBreed();
		boolean bool = breed.equals("dog");
		String action = "test";
		if(breed.equals("cat") || breed.equals("Cat")){
			action = "looks at you";
			return action; 
		}
		if(breed.equals("dog") || breed.equals("Dog")){
			int weight = Integer.parseInt(getWeight());
			if(weight < 30){
				action = "hops in lap";
				return action; 
			}
			else{
				action = "curls up";
				return action; 
			}
		}
		return action; 
	}
}