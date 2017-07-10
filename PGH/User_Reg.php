<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$name = $_POST['v1'];
$email = $_POST['v2'];
$mobile =$_POST['v3'];
$password =$_POST['v4'];
$utype=$_POST['v5'];


$query = "SELECT Email FROM user_reg WHERE Email='$email'";
$result = mysql_query($query);

if(mysql_num_rows($result) > 0)	
{

    $row = mysql_fetch_array($result, MYSQL_ASSOC);

	echo"Email is Already Registered.";
		
}
else
{
	$sql = "INSERT INTO user_reg(Name,Email,Mobile,Password,Role) VALUES ('$name','$email','$mobile','$password','$utype')";

	echo $sql;
	if(mysql_query($sql))
	{
    	echo "Registration Successful..!";
	}
	else
	{
		echo"ERROR ".mysql_error();
	}
} 


// close connection
mysql_close($conn);
?>