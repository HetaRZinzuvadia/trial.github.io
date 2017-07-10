package com.example.pgh.API;

public class APIResources 
{
	
	public static final String BASE_URL = "http://192.168.43.67/PGH/";		

	public static final String GET_STATE_URL = BASE_URL+"Get_State.php";

	public static final String POST_LOGIN_URL = BASE_URL+"Login.php";

	public static final String POST_USER_REG_URL = BASE_URL+"User_Reg.php";

	public static final String POST_REG_URL = BASE_URL+"User_Reg1.php";

	public static final String GET_AREA_URL = BASE_URL+"Get_Area.php";

	//taxi 

	public static final String POST_TAXI_RATE_UPDATE_URL = BASE_URL+"Taxi_Rate_Update.php";

	public static final String POST_TAXI_IMAGE_UPDATE_URL = BASE_URL+"Taxi_Image_Update.php";

	public static final String POST_TAXI_DATA_CHECK_URL = BASE_URL+"Taxi_Data_Check.php";

	public static final String GET_TAXI_DATA_URL = BASE_URL+"Get_Taxi_Data.php";

	public static final String GET_TAXI_DETAILS_URL = BASE_URL+"Get_Taxi_Details.php";

		
	//Property

	public static final String POST_PROPERTY_ADV_URL = BASE_URL+"Add_Property_Adv.php";

	public static final String POST_PROPERTY_IMAGE_UPDATE_URL = BASE_URL+"Property_Image_Update.php";

	public static final String POST_PROPERTY_IMAGE_UPDATE_FINISH_URL = BASE_URL+"Property_Image_Update1.php";

	//Water

	public static final String POST_WATER_ADV_URL = BASE_URL+"Add_Water_Adv.php";

	public static final String POST_WATER_IMAGE_UPDATE_URL = BASE_URL+"Water_Image_Update.php";

	public static final String POST_WATER_IMAGE_UPDATE_FINISH_URL = BASE_URL+"Water_Image_Update1.php";

	//food

	public static final String POST_FOOD_ADV_URL = BASE_URL+"Add_Food_Adv.php";

	public static final String POST_FOOD_IMAGE_UPDATE_URL = BASE_URL+"Food_Image_Update.php";

	public static final String POST_FOOD_IMAGE_UPDATE_FINISH_URL = BASE_URL+"Food_Image_Update1.php";

	//user

	public static final String GET_WATER_ADV_URL = BASE_URL+"Get_Water_Adv.php";

	public static final String GET_FOOD_ADV_URL = BASE_URL+"Get_Food_Adv.php";

	public static final String GET_PROPERTY_ADV_URL = BASE_URL+"Get_Property_Adv.php";

	public static final String GET_USER_ADV_URL = BASE_URL+"Get_My_Adv.php";

	//order
	
	public static final String POST_TAXI_ORDER_URL = BASE_URL+"Add_Taxi_Order.php";

	public static final String POST_FOOD_ORDER_URL = BASE_URL+"Add_Food_Order.php";
	
	public static final String POST_WATER_ORDER_URL = BASE_URL+"Add_Water_Order.php";
	
	public static final String POST_PROPERTY_ORDER_URL = BASE_URL+"Add_Property_Order.php";

	public static final String GET_USER_ORDER_URL = BASE_URL+"Get_User_Order.php";
	
	public static final String GET_TAXIFAC_ORDER= BASE_URL+"Get_taxifacord.php";
	
	public static final String GET_FOODFAC_ORDER= BASE_URL+"Get_foodfacord.php";
	
	public static final String GET_WATERFAC_ORDER= BASE_URL+"Get_waterfacord.php";
	
	public static final String USERCANCEL_ORDER= BASE_URL+"Get_cancelOrder.php";
	
	//package
	public static final String FOOD_PAC = BASE_URL+"Food_pac.php";
	
	public static final String WATER_PAC = BASE_URL+"Water_pac.php";
	
	public static final String GET_USER_PACKAGE_URL = BASE_URL+ "Get_User_Package.php";
}
