<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$email =$_POST['v1'];
$title =$_POST['v2'];
$desc =$_POST['v3'];
$facility =$_POST['v4'];
$area =$_POST['v5'];
$rent =$_POST['v6'];
$contact =$_POST['v7'];


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
		
	}
}

if($uid!="")
{
	$sql = "INSERT INTO tbl_property_adv(User_ID,Title,Description,Facility,Area,Rent,Contact,Status) VALUES ('$uid','$title', '$desc','$facility','$area','$rent','$contact','Image')";
	if(mysql_query($sql))
	{
			$query = "SELECT * FROM tbl_property_adv WHERE User_ID='$uid' AND Status='Image'";
			
			$result = mysql_query($query);	
					
			if (mysql_num_rows($result) > 0) 
			{	
				$row = mysql_fetch_array($result, MYSQLI_ASSOC);
				$pid=$row['Property_ID'];
				
				echo $pid;
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
}
else
{
		echo"";
}

// close connection
mysql_close($conn);
?>