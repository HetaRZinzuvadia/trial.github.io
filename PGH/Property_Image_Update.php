<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");


    // Get image string posted from Android App
    $base=$_REQUEST['image'];
    // Get file name posted from Android App
    $filename = $_REQUEST['filename'];
  
	$tid = $_REQUEST['pid'];
    $icount= $_REQUEST['icount']; 
	
	// Decode Image
    $binary=base64_decode($base);
    header('Content-Type: bitmap; charset=utf-8');
    // Images will be saved under 'www/imgupload/uplodedimages' folder
    $file = fopen('upload/property/'.$filename, 'wb');
    
	// Create File
	
    fwrite($file, $binary);
    fclose($file);
	
	
		if($icount== 1)
		{
			$fname="Image1";
		}
		else if($icount== 2)
		{
			$fname="Image2";
		}
		else if($icount== 3)
		{
			$fname="Image3";
		}
		else if($icount== 4)
		{
			$fname="Image4";
		}
		else
		{
			$fname="";
		}
	
	if($fname!="")
	{
			$query = "UPDATE tbl_property_adv SET $fname='upload/property/$filename' WHERE Property_ID='$tid'";	
			if(mysql_query($query))
			{
				echo "Updated";	
			}
			else 
			{
				echo "Error";	
			}
	}
	else
	{
	
	}	
?>