<?php
require_once 'dbconfig.php';

$conn = mysql_connect("$host","$username","$password");
mysql_select_db("$dbname");



// close connection
mysql_close($conn);


?>
<html>
<head>
<style>
.button {
    background-color: #E5C536; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

.button1 {border-radius: 22px;}
.button2 {border-radius: 4px;}
.button3 {border-radius: 8px;}
.button4 {border-radius: 12px;}
.button5 {border-radius: 50%;}
</style>

<title>hello</title>

</head>   
<body>

   <b> Area vise location! </b>

<ul>
  <li><button type="button"  class="button button1" ><a href="Restaurant.php">Restaurant </a></button></li>
 <br>
  <li><button type="button" class="button button1"><a href="Grocery.php">GroceryStore</a></button></li>
<br>
  <li><button type="button" class="button button1"><a href="Pharmcy.php">Pharmacy</a></button></li>
</ul>
<small> <mark> *We are only <ins>providing Address</ins> on selected filed </mark></small> 
</body>
</html>
