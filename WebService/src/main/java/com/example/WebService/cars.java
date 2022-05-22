package com.example.WebService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class cars {
	
private List<car> cars = new ArrayList<car>();
Dates dateIni = new Dates();
	
	public cars() {
		cars.add(new car("11AA22", "Ferrari", 1000, true , dateIni ));
		cars.add(new car("33BB44", "Porshe", 2222, false , dateIni));
	}
	
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<car> listOfCars(){
		return cars;
	}

	
	
	  @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
	  
	  @ResponseStatus(HttpStatus.OK)
	  
	  @ResponseBody public car aCar(@PathVariable("plateNumber") String
	  plateNumber) throws Exception{
		  car tuture = new car();
		  for (var car : cars) {
			  if (car.getPlateNumber().equals(plateNumber)) {
				  tuture=car;
		  }
		  }
		  return tuture;
	  }
	  
	 
	 
	
	  @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
	  
	  @ResponseStatus(HttpStatus.OK) public void
	  getBack(@PathVariable("plateNumber") String plateNumber) throws Exception{
		  for (var car : cars) {
			  if (car.getPlateNumber().equals(plateNumber)) {
				  cars.remove(car);

		  }
		  }
	  }
	  
		
		  @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
		  
		  @ResponseStatus(HttpStatus.OK) public ResponseEntity<String> rent(@PathVariable("plateNumber")
		  String plateNumber) throws Exception{ 
			  String reponse ="ca ne marche pas"; 
			  for (var car : cars) {
				  if (car.getPlateNumber().equals(plateNumber)) {
					  car.rented = true;
					  System.out.println(car);
					  reponse ="le put marche "+car.toString();
			  }
			  }
			  return new ResponseEntity<String> (reponse+HttpStatus.OK.name(), HttpStatus.OK);
		  }
		  
			
			/*
			 * @RequestMapping(value = "/voiture/{plateNumber}", method = RequestMethod.PUT)
			 * 
			 * @ResponseStatus(HttpStatus.OK) public void
			 * rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
			 * 
			 * @RequestParam(value="rent", required = true)boolean rent) throws Exception{ }
			 */
			  
		  @PutMapping(value = "/voitures/{plateNumber}")
			public ResponseEntity<String> rent(@PathVariable("plateNumber") String plateNumber,
							 @RequestParam(value="rent", required = true)boolean rented,
							 @RequestParam(value="debut",required = false) String debut , @RequestParam(value="fin", required = false) String fin  ) throws Exception{ 

				  String reponse ="notre put date ne marche pas"; 
				  for (var car : cars) {
					  if (car.getPlateNumber().equals(plateNumber)) {
						  reponse ="Il passe dans le premier if "+car.toString();
						  if(car.rented.equals(true))
						  {
							  car.setDate(debut , fin);
							  System.out.println(car);
							  reponse ="le put date marche "+car.date.toString();
						  }
						 
				  }
				  }
				  return new ResponseEntity<String> (reponse+HttpStatus.OK.name(), HttpStatus.OK);
				  
			  }
			 
		 
	 
}
