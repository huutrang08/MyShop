package com.rest.ResController;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.Entity.Cartitem;
import com.rest.Entity.Oder;
import com.rest.Entity.OderDetail;
import com.rest.Entity.Users;
import com.rest.Services.CartItemServices;
import com.rest.Services.JwtServices;
import com.rest.Services.OderDetailServices;
import com.rest.Services.UserServices;

@RestController
@RequestMapping("oders")
public class OderController {
	@Autowired
	UserServices userServices;
	
	@Autowired
	JwtServices jwtServices;
	@Autowired
	CartItemServices cartItemServices;
	
	@Autowired
	OderDetailServices oderDetailServices;
	@RequestMapping(value = "oder",method = RequestMethod.POST,
			produces = {
					MediaType.APPLICATION_JSON_VALUE
			})
   public ResponseEntity<Oder> add(@RequestHeader String token){
	   Users users = userServices.findByusername(jwtServices.getUserNameFromJwtToken(token));
	   Oder oder = new Oder();
	   OderDetail oderDetail = new OderDetail();
	   oderDetail.setOder(oder);
	   
	   oder.setUser(users);
	   int total = 0;
       List<Cartitem> list = cartItemServices.findByUsers(users);
       oder.setTotal(total);
       oder.setStatus("Chua Thanh Toan");
       
       return ResponseEntity.ok(oder);
	}
}
