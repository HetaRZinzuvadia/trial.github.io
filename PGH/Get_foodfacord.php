<?php

require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");		
		
$email = $_GET['email'];
if($email!="")
{
	$query = "SELECT user_reg.Name, user_reg.Mobile, tbl_food_order.Order_Date, tbl_food_order.Order_Time, tbl_food_order.Order_Address 
				FROM `user_reg`, `tbl_food_order` 
				WHERE user_reg.User_ID= tbl_food_order.User_ID";		

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
mysql_close();		
}

?>