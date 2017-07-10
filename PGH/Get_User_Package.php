<?php
require_once 'dbconfig.php';
$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");	
$utype = $_POST['v1'];

if($utype=='Food')
	{
	$query = "SELECT title,service,rate,number FROM tbl_food_pac";		
	}
else if($utype=='Water')
	{
	$query="SELECT title,service,rate,number FROM tbl_water_pac";
	}
else
	{
		$query= "";
	}
//	echo $query;
	$result = mysql_query($query);

	if(mysql_num_rows($result)> 0)
	{
		while( $row = mysql_fetch_assoc($result)) 
		{	
				$output['data'][] = $row;	
		}	
		print(json_encode($output));
	}
	else
	{
			echo "";
	}
?>