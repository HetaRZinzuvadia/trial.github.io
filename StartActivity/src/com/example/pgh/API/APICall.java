package com.example.pgh.API;

import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import com.example.pgh.POJO.AllArea;
import com.example.pgh.POJO.AllPackage;
import com.example.pgh.POJO.AllResult;
import com.example.pgh.POJO.AllTaxi;
import com.google.gson.Gson;


public class APICall {
	
	public String postUserReg1(String name,String email, String mobile , String password, String utype)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1", name));
        nameValuePairs.add(new BasicNameValuePair("v2", email));
        nameValuePairs.add(new BasicNameValuePair("v3", mobile));
        nameValuePairs.add(new BasicNameValuePair("v4", password));        
        nameValuePairs.add(new BasicNameValuePair("v5", utype));        
               try
        {
            result = HTTPCall.postData(APIResources.POST_USER_REG_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }	


	public String postUserReg(String title, String name,String email, String mobile , String role)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",	title));
        nameValuePairs.add(new BasicNameValuePair("v2", name));
        nameValuePairs.add(new BasicNameValuePair("v3", email));
        nameValuePairs.add(new BasicNameValuePair("v4", mobile));
        nameValuePairs.add(new BasicNameValuePair("v5", role));        
        try
        {
            result = HTTPCall.postData(APIResources.POST_REG_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }	
	
	public String postLogin(String uname, String password)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",uname));
        nameValuePairs.add(new BasicNameValuePair("v2", password));
        
        try
        {
            result = HTTPCall.postData(APIResources.POST_LOGIN_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public String postTaxiRateUpdate(String tid,String type, String stype, String sac, String pac, String snac, String pnac)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",tid));
        nameValuePairs.add(new BasicNameValuePair("v2",type));
        nameValuePairs.add(new BasicNameValuePair("v3",stype));
        nameValuePairs.add(new BasicNameValuePair("v4",sac));
        nameValuePairs.add(new BasicNameValuePair("v5",pac));
        nameValuePairs.add(new BasicNameValuePair("v6",snac));
        nameValuePairs.add(new BasicNameValuePair("v7",pnac));
             
        try
        {
            result = HTTPCall.postData(APIResources.POST_TAXI_RATE_UPDATE_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public String postTaxiDataCheck(String tid)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",tid));             
        try
        {
            result = HTTPCall.postData(APIResources.POST_TAXI_DATA_CHECK_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public  AllTaxi getTaxiData(String tid) 
	{

        AllTaxi result = new AllTaxi();
        String reqURL=APIResources.GET_TAXI_DATA_URL+"?tid="+tid;
        String output = HTTPCall.getData(reqURL);
        Log.d("Rittz",output);
        result = new Gson().fromJson(output, AllTaxi.class);
        return result;
    }

	
	public  AllTaxi getTaxiDetails(String type,String stype) 
	{

        AllTaxi result = new AllTaxi();
        String reqURL=APIResources.GET_TAXI_DETAILS_URL+"?type="+type+"&stype="+stype;
        String output = HTTPCall.getData(reqURL);
        Log.d("Rittz",output);
        result = new Gson().fromJson(output, AllTaxi.class);
        return result;
    }

	

	public  AllArea getArea() 
	{

        AllArea result = new AllArea();
        String reqURL=APIResources.GET_AREA_URL;
        String output = HTTPCall.getData(reqURL);
        Log.d("Rittz",output);
        result = new Gson().fromJson(output, AllArea.class);
        return result;
    }

	public String postPropertyAdv(String email,String title,String desc,String facility,String area, String rent, String contact)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",email));             
        nameValuePairs.add(new BasicNameValuePair("v2",title));             
        nameValuePairs.add(new BasicNameValuePair("v3",desc));             
        nameValuePairs.add(new BasicNameValuePair("v4",facility));             
        nameValuePairs.add(new BasicNameValuePair("v5",area));             
        nameValuePairs.add(new BasicNameValuePair("v6",rent));             
        nameValuePairs.add(new BasicNameValuePair("v7",contact));        
        
        try
        {
            result = HTTPCall.postData(APIResources.POST_PROPERTY_ADV_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public String postPropertyImageUpdateFinish(String pid)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",pid.trim()));             
        
        try
        {
            result = HTTPCall.postData(APIResources.POST_PROPERTY_IMAGE_UPDATE_FINISH_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public String postWaterAdv(String email,String title,String desc,String stype,String area, String rent, String contact)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",email));             
        nameValuePairs.add(new BasicNameValuePair("v2",title));             
        nameValuePairs.add(new BasicNameValuePair("v3",desc));             
        nameValuePairs.add(new BasicNameValuePair("v4",stype));             
        nameValuePairs.add(new BasicNameValuePair("v5",area));             
        nameValuePairs.add(new BasicNameValuePair("v6",rent));             
        nameValuePairs.add(new BasicNameValuePair("v7",contact));        
        
        try
        {
            result = HTTPCall.postData(APIResources.POST_WATER_ADV_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public String postWaterImageUpdateFinish(String pid)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",pid.trim()));             
        
        try
        {
            result = HTTPCall.postData(APIResources.POST_WATER_IMAGE_UPDATE_FINISH_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }

	public String postFoodAdv(String email,String title,String desc,String stype,String area, String rent, String contact)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",email));             
        nameValuePairs.add(new BasicNameValuePair("v2",title));             
        nameValuePairs.add(new BasicNameValuePair("v3",desc));             
        nameValuePairs.add(new BasicNameValuePair("v4",stype));             
        nameValuePairs.add(new BasicNameValuePair("v5",area));             
        nameValuePairs.add(new BasicNameValuePair("v6",rent));             
        nameValuePairs.add(new BasicNameValuePair("v7",contact));        
        
        try
        {
            result = HTTPCall.postData(APIResources.POST_FOOD_ADV_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public String postFoodImageUpdateFinish(String pid)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",pid.trim()));             
        
        try
        {
            result = HTTPCall.postData(APIResources.POST_FOOD_IMAGE_UPDATE_FINISH_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }

	public  AllResult getWaterDetails(String sarea,String stype) 
	{
        AllResult result = new AllResult();
        String reqURL=APIResources.GET_WATER_ADV_URL+"?sarea="+sarea.trim()+"&stype="+stype;
        String output = HTTPCall.getData(reqURL);
        Log.d("Rittz",output);
        result = new Gson().fromJson(output, AllResult.class);
        return result;
    }
	
	public  AllResult getFoodDetails(String sarea,String stype) 
	{
        AllResult result = new AllResult();
        String reqURL=APIResources.GET_FOOD_ADV_URL+"?sarea="+sarea.trim()+"&stype="+stype;
        String output = HTTPCall.getData(reqURL);
        Log.d("Rittz",output);
        result = new Gson().fromJson(output, AllResult.class);
        return result;
    }
	
	public  AllResult getPropertyDetails(String sarea,String stype) 
	{
        AllResult result = new AllResult();
        String reqURL=APIResources.GET_PROPERTY_ADV_URL+"?sarea="+sarea.trim()+"&stype="+stype;
        String output = HTTPCall.getData(reqURL);
        Log.d("Rittz",output);
        result = new Gson().fromJson(output, AllResult.class);
        return result;
    }

	public  AllResult getUserAdvDetails(String email,String utype) 
	{
        AllResult result = new AllResult();
        String reqURL=APIResources.GET_USER_ADV_URL+"?email="+email.trim()+"&utype="+utype;
        String output = HTTPCall.getData(reqURL);
        Log.d("Rittz",output);
        result = new Gson().fromJson(output, AllResult.class);
        return result;
    }
	
	public String postFoodOrder(String sid,String uid,String Date, String time, String Address,String oid)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",sid));             
        nameValuePairs.add(new BasicNameValuePair("v2",uid));               
        nameValuePairs.add(new BasicNameValuePair("v3",Date));             
        nameValuePairs.add(new BasicNameValuePair("v4",time));             
        nameValuePairs.add(new BasicNameValuePair("v5",Address));             
        nameValuePairs.add(new BasicNameValuePair("v6",oid));             
        try
        {
            result = HTTPCall.postData(APIResources.POST_FOOD_ORDER_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }

	public String postTaxiOrder(String tid,String uid,String type,String type1,String Date, String time, String Address)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",tid));             
        nameValuePairs.add(new BasicNameValuePair("v2",uid));             
        nameValuePairs.add(new BasicNameValuePair("v3",type));             
        nameValuePairs.add(new BasicNameValuePair("v4",type1));             
        nameValuePairs.add(new BasicNameValuePair("v5",Date));             
        nameValuePairs.add(new BasicNameValuePair("v6",time));             
        nameValuePairs.add(new BasicNameValuePair("v7",Address));         
        try
        {
            result = HTTPCall.postData(APIResources.POST_TAXI_ORDER_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public String postWaterOrder(String sid,String uid,String Date, String time, String Address,String oid)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",sid));             
        nameValuePairs.add(new BasicNameValuePair("v2",uid));               
        nameValuePairs.add(new BasicNameValuePair("v3",Date));             
        nameValuePairs.add(new BasicNameValuePair("v4",time));             
        nameValuePairs.add(new BasicNameValuePair("v5",Address));             
        nameValuePairs.add(new BasicNameValuePair("v6",oid));             
        try
        {
            result = HTTPCall.postData(APIResources.POST_WATER_ORDER_URL, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public  AllResult getUserOrder(String email,String utype) 
	{
        AllResult result = new AllResult();
        String reqURL=APIResources.GET_USER_ORDER_URL+"?email="+email.trim()+"&utype="+utype;
        String output = HTTPCall.getData(reqURL);
        Log.d("Rittz",output);
        result = new Gson().fromJson(output, AllResult.class);
        return result;
    }
	
	public String cancel_userOrd(String email, String utype, String advid)
	{

		 String result = null;
	        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        nameValuePairs.add(new BasicNameValuePair("email",email));             
	        nameValuePairs.add(new BasicNameValuePair("utype",utype));               
	        nameValuePairs.add(new BasicNameValuePair("aid",advid));               
		        try
	        {
	            result = HTTPCall.postData(APIResources.USERCANCEL_ORDER, nameValuePairs);
	            Log.d("PGH", result);
	        } 
	        catch (Exception e) 
	        {
	            // TODO: handle exception    
	        }
	        return result;
	}
	
	public AllResult gettaxiFacord(String email)
	{
		AllResult result=new AllResult();
		String url=APIResources.GET_TAXIFAC_ORDER+"?email="+email.trim() ;
		String output=HTTPCall.getData(url);
		result=new Gson().fromJson(output, AllResult.class);
		return result;
	}
	
	public AllResult getfoodFacord(String email)
	{
		AllResult result=new AllResult();
		String url=APIResources.GET_FOODFAC_ORDER+"?email="+email.trim() ;
		String output=HTTPCall.getData(url);
		result=new Gson().fromJson(output, AllResult.class);
		return result;
	}

	public AllResult getwaterFacord(String email)
	{
		AllResult result=new AllResult();
		String url=APIResources.GET_WATERFAC_ORDER+"?email="+email.trim() ;
		String output=HTTPCall.getData(url);
		result=new Gson().fromJson(output, AllResult.class);
		return result;
	}
	
	public String foodpac(String title, String service,String rate, String number)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",	title));
        nameValuePairs.add(new BasicNameValuePair("v2", service));
        nameValuePairs.add(new BasicNameValuePair("v3", rate));
        nameValuePairs.add(new BasicNameValuePair("v4", number));
        try
        {
            result = HTTPCall.postData(APIResources.FOOD_PAC, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public String waterpac(String title, String service,String rate, String number)
    {
	
        String result = null;
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1",	title));
        nameValuePairs.add(new BasicNameValuePair("v2", service));
        nameValuePairs.add(new BasicNameValuePair("v3", rate));
        nameValuePairs.add(new BasicNameValuePair("v4", number));
        try
        {
            result = HTTPCall.postData(APIResources.WATER_PAC, nameValuePairs);
        } 
        catch (Exception e) 
        {
            // TODO: handle exception    
        }
        return result;
    }
	
	public  AllPackage getUserPackage(String utype) 
	{
        AllPackage result = new AllPackage();
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("v1", utype));
        String reqURL= APIResources.GET_USER_PACKAGE_URL;
 //       String reqURL=APIResources.GET_USER_PACKAGE_URL+"?utype="+utype;
        try {
			
        	String output = HTTPCall.postData(reqURL, nameValuePairs);
            Log.d("Rittz",output);
            result = new Gson().fromJson(output, AllPackage.class);
           
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
        
    }
}