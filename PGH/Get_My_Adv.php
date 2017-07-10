<?php

require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");		
		
$email = $_GET['email'];
$utype = $_GET['utype'];

if($email!="")
{
	if($utype=='Food')
	{
	$query = "SELECT * FROM user_reg1 WHERE Email='$email'";		
	}
	else if($utype=='Water')
	{
	$query = "SELECT * FROM user_reg1 WHERE Email='$email'";		
	}
	else if($utype=='Property')
	{
	$query = "SELECT * FROM user_reg WHERE Email='$email'";		
	}

	$result = mysql_query($query);

	if(mysql_num_rows($result) > 0) 
	{
		$row = mysql_fetch_array($result, MYSQL_ASSOC);
		$uid= $row['User_ID'];
		
	//	echo $uid;
	}
	else
	{
		
	}
	
}
if($uid!="")
{
	if($utype=="Property")
	{
		$sql = "select * from tbl_property_adv WHERE User_ID='$uid'";
	}
	else if($utype=="Food")
	{
		$sql = "select * from tbl_food_adv WHERE User_ID='$uid'";
	}
	else if($utype=="Water")
	{
		$sql = "select * from tbl_water_adv WHERE User_ID='$uid'";
	}	
					  
	$result = mysql_query($sql);

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

