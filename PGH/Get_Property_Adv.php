<?php

require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");		

$area = $_GET['sarea'];
$stype = $_GET['stype'];
		
if($area!="" && $stype!="")
{
	if($area=="All")
	{
		if($stype=="L2H")
		{
					$sql = "select * from tbl_property_adv ORDER BY Rent ASC";
		}
		else
		{
					$sql = "select * from tbl_property_adv ORDER BY Rent DESC";
		}
	}
	else
	{
		if($stype=="L2H")
		{
					$sql = "select * from tbl_property_adv WHERE Area='$area' ORDER BY Rent ASC";
		}
		else
		{
					$sql = "select * from tbl_property_adv WHERE Area='$area' ORDER BY Rent DESC";
		}
	}
	
		$result = mysql_query($sql);

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
	
}	
	
			
?>

