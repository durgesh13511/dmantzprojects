package com.dm_02_tbdapp.controller;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dm_02_tbdapp.bean.Report;
import com.dm_02_tbdapp.bean.User;
import com.dm_02_tbdapp.bean.UserProfile;
import com.dm_02_tbdapp.dao.AddAddressDAO;
import com.dm_02_tbdapp.dao.LoginUserDAO;
import com.dm_02_tbdapp.dao.LogoutUserDAO;
import com.dm_02_tbdapp.dao.RegisterUserDAO;
import com.dm_02_tbdapp.dao.RemoveAddressDAO;
import com.dm_02_tbdapp.dao.UpdateAddressDAO;
import com.dm_02_tbdapp.dao.UpdateUserDAO;




@RestController
public class UserAppController {
	static String uname;
	static String ppwd;
	
	
	@Autowired
	UserManager userManagerObj;
	
	@Autowired
	CatalogManager catalogManagerObj;
	
	
	
final static Logger logger=LogManager.getLogger(UserAppController.class);	
	@RequestMapping(value="/UserApp/user", method = RequestMethod.GET,produces={"application/json","application/xml"})
	public UserProfile setUserProfile(@RequestParam("UID") String data) {
		
		 UserProfile upObj=new UserProfile();
	    upObj.setUserId("1001");
		upObj.setUserKey(1002);
		upObj.setProfileKey("name");
		
		User userObj=new User();
		userObj.setUserId("1001");
		userObj.setUserKey(1002);
		userObj.setFirstName("shashikanth");
		userObj.setLastName("reddy");
		userObj.setUserTypeId("hello");
		userObj.setUserTypeName("kanth");
		userObj.setUserDisplayName("shashikanthreddy");
		upObj.setUser(userObj);
		
		upObj.setFirstName("rohit");
		upObj.setLastName("jain");
		upObj.setDOB(12-04-1995);
		upObj.setGender("male");
		upObj.setAge(23);
		upObj.setEmailId("rohitjainmail@gmail.com");
		upObj.setMobileNumber("12345");
		upObj.setAltMobileNumber("54321");
		upObj.setLastLoggedLocation("hyderabad");
		upObj.setShipAddressList(null);
		upObj.setBillingAddressList(null); 
		
		/*JSONObject jsonObj1=new JSONObject();
		jsonObj1.put("userId","1001");
		jsonObj1.put("userKey",1002);
		jsonObj1.put("profileKey","name");
		
		JSONObject jsonObj2=new JSONObject();
		jsonObj2.put("userId","1001");
		jsonObj2.put("userKey",1002);
		jsonObj2.put("firstName","shashikanth");
		jsonObj2.put("lastName","reddy");
		jsonObj2.put("userTypeId","hello");
		jsonObj2.put("userTypeName","kanth");
		jsonObj2.put("userDisplayName","shashikanthreddy");
		jsonObj1.put("user",jsonObj2);
		
	    jsonObj1.put("firstName","rohit");
	    jsonObj1.put("lastName","jain");
	    jsonObj1.put("DOB","12-04-1995");
	    jsonObj1.put("gender","male");
	    jsonObj1.put("age",23);
	    jsonObj1.put("emailId","rohitjainmail@gmail.com");
	    jsonObj1.put("mobileNumber",12345);
	    jsonObj1.put("altMobileNumber",54321);
	    jsonObj1.put("lastLoggedLocation","hyderabad");
	    jsonObj1.put("shipAddressList",null);
	    jsonObj1.put("billingAddressList",null); */
	 
		return upObj;
	}
	
	// This method is exicuted when user logged in 
	
    @RequestMapping(value="/UserApp/login", method=RequestMethod.POST) 
    public @ResponseBody JSONObject loginUser(@RequestBody JSONObject credentials) {
    	
    
    	UserManager userManagerObj=new UserManager();
    //System.out.println("UserManager object is created.Hello shashikanth.we r in loginUser() in class UserAppController.");
    JSONObject jsonObj=userManagerObj.loginUser(credentials);
    System.out.println("RequestBody test is "+credentials);
    return jsonObj;
    }
   
    
    @RequestMapping(value="/UserApp/RegisterUser",method=RequestMethod.POST)
    public @ResponseBody JSONObject newUser(@RequestBody JSONObject newUserObj) {
    	//UserManager userManagerObj=new UserManager();
    	JSONObject registerUserObj=userManagerObj.registerNewUser(newUserObj);
    	return registerUserObj;
    }
    
    // This method is exicuted if the user logged out
    
    @RequestMapping(value="/UserApp/logout", method=RequestMethod.GET)
	public @ResponseBody JSONObject logoutUser() {
    	UserManager userManagerObj=new UserManager();
    	//System.out.println("UserManager object is created.Hello shashikanth.we r in logoutUser() in class UserAppController.");
    	JSONObject jsonObj=userManagerObj.logoutUser();
    	return jsonObj;
    }
    
    // This method is responsible to register the user
    
