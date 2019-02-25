package com.innovator.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.innovator.dto.ClusterDTO;
import com.innovator.dto.ServerDTO;
import com.innovator.exceptions.ServerNotFoundException;
import com.innovator.model.Cluster;
import com.innovator.model.Server;
import com.innovator.repository.ClusterRepository;
import com.innovator.repository.ServerRepository;

	@Controller
	@RequestMapping("/servers")
	public class ServerController {
		
		@Autowired
		private ServerRepository serverRepository;
		
		@RequestMapping(method=RequestMethod.GET)
		public @ResponseBody List<ServerDTO> getAllServers(){
			Iterable<Server>  servers=serverRepository.findAll();
			
			List<ServerDTO> serverDTOs= new ArrayList<ServerDTO>();
			
			for(Server server:servers){
				serverDTOs.add(ServerDTO.createServerDTO(server));
			}
			return serverDTOs;
		}
		
	
	@RequestMapping(value="/{serverId}",method=RequestMethod.GET)
	public @ResponseBody ServerDTO getServerById(@PathVariable("serverId") Long serverId){
		Server server=serverRepository.findById(serverId).get();
		if(server==null){
			throw new ServerNotFoundException("Server with Id "+serverId+" is Not found!!");
		}
		return ServerDTO.createServerDTO(server);		
	}
	

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> addNewServer( @RequestBody ServerDTO serverDTO){
		
		Server server=serverDTO.createServer();		
		server=serverRepository.save(server);
		
		URI newServerURI=ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(server.getServerId())
									.toUri();
		
		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.setLocation(newServerURI);
		
		return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
	}
	
	
	

}