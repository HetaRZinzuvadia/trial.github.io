<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$tid =$_POST['v1'];
$email =$_POST['v2'];
$type =$_POST['v3'];
$type1 =$_POST['v4'];
$date =$_POST['v5'];
$time =$_POST['v6'];
$address =$_POST['v7'];

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

	$sql = "INSERT INTO tbl_taxi_order(Taxi_ID,User_ID,Type,Capacity,Order_Date,Order_Time,Order_Address) VALUES 
										('$tid','$uid', '$type','$type1','$date','$time','$address')";
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