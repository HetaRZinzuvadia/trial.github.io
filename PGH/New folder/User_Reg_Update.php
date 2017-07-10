<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");

$userid = $_POST['userid'];
$userstatus=$_POST['userstatus'];

if($userstatus == 'Approve')
{
$query = "UPDATE user1_reg SET Password='1234',Status='Approve' WHERE User1_ID='$userid'";
$result = mysql_query($query);

if(mysql_query($query)) 
{
    echo "User Approved";	
}
else 
{
    echo "Error";	

}
}
else if($userstatus =='Reject')
{
$query = "UPDATE user1_reg SET Status='Reject' WHERE User1_ID='$userid'";
$result = mysql_query($query);

if(mysql_query($query))
{
    echo "User rejected";	
}
else 
{
    echo "Error";	

}
}
else
{
echo "Error";
} 

mysql_close($conn);
?>