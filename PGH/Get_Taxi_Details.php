<?php

require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$type = $_GET['type'];
$stype = $_GET['stype'];

if($type=="type1")
{
	
	if($stype=="All")
	{
		$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type1,Type1_AC,Type1_AC_Rate,Type1_NonAC,Type1_NonAC_Rate,
			tbl_taxi_images.Type1_1,tbl_taxi_images.Type1_2,tbl_taxi_images.Type1_3,tbl_taxi_images.Type1_4,
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type1='Yes'";
		
	}
	else if($stype=="AC")
	{
		$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type1,Type1_AC,Type1_AC_Rate,Type1_NonAC,Type1_NonAC_Rate,
			tbl_taxi_images.Type1_1,tbl_taxi_images.Type1_2,tbl_taxi_images.Type1_3,tbl_taxi_images.Type1_4,
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type1='Yes' AND tbl_taxi_rate.Type1_AC='Yes'";
	}
	else if($stype=="NAC")
	{
		$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type1,Type1_AC,Type1_AC_Rate,Type1_NonAC,Type1_NonAC_Rate,
			tbl_taxi_images.Type1_1,tbl_taxi_images.Type1_2,tbl_taxi_images.Type1_3,tbl_taxi_images.Type1_4,
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type1='Yes' AND tbl_taxi_rate.Type1_NonAC='Yes'";
	}

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
else if($type=="type2")
{	
	if($stype=="All")
	{
			$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type2,Type2_AC,Type2_AC_Rate,Type2_NonAC,Type2_NonAC_Rate,
			tbl_taxi_images.Type2_1,tbl_taxi_images.Type2_2,tbl_taxi_images.Type2_3,tbl_taxi_images.Type2_4,
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type2='Yes' ";
	}
	else if($stype=="AC")
	{
			$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type2,Type2_AC,Type2_AC_Rate,Type2_NonAC,Type2_NonAC_Rate,
			tbl_taxi_images.Type2_1,tbl_taxi_images.Type2_2,tbl_taxi_images.Type2_3,tbl_taxi_images.Type2_4,
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type2='Yes' AND tbl_taxi_rate.Type2_AC='Yes' ";
	}
	else if($stype=="NAC")
	{
			$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type2,Type2_AC,Type2_AC_Rate,Type2_NonAC,Type2_NonAC_Rate,
			tbl_taxi_images.Type2_1,tbl_taxi_images.Type2_2,tbl_taxi_images.Type2_3,tbl_taxi_images.Type2_4,
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type2='Yes' AND tbl_taxi_rate.Type2_NonAC='Yes' ";
	}
		
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
else if($type=="type3")
{
	if($stype=="All")
	{
			$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type3,Type3_AC,Type3_AC_Rate,Type3_NonAC,Type3_NonAC_Rate, 
			tbl_taxi_images.Type3_1,tbl_taxi_images.Type3_2,tbl_taxi_images.Type3_3,tbl_taxi_images.Type3_4, 
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type3='Yes'";

	}
	if($stype=="AC")
	{
			$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type3,Type3_AC,Type3_AC_Rate,Type3_NonAC,Type3_NonAC_Rate, 
			tbl_taxi_images.Type3_1,tbl_taxi_images.Type3_2,tbl_taxi_images.Type3_3,tbl_taxi_images.Type3_4, 
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type3='Yes' AND tbl_taxi_rate.Type3_AC='Yes'";

	}
	if($stype=="NAC")
	{
			$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type3,Type3_AC,Type3_AC_Rate,Type3_NonAC,Type3_NonAC_Rate, 
			tbl_taxi_images.Type3_1,tbl_taxi_images.Type3_2,tbl_taxi_images.Type3_3,tbl_taxi_images.Type3_4, 
			user_reg1.Title FROM tbl_taxi_rate INNER JOIN user_reg1 ON tbl_taxi_rate.Taxi_ID=user_reg1.User_ID INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID WHERE tbl_taxi_rate.Type3='Yes' AND tbl_taxi_rate.Type3_NonAC='Yes'";

	}
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

