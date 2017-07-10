<?php

require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");		
		
$email = $_GET['email'];
$utype = $_GET['utype'];

if($email!="")
{
	$query = "SELECT * FROM user_reg WHERE Email='$email'";		

	$result = mysql_query($query);

	if(mysql_num_rows($result) > 0) 
	{
		$row = mysql_fetch_array($result, MYSQL_ASSOC);
		$uid= $row['User_ID'];
		
	//	echo $uid;
	}
	else
	{
		$uid="";
	}
}

if($uid!="")
{
	if($utype=='Food')
	{
	$query = "SELECT Food_Order_ID,Adv_ID,tbl_food_order.User_ID,Owner_ID,Order_Date,Order_Time,Order_Address,tbl_food_order.Status,user_reg1.Title,
		     tbl_food_adv.Rate, tbl_food_adv.Contact  
			 FROM tbl_food_order
			 INNER JOIN user_reg1 ON tbl_food_order.Owner_ID=user_reg1.User_ID
			 INNER JOIN tbl_food_adv ON tbl_food_order.Adv_ID=tbl_food_adv.Food_ID
			 WHERE tbl_food_order.User_ID='$uid'";		
	}
	else if($utype=='Water')
	{
	$query = "SELECT Water_Order_ID,Adv_ID,tbl_water_order.User_ID,Owner_ID,Order_Date,Order_Time,Order_Address,tbl_water_order.Status,user_reg1.Title,
			  tbl_water_adv.Rate, tbl_water_adv.Contact
			 FROM tbl_water_order
			 INNER JOIN user_reg1 ON tbl_water_order.Owner_ID=user_reg1.User_ID
			 INNER JOIN tbl_water_adv ON tbl_water_order.Adv_ID=tbl_water_adv.Water_ID
			 WHERE tbl_water_order.User_ID='$uid'";		
	}
	else if($utype=='Taxi')
	{
	$query = "SELECT TaxiOrder_ID,tbl_taxi_order.Taxi_ID,tbl_taxi_order.User_ID,Type,Capacity,Order_Date,Order_Time,Order_Address,
			user_reg1.Title, user_reg1.Mobile
			FROM tbl_taxi_order
			INNER JOIN  user_reg1 ON tbl_taxi_order.Taxi_ID=user_reg1.User_ID 
				 WHERE tbl_taxi_order.User_ID='$uid'";		
	}
	else
	{
		$query="";
	}
	
//	echo $query;
	$result = mysql_query($query);

	if(mysql_num_rows($result)> 0)
	{
		while( $row = mysql_fetch_assoc($result)) 
		{	
				$output['data'][] = $row;	
		}	
		print(json_encode($output));
				
	}
	else
	{
			echo "";
	}
}	
?>

