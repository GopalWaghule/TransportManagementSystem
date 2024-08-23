package com.tms.mono.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.mono.model.Consighnment;
import com.tms.mono.model.Route;
import com.tms.mono.model.Vehical;
import com.tms.mono.model.dto.ConsighnmentDTO;
import com.tms.mono.model.dto.RouteDTO;
import com.tms.mono.repository.AssighnedConsighnmentDetailsDao;
import com.tms.mono.repository.ConsighnmentDao;
import com.tms.mono.repository.RouteDao;
import com.tms.mono.repository.VehicalDao;
import com.tms.mono.service.AssighnmentService;

@RestController
@RequestMapping("/get")
public class AccessDbController {

	private static final Logger LOGGER = LogManager.getLogger(AccessDbController.class);

	private VehicalDao vehicalDao;

	private RouteDao routeDao;

	private ConsighnmentDao consighnmentDao;

	private AssighnedConsighnmentDetailsDao acdDao;

	private ModelMapper mapper;
	
	private AssighnmentService assighnmentService;

	public AccessDbController(VehicalDao vehicalDao, RouteDao routeDao, ConsighnmentDao consighnmentDao,
			AssighnedConsighnmentDetailsDao acdDao, ModelMapper mapper, AssighnmentService assighnmentService) {
		super();
		this.vehicalDao = vehicalDao;
		this.routeDao = routeDao;
		this.consighnmentDao = consighnmentDao;
		this.acdDao = acdDao;
		this.mapper = mapper;
		this.assighnmentService=assighnmentService;
	}

	@GetMapping("/{s}")
	public ResponseEntity<?> accessDb(@PathVariable (required = false)String s)

	{
		if (s.equalsIgnoreCase("v")) {
			LOGGER.info("Getting Vehicals List");
			List<Vehical> all = vehicalDao.findAll();
			return ResponseEntity.ok(all);

		} else if (s.equalsIgnoreCase("r")) {
			LOGGER.info("Getting Route List");
			List<Route> all = routeDao.findAll();
			List<RouteDTO> routeDto = new ArrayList<>();
			for (Route route : all) {
				RouteDTO dto = mapper.map(route, RouteDTO.class);
				routeDto.add(dto);
			}
			return ResponseEntity.ok(routeDto);

		} else if (s.equalsIgnoreCase("c")) {
			LOGGER.info("Getting Consignment List");
			List<Consighnment> all = consighnmentDao.findAll();

			List<ConsighnmentDTO> consighnmentDTOList = new ArrayList<>();
			for (Consighnment consighnment : all) {
				ConsighnmentDTO dto = mapper.map(consighnment, ConsighnmentDTO.class);
				consighnmentDTOList.add(dto);
			}
			return ResponseEntity.ok(consighnmentDTOList);

		} else if (s.equalsIgnoreCase("acd")) {
			LOGGER.info("Getting AssignedConsignmentDetails List");
			return ResponseEntity.ok(acdDao.findAll());

		} else {
			LOGGER.info("Not provided Expected input");
			return ResponseEntity.ok("Please Give appropriate input :"
					+ "  v =Vehical , c= Consighnments , r= Route , acd= AssignedConsignmentDetails");
		}

	}
	
	@GetMapping("/vehical/{number}")
	public ResponseEntity<Vehical> findVehicalByNumber(@PathVariable String number){
		try {
			Vehical byNumber =assighnmentService.findVehicalByNumber(number);
			return new ResponseEntity<>(byNumber,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception In Controller : {}",e.getMessage());
		}
		return ResponseEntity.notFound().build();
	}

}
