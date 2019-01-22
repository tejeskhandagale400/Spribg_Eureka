package com.cg.websiteclient.websiteclient.resource;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.ribbon.proxy.annotation.Http;

@Controller
public class Resource {
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Autowired
	private RestTemplate restTeplate;
    
  
    @RequestMapping("/hello")
    public String home(Model model) {		
		  String output =  restTeplate.exchange("http://hello-client", HttpMethod.GET,null, 
				  					new ParameterizedTypeReference<String>() {}).getBody();
		  System.out.println(output);
		  model.addAttribute("output", output);
		return "helloworld";
       
    }
}
