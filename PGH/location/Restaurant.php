<?php

if(isset($_POST['search']))
{
    $valueToSearch = $_POST['valueToSearch'];
    // search in all table columns
    // using concat mysql function
    $query = "SELECT * FROM `restaurant` WHERE CONCAT( `Res_Name`, `Res_Address`, `Area1`) LIKE '%".$valueToSearch."%'";
    $search_result = filterTable($query);
    
}
 else {
    $query = "SELECT * FROM `restaurant`";
    $search_result = filterTable($query);
}

// function to connect and execute the query
function filterTable($query)
{
    $connect = mysqli_connect("localhost", "root", "", "pgh");
    $filter_Result = mysqli_query($connect, $query);
    return $filter_Result;
}

?>

<!DOCTYPE html>
<html>
    <head>
        <title>Restaurant</title>
        <style>
          table {
    border-collapse: collapse;
    width: 35%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
        </style>
    </head>
    <body>
        
       
            <table>
                <tr>
				<th>Area</th>
                     <th>Res_Name</th>
                    <th>Res_Address</th>
                    
                </tr>

      <!-- populate table from mysql database -->
                <?php while($row = mysqli_fetch_array($search_result)):?>
                <tr>
				 <td><?php echo $row['Area1'];?></td>
                     <td><?php echo $row['Res_Name'];?></td>
                    <td><?php echo $row['Res_Address'];?></td>
                   
                </tr>
                <?php endwhile;?>
				
				 <form action="Restaurant.php" method="post">
            <input type="text" name="valueToSearch" placeholder="Value To Search"><br><br>
            <input type="submit" name="search"  value="Filter"><br><br>
            
            </table>
        </form>
        
    </body>
</html>