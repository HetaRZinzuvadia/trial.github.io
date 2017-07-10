<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$pid =$_POST['v1'];

if($pid!="")
{
			$query = "UPDATE tbl_property_adv SET Status='Active' WHERE Property_ID='$pid'";	
			if(mysql_query($query))
			{
				echo "Active";	
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