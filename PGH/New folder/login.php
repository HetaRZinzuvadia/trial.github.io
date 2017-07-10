<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$username = $_POST['useremail'];
$userpass = $_POST['userpass'];
 
$query = "SELECT * FROM user1_reg WHERE Email='$username' AND Password='$userpass' ";
$result = mysql_query($query);

if (mysql_num_rows($result) > 0) 
{
    $row = mysql_fetch_array($result, MYSQL_ASSOC);

    echo "User1";	
}
else 
{
	$query = "SELECT * FROM user_reg WHERE Email='$username' AND Password='$userpass' ";
	$result = mysql_query($query);

	if (mysql_num_rows($result) > 0) 
	{
		$row = mysql_fetch_array($result, MYSQL_ASSOC);

    echo "User";	
	}
	else 
	{
					echo "Invalid User Name or Password !";
	}	
}
mysql_close($conn);
?>