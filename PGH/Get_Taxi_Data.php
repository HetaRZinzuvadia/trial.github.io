<?php

require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$tid = $_GET['tid'];


if($tid!="")
{
	
	$sql = "SELECT tbl_taxi_rate.Taxi_ID,
			Type1,Type1_AC,Type1_AC_Rate,Type1_NonAC,Type1_NonAC_Rate,
			Type2,Type2_AC,Type2_AC_Rate,Type2_NonAC,Type2_NonAC_Rate,
			Type3,Type3_AC,Type3_AC_Rate,Type3_NonAC,Type3_NonAC_Rate, 
			tbl_taxi_images.Type1_1,tbl_taxi_images.Type1_2,tbl_taxi_images.Type1_3,tbl_taxi_images.Type1_4,
			tbl_taxi_images.Type2_1,tbl_taxi_images.Type2_2,tbl_taxi_images.Type2_3,tbl_taxi_images.Type2_4,
			tbl_taxi_images.Type3_1,tbl_taxi_images.Type3_2,tbl_taxi_images.Type3_3,tbl_taxi_images.Type3_4 
			FROM tbl_taxi_rate INNER JOIN tbl_taxi_images ON tbl_taxi_images.Taxi_ID=tbl_taxi_rate.Taxi_ID
			WHERE tbl_taxi_rate.Taxi_ID=$tid";


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

