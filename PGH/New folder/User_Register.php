<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$name = $_POST['name'];
$city =$_POST['city'];
$address =$_POST['address'];
$email = $_POST['email'];
$mobile =$_POST['mobile'];
$password =$_POST['password'];

$query = "SELECT Email FROM user_reg WHERE Email='$email'";
$result = mysql_query($query);

if(mysql_num_rows($result) > 0)	
{

    	$row = mysql_fetch_array($result, MYSQL_ASSOC);

	echo"Email is Already Registered.";
		
}
else
{
	$sql = "INSERT INTO user_reg(Name,City,Address,Email,Mobile,Password) VALUES ('$name','$city', '$address','$email','$mobile','$password')";
	if(mysql_query($sql))
	{
    	echo "Registration Successful..!";
	}
	else
	{
		echo"ERROR ";
	}
} 
 
// close connection
mysql_close($conn);
?>