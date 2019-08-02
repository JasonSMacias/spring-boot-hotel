package com.revature.boot.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.boot.beans.*;

/**
 * Welcome to Spring Data
 * @author jmaci
 *
 */

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	//query methods: findByPropertyName . . . (parses method name)
	public List<Hotel> findByPriceBetween(double low, double high);
}
