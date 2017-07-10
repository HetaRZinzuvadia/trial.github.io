<?php

if(isset($_POST['search']))
{
    $valueToSearch = $_POST['valueToSearch'];
    // search in all table columns
    // using concat mysql function
    $query = "SELECT * FROM `pharmcy` WHERE CONCAT( `Pha_Name`, `Pha_Address`, `Area1`) LIKE '%".$valueToSearch."%'";
    $search_result = filterTable($query);
    
}
 else {
    $query = "SELECT * FROM `pharmcy`";
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
        <title>pharmacy</title>
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
                     <th>Pha_Name</th>
                    <th>Pha_Address</th>
                    
                </tr>

      <!-- populate table from mysql database -->
                <?php while($row = mysqli_fetch_array($search_result)):?>
                <tr>
				 <td><?php echo $row['Area1'];?></td>
                     <td><?php echo $row['Pha_Name'];?></td>
                    <td><?php echo $row['Pha_Address'];?></td>
                   
                </tr>
                <?php endwhile;?>
				
				 <form action="Pharmcy.php" method="post">
            <input type="text" name="valueToSearch" placeholder="Value To Search"><br><br>
            <input type="submit" name="search"  value="Filter"><br><br>
            
            </table>
        </form>
        
    </body>
</html>