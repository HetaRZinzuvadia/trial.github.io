<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$title = $_POST['v1'];
$name = $_POST['v2'];
$email = $_POST['v3'];
$mobile =$_POST['v4'];
$role =$_POST['v5'];

$query = "SELECT Email FROM user_reg1 WHERE Email='$email'";
$result = mysql_query($query);

if(mysql_num_rows($result) > 0)	
{

    $row = mysql_fetch_array($result, MYSQL_ASSOC);

	echo"Email is Already Registered.";
		
}
else
{
	$sql = "INSERT INTO user_reg1(Title,Name,Email,Mobile,Role,Status) VALUES ('$title','$name','$email','$mobile','$role','Pending')";
	if(mysql_query($sql))
	{		
		if($role=="Taxi")
		{
			
			$sql="SELECT * FROM user_reg1 WHERE Email='$email'";
	
			$result= mysql_query($sql);
	
			if(mysql_num_rows($result) > 0)
			{
				$row = mysql_fetch_array($result, MYSQLI_ASSOC);
				$tid= $row['User_ID'];
				
				if($tid!="")
				{
					$sql = "INSERT INTO tbl_taxi_rate(Taxi_ID,Status) VALUES ('$tid','No')";
					if(mysql_query($sql))
					{
						$sql = "INSERT INTO tbl_taxi_images(Taxi_ID) VALUES ('$tid')";
						if(mysql_query($sql))
						{
					    	echo "Registration Successful..! Please Wait For Conformation";			
						}
						else
						{
							echo "3";
						}
					}
					else
					{	
						echo"2";
					}
				}
				else
				{
						echo"1";
				}
			}
		}
		else
		{
			    	echo "Registration Successful..! Please Wait For Conformation";
		}
	}
	else
	{
		echo"ERROR ";
	}
} 
 
// close connection
mysql_close($conn);
?>