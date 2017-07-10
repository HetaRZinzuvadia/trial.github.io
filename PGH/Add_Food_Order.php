<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$tid =$_POST['v1'];
$email =$_POST['v2'];
$date =$_POST['v3'];
$time =$_POST['v4'];
$address =$_POST['v5'];
$oid =$_POST['v6'];

if($email!="")
{
	$query = "SELECT * FROM user_reg WHERE Email='$email'";		

	$result = mysql_query($query);

	if(mysql_num_rows($result) > 0) 
	{
		$row = mysql_fetch_array($result, MYSQL_ASSOC);
		$uid= $row['User_ID'];
		
//		echo $uid;
	}
	else
	{
		
	}
}

if($uid!="")
{

	$sql = "INSERT INTO tbl_food_order(Adv_ID,User_ID,Owner_ID,Order_Date,Order_Time,Order_Address) VALUES 
										('$tid','$uid', '$oid','$date','$time','$address')";
	if(mysql_query($sql))
	{
				echo"Order Placed";
	}
	else
	{
			echo"";	
	}
}
else
{
		echo"";
}
// close connection
mysql_close($conn);
?>