    @RequestMapping(value="/UserApp/registerUser", method=RequestMethod.GET)
    public @ResponseBody JSONObject registerUser(@RequestParam("user") User userObj) {
        UserManager userManagerObj=new UserManager();
        //System.out.println("UserManager object is created.Hello shashikanth.we r in registerUser(.) in class UserAppController.");
    	JSONObject jsonObj=userManagerObj.registerUser(userObj);
    	return jsonObj;
    }
    
    // This method is responsible to update the user
    
    @RequestMapping(value="/UserApp/updateUser", method=RequestMethod.GET)
    public @ResponseBody JSONObject updateUser(@RequestParam("user") User userObj) {
    	UserManager userManagerObj=new UserManager();
    	//System.out.println("UserManager object is created.Hello shashikanth.we r in updateUser() in class UserAppController.");
    	JSONObject jsonObj=userManagerObj.updateUser(userObj);
    	return jsonObj;
    }
    
    // This method is responsible to update the user
    
    @RequestMapping(value="/UserApp/updateUserAddress", method=RequestMethod.GET)
    public @ResponseBody JSONObject updateAddress(@RequestParam("user") User userObj) {
    	UserManager userManagerObj=new UserManager();
    	//System.out.println("UserManager object is created.Hello shashikanth.we r in updateAddress(.) in class UserAppController.");
    	JSONObject jsonObj=userManagerObj.updateAddress(userObj);
    	
    	return jsonObj;
    }
    
    // This method is responsible to add address
    
    @RequestMapping(value="/UserApp/addAddress", method=RequestMethod.GET)
    public @ResponseBody JSONObject addAddress(@RequestParam("user") User userObj) {
    	UserManager userManagerObj=new UserManager();
    	//System.out.println("UserManager object is created.Hello shashikanth.we r in addAddress(.) in class UserAppController.");
    	JSONObject jsonObj=userManagerObj.addAddress(userObj);
    	return jsonObj;
    }
    
    // This method is responsible to remove address
    
    @RequestMapping(value="/UserApp/removeAddress", method=RequestMethod.GET)
    public @ResponseBody JSONObject removeAddress(@RequestParam("user") User userObj) {
    	UserManager userManagerObj=new UserManager();
    	//System.out.println("UserManager object is created.Hello shashikanth.we r in removeAddress(.) in class UserAppController.");
    	JSONObject jsonObj=userManagerObj.removeAddress(userObj);
    	return jsonObj;
    }
    
    // this method is responsible to insert records into database

      @RequestMapping(value="/UserApp/insertIntoProduct_Table",method=RequestMethod.POST)
      public @ResponseBody JSONObject insertIntoProduct_Table(@RequestBody JSONObject productObj) {
    	  JSONObject product_table_Obj=userManagerObj.insertProduct(productObj);
    	  return product_table_Obj;
      }
    
      //
      
      @RequestMapping(value="/UserApp/catalog",method=RequestMethod.GET)
      public @ResponseBody JSONObject catalog() {
  		
  		// use json object as return type and parameter
    	 JSONObject jsonObj=catalogManagerObj.catalogDetails();
  		
  		return jsonObj;
  	} 
  	
      
     @RequestMapping(value="/UserApp/product",method=RequestMethod.GET)
     public @ResponseBody JSONObject product() {
  	   
  	   // use json object as return type and parameter.
  	   
  	   JSONObject jsonObj=catalogManagerObj.retriveProductDetails();
  	   
  	   return jsonObj;
     }
     
     
     @RequestMapping(value="/UserApp/insertImage",method=RequestMethod.GET)
     public @ResponseBody String image(@RequestParam("address") String path) {
    	 
    	 String image= catalogManagerObj.insertImg(path);
    	 return image;
     }
     
     
     @RequestMapping(value="/UserApp/showImage",method=RequestMethod.GET,produces=MediaType.IMAGE_JPEG_VALUE)
     public @ResponseBody byte[] displayImg(@RequestParam("id") int id) throws IOException {
    	 Object image= catalogManagerObj.displayImage(id);
    	 Report report=(Report)image;
    	 logger.info("IOUtils object is : "+report.getImg_data_new().getAbsolutePath());
    	 InputStream is=getClass().getResourceAsStream(report.getImg_data_new().getAbsolutePath());  
                
              return IOUtils.toByteArray(is) ;
     }
      @RequestMapping(value="/UserApp/showImageNew")
     public void photo(HttpServletResponse response,@RequestParam("id") int id) throws IOException {
    	 response.setContentType("image/jpeg");
    	 Object image= catalogManagerObj.displayImage(id);
    	 Report report=(Report)image;
    	 //logger.info("IOUtils object is : "+report.getImg_data_new().getAbsolutePath());
    	// InputStream is=getClass().getResourceAsStream(report.getImg_data_new().getPath());
    	 //InputStream is=getClass().getResourceAsStream("C:\\Users\\shashi\\Desktop\\UserApp\\UserApp\\output.jpg");
    	 logger.info("getClass() mehtod : "+report.getImg_data_new().getPath());
    	 InputStream is=new FileInputStream(report.getImg_data_new().getPath());
    	 
    	 logger.info("InputStream object is : "+is);
    	 IOUtils.copy(is, response.getOutputStream());
    	 
     }
}
