package com.revature.boot.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.boot.beans.Hotel;
import com.revature.boot.service.HotelService;

import io.swagger.annotations.Api;


/**
 * @RestContoller: combines @Controller with @ResponseBody
 * 	@ResponseBody - says we don't need the view resolver, this is a rest api
 *
 * @RequestMapping: we can annotate the controller with this as well	
 * 	allows us to specify uri path that his controller handles
 * 	we can also specify additional attributes: 
 * 		consumes - MediaType expected from request body
 * 		produces - MediaType of response body
 */

@Api(value = "Hotel API")
@RestController
@RequestMapping(value = "/api/v1/rooms/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelController {
	
	private static final Logger log = Logger.getLogger(HotelController.class);
	
	@Autowired
	private HotelService service;
	
	
	@PostMapping("/room")
	public ResponseEntity<Hotel> save(@RequestBody Hotel room) {
		// @RequestBody says to read the Http request body, parse it, and marshall it from JSON into a Java object
		return new ResponseEntity<Hotel>(service.save(room), HttpStatus.CREATED);
	}
	
	@GetMapping("/room/{id}")
	public Hotel findById(@PathVariable int id) {
		return service.findById(id);
	}
	//@PathVariable says to search uri path for this variable's value
	
//	@GetMapping("/")
//	public List<Hotel> findAll() {
//		return service.findAll();
//	} // findall doesn't exist in service method yet
	
	@DeleteMapping("/room/{id}")
	public void delete(@PathVariable int id){
		service.delete(id);
	}
	
	@GetMapping("/price")
	public ResponseEntity<List<Hotel>> findByPriceRange(@RequestParam("lo") double low, @RequestParam("hi") double high) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom Header", "pickles");
		return ResponseEntity.ok()
				.header("myheader", "this is a header")
				.headers(headers)
				.body(service.findByPriceRange(low, high));
	}
}
