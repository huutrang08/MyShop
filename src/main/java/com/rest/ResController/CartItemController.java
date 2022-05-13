package com.rest.ResController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.Entity.Cartitem;
import com.rest.Entity.Users;
import com.rest.Services.CartItemServices;
import com.rest.Services.JwtServices;
import com.rest.Services.UserServices;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForImplementation;

@RestController
@RequestMapping("ca")
public class CartItemController {
	@Autowired
	JwtServices jwtServices;

    @Autowired
	CartItemServices cartItemServices;
	
    
    @Autowired
    UserServices userServices;
    
    @RequestMapping(value = "cart", method = RequestMethod.POST,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<Cartitem> adds(@RequestBody Cartitem cartitem,@RequestParam("token") String token){
    	Map<Integer, Cartitem> map = new HashMap<>();
    	String user = jwtServices.getUserNameFromJwtToken(token);
    	Users users = userServices.findByusername(user);
    	List<Cartitem> list = cartItemServices.findByUsers(users);
     for (int i = 0; i < list.size() ; i++) {
		map.put(list.get(i).getProduct().getProductId(), list.get(i));
	}
     cartitem.setUser(users);
     cartitem.setQuantity(1);
     cartitem.setProduct(cartitem.getProduct());
     cartItemServices.add(cartitem, map, cartitem.getCartId());
     return ResponseEntity.ok(cartitem);
    }
    
    @RequestMapping(value = "carts", method = RequestMethod.GET,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public List<Cartitem> list(@RequestBody String token){
    	Users users = userServices.findByusername(jwtServices.getUserNameFromJwtToken(token));
    	return cartItemServices.findByUsers(users);
    }
    
    @RequestMapping(value = "cart", method = RequestMethod.DELETE,
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE
			}
			)
	@ResponseBody
	public ResponseEntity<Cartitem> dele(@RequestBody Integer id){
    	Optional<Cartitem> cartitem = cartItemServices.findById(id);
    	cartItemServices.deleteById(id);
    	return ResponseEntity.ok(cartitem.get());
    }
    
    @RequestMapping(value = "cart" , method = RequestMethod.PUT,
    		produces = {
    				MediaType.APPLICATION_PROBLEM_JSON_VALUE
    		}
    		)
    @ResponseBody
    public Cartitem put(@RequestParam("id") Integer id,@RequestParam("quantity") Integer quantity) {	
    	Optional<Cartitem> cartitem = cartItemServices.findById(id);
    	if (quantity<=0) {
			cartItemServices.deleteById(id);
		}
    	cartitem.get().setQuantity(quantity);
    	cartItemServices.save(cartitem.get());
    	return cartitem.get();
    	
    }
}
