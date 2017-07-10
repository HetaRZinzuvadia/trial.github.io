<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$tid =$_POST['v1'];
$type =$_POST['v2'];
$stype =$_POST['v3'];
$sac =$_POST['v4'];
$pac =$_POST['v5'];
$snac =$_POST['v6'];
$pnac =$_POST['v7'];


if($tid!="")
{
	if($type=="Type1")
	{
			$query = "UPDATE tbl_taxi_rate SET Type1='$stype', Type1_AC='$sac', Type1_AC_Rate='$pac',Type1_NonAC='$snac', Type1_NonAC_Rate='$pnac', Status='Yes' WHERE Taxi_ID='$tid'";
			
			if(mysql_query($query))
			{
					$query = "SELECT * FROM tbl_taxi_rate WHERE Taxi_ID='$tid'";
					$result = mysql_query($query);	
					
					if (mysql_num_rows($result) > 0) 
					{	
					$row = mysql_fetch_array($result, MYSQLI_ASSOC);
								$type1=$row['Type1'];
								$type2=$row['Type2'];
								$type3=$row['Type3'];
			
			 				echo"type1"; echo $type1;
							echo"type2"; echo $type2;
							echo"type3"; echo $type3; 
					}
					else
					{
					}
					
					if($type1=="No" && $type2=="No" && $type3=="No")
					{
							$query = "UPDATE tbl_taxi_rate SET Status='No' WHERE Taxi_ID='$tid'";
			
							if(mysql_query($query))
							{
								echo "No";
							}
							else 
							{
								echo"Yes";
							}
					}
					else
					{
						echo "Updated";	
					}

			}
			else 
			{
				echo "Error";	
			}
	}
	else if($type=="Type2")
	{
			$query = "UPDATE tbl_taxi_rate SET Type2='$stype', Type2_AC='$sac', Type2_AC_Rate='$pac',Type2_NonAC='$snac', Type2_NonAC_Rate='$pnac', Status='Yes' WHERE Taxi_ID='$tid'";
			
			if(mysql_query($query))
			{
									$query = "SELECT * FROM tbl_taxi_rate WHERE Taxi_ID='$tid'";
					$result = mysql_query($query);	
					
					if (mysql_num_rows($result) > 0) 
					{	
					$row = mysql_fetch_array($result, MYSQLI_ASSOC);
								$type1=$row['Type1'];
								$type2=$row['Type2'];
								$type3=$row['Type3'];
			
			 				echo"type1"; echo $type1;
							echo"type2"; echo $type2;
							echo"type3"; echo $type3; 
					}
					else
					{
					}
					
					if($type1=="No" && $type2=="No" && $type3=="No")
					{
							$query = "UPDATE tbl_taxi_rate SET Status='No' WHERE Taxi_ID='$tid'";
			
							if(mysql_query($query))
							{
								echo "No";
							}
							else 
							{
								echo"Yes";
							}
					}
					else
					{
						echo "Updated";	
					}

			}
			else 
			{
				echo "Error";	
			}
	}
	else if($type=="Type3")
	{
			$query = "UPDATE tbl_taxi_rate SET Type3='$stype', Type3_AC='$sac', Type3_AC_Rate='$pac',Type3_NonAC='$snac', Type3_NonAC_Rate='$pnac', Status='Yes' WHERE Taxi_ID='$tid'";
			
			if(mysql_query($query))
			{
									$query = "SELECT * FROM tbl_taxi_rate WHERE Taxi_ID='$tid'";
					$result = mysql_query($query);	
					
					if (mysql_num_rows($result) > 0) 
					{	
					$row = mysql_fetch_array($result, MYSQLI_ASSOC);
								$type1=$row['Type1'];
								$type2=$row['Type2'];
								$type3=$row['Type3'];
			
			 				echo"type1"; echo $type1;
							echo"type2"; echo $type2;
							echo"type3"; echo $type3; 
					}
					else
					{
					}
					
					if($type1=="No" && $type2=="No" && $type3=="No")
					{
							$query = "UPDATE tbl_taxi_rate SET Status='No' WHERE Taxi_ID='$tid'";
			
							if(mysql_query($query))
							{
								echo "No";
							}
							else 
							{
								echo"Yes";
							}
					}
					else
					{
						echo "Updated";	
					}

			}
			else 
			{
				echo "Error";	
			}
	}
	else
	{
		
	}
}
else
{
	
}	
// close connection
mysql_close($conn);
?>