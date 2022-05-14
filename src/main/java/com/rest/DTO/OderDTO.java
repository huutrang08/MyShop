package com.rest.DTO;

import java.io.Serializable;
import java.util.Set;
public class OderDTO implements Serializable{
   private  int total;
   private float discount;
   private String status;	
   private UsersDTO user;
   private Set<OderDetail> oderDetail;
}
