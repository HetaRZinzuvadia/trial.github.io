<?php

require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$user = $_GET['user'];


if($user=='Admin')
{
$sql = "SELECT * FROM user1_reg WHERE Status='Pending'";

		$result = mysql_query($sql);

		if(mysql_num_rows($result) > 0)
		{
		while( $row = mysql_fetch_assoc($result)) 
		{	
		$output['data'][] = $row;
		}
	
		print(json_encode($output));
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


?>

