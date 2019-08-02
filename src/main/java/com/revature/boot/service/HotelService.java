package com.revature.boot.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.revature.boot.beans.Hotel;
import com.revature.boot.data.HotelRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository repo;
	
	public Hotel save(Hotel room) {
		return repo.save(room);
	}
	
	public Hotel findById(int id) {
		Optional<Hotel> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
//			Log.warn("not found");
			return null;
		}
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	public List<Hotel> findByPriceRange(double low, double high) {
		return repo.findByPriceBetween(low, high);
	}
	
	// if you don't know how to build the query method you want . . .
	// jpql, which is like hql
	@Query("from Hotel")
	public void noIdeaHowToDoThisThing() {
	}
}
