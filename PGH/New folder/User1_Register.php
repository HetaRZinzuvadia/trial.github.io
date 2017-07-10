<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$name = $_POST['name'];
$city =$_POST['city'];
$address =$_POST['address'];
$email = $_POST['email'];
$mobile =$_POST['mobile'];
$facility =$_POST['facility'];

$query = "SELECT Email FROM user1_reg WHERE Email='$email'";
$result = mysql_query($query);

if(mysql_num_rows($result) > 0)	
{

    $row = mysql_fetch_array($result, MYSQL_ASSOC);

	echo"Email is Already Registered.";
		
}
else
{
	$sql = "INSERT INTO user1_reg(Name,City,Address,Email,Mobile,Facility,Status) VALUES ('$name','$city', '$address','$email','$mobile','$facility','Pending')";
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