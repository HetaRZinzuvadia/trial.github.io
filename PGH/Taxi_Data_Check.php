<?php

require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$tid = $_POST['v1'];


if($tid!="")
{
	
		$query = "SELECT * FROM tbl_taxi_rate WHERE Taxi_ID='$tid'";

		$result = mysql_query($query);	
					
					if (mysql_num_rows($result) > 0) 
					{	
					$row = mysql_fetch_array($result, MYSQLI_ASSOC);

					$status=$row['Status'];
			
						echo $status;
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

