<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$username = $_POST['v1'];
$userpass = $_POST['v2'];
 
$query = "SELECT * FROM user_reg1 WHERE Email='$username' AND Password='$userpass' ";

$result = mysql_query($query);

if(mysql_num_rows($result) > 0) 
{
		$row = mysql_fetch_array($result, MYSQL_ASSOC);
		$role = $row['Role'];
		
		echo $role;
}
else 
{
	$query = "SELECT * FROM user_reg WHERE Email='$username' AND Password='$userpass' ";
	$result = mysql_query($query);

	if(mysql_num_rows($result) > 0) 
	{
		$row = mysql_fetch_array($result, MYSQL_ASSOC);
		$role = $row['Role'];
		
		echo $role;
	
	}
	else 
	{
					echo "Invalid Email or Password !".mysql_error();
	}	
}

mysql_close($conn);
?>