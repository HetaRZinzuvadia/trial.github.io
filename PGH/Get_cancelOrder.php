<?php
require_once 'dbconfig.php';
$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");		
$email = $_POST['email'];
$utype = $_POST['utype'];
$aid = $_POST['aid'];

if($email!="")
{
	$query = "SELECT * FROM user_reg WHERE Email='$email'";		
	$result = mysql_query($query);
	if(mysql_num_rows($result) > 0) 
	{
		$row = mysql_fetch_array($result, MYSQL_ASSOC);
		$uid= $row['User_ID'];
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
	$query = "DELETE FROM tbl_food_order 
				WHERE User_ID='$uid' AND Adv_ID='$aid' ";		
	}
	if($utype=='Water')
	{
	$query = "DELETE FROM tbl_water_order 
				WHERE User_ID='$uid' AND Adv_ID='$aid' ";		
	}
	if($utype=='Taxi')
	{
	$query = "DELETE FROM tbl_taxi_order 
				WHERE User_ID='$uid' AND Adv_ID='$aid' ";		
	}
	
	echo $query;
	$result = mysql_query($query);

	if($result!= null)
	{
		echo "Your order is deleted.";		
	}
	else
	{
			echo "Retry".mysql_error();
	}
}	
mysql_close();
?>