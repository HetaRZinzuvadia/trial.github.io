<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$title =$_POST['v1'];
$service =$_POST['v2'];
$rate =$_POST['v3'];
$number =$_POST['v4'];
/*

$title ="heta";
$service ="heta";
$rate ="heta";
$number ="heta";*/

//echo $title;
if($title!="")
{
	$query = "INSERT INTO tbl_water_pac(title,service,rate,number) VALUES ('$title','$service','$rate','$number') ";		
	
	//echo $query;
			$result = mysql_query($query);	
			if ($result)  
			{	
				echo "Successfully added your package.";
			}				
			else
			{
				echo "error";
			}
}// close connection
mysql_close($conn);
?>