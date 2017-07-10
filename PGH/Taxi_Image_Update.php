<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");


    // Get image string posted from Android App
    $base=$_REQUEST['image'];
    // Get file name posted from Android App
    $filename = $_REQUEST['filename'];
  
	$tid = $_REQUEST['tid'];
    $type= $_REQUEST['type'];
    $icount= $_REQUEST['icount']; 
	
	// Decode Image
    $binary=base64_decode($base);
    header('Content-Type: bitmap; charset=utf-8');
    // Images will be saved under 'www/imgupload/uplodedimages' folder
    $file = fopen('upload/taxi/'.$filename, 'wb');
    
	// Create File
	
    fwrite($file, $binary);
    fclose($file);
	
if($type!="")
{
	
	if($type== 1)
	{
		if($icount== 1)
		{
			$fname="Type1_1";
		}
		else if($icount== 2)
		{
			$fname="Type1_2";
		}
		else if($icount== 3)
		{
			$fname="Type1_3";
		}
		else if($icount== 4)
		{
			$fname="Type1_4";
		}
	}
	else if($type== 2)
	{
		if($icount== 1)
		{
			$fname="Type2_1";
		}
		else if($icount== 2)
		{
			$fname="Type2_2";
		}
		else if($icount== 3)
		{
			$fname="Type2_3";
		}
		else if($icount== 4)
		{
			$fname="Type2_4";
		}
	}
	else if($type== 3)
	{
		if($icount== 1)
		{
			$fname="Type3_1";
		}
		else if($icount== 2)
		{
			$fname="Type3_2";
		}
		else if($icount== 3)
		{
			$fname="Type3_3";
		}
		else if($icount== 4)
		{
			$fname="Type3_4";
		}
	}
	else
	{
		$fname="";
	}
	
	if($fname!="")
	{
			$query = "UPDATE tbl_taxi_images SET $fname='upload/taxi/$filename' WHERE Taxi_ID='$tid'";	
			if(mysql_query($query))
			{
				echo "Updated";	
			}
			else 
			{
				echo "Error";	
			}
	}
}
else
{
	
}
	
	
	
	
?>