<!--shows tender report-->
<?php require_once('connection.php'); ?>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="report.css">
  <link rel="icon" href="favicon.ico" type="image" sizes="16x16">
  
</head>
<body>

<center>


<div class="container-fluid1">
<div class= "choices">
<img class="img1" src="pic.png">


<div class="btn-group">
  <a class="btn dropdown-toggle" data-toggle="dropdown">
   Products
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu">
   <li><a href="productMasterList.php"> Product Master List</a></li>
   <li><a href="stockStatusReport.php">Stock Status Report</a></li>
   <li><a href="categoryList.php">Category List</a></li>
   <li><a href="priceList.php">Price List</a></li>
   
  </ul>
</div>

<div class="btn-group">
  <a class="btn dropdown-toggle" data-toggle="dropdown">
    Sales
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu">
  <li><a href="salesReport.php">Sales Report</a></li>
   <li><a href="salesByProduct.php">Sales By Product</a></li>
   <li><a href="tenderReport.php">Tender Report</a></li>
   
   
  </ul>
</div>

<div class="btn-group">
  <a class="btn dropdown-toggle" data-toggle="dropdown">
   Delivery
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu">
   <li><a href="deliveryReport1.php"> Delivery Report</a></li>
  
   
  </ul>
</div>

<div class="btn-group">
  <a class="btn dropdown-toggle" data-toggle="dropdown">
   Supplier
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu">
   <li><a href="supplierMasterList.php"> Supplier  Master List</a></li>
  
   
  </ul>
</div>


<div class="btn-group">
  <a class="btn dropdown-toggle" data-toggle="dropdown">
 Branch
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu">
   <li><a href="branchList.php"> Store Branch List</a></li>
  
   
  </ul>
</div>

<div class="btn-group">
  <a class="btn dropdown-toggle" data-toggle="dropdown">
   Employee
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu">
   <li><a href="employeeList.php"> Employee Master List</a></li>
  
   
  </ul>
</div>

<div class="btn-group">
  <a class="button" href="tenderPrint.php"  target="_blank"><span class="glyphicon glyphicon-print"> Print</span>
  </a>
  
  </ul>
</div>
</div>

<div class="btn-group">
  <a class="btn dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-search"> Filter By:</span>
    <span class="caret"></span>
  </a>
  <ul class="dropdown-menu">
  <li><a href="tenderedReport1.php">Date:</a></li>

  
   
  </ul>
</div>

<div class="container">
    
<?php

                    //Include config file

                    require_once 'connection.php'; ?>
                    <br><br><br>

                    <?php
                    // Attempt select query execution

                    $sql = "SELECT  transaction.transaction_datetime, transaction.transaction_id, transaction.transaction_tender, transaction.transaction_change, employee.employee_id, employee.employee_firstname, branch.branch_id, branch.branch_name
                    FROM transaction, employee, branch
                    WHERE transaction.employee_id= employee.employee_id AND employee.branch_id = branch.branch_id
                    ORDER BY transaction_datetime ASC";



                    if($result = mysqli_query($conn, $sql)){

                        if(mysqli_num_rows($result) > 0){



                            echo "<center><table class='table'></center>";


                                echo "<center><table class='table'></center>";

                                echo "<thead>";
                                echo "<caption><h1>Tendered Report</h1></caption>";

                                    echo "<tr style='width: 100px;'>";


                                        echo "<th style='width: 150px;'>Date</th>";

                                        echo "<th>Transaction ID</th>";

                                        echo "<th>Tendered Amount</th>";

                                        echo "<th>Change</th>";

                                        echo "<th>Employee Name</th>";

                                         echo "<th>Branch Assigned</th>";

                                       

                         


                                    echo "</tr>";

                                echo "</thead>";

                                echo "<tbody>";


                                while($row = mysqli_fetch_assoc($result)){

                                    //print_r($row); 

                                    echo "<tr>";


                                        echo "<td> ", "<center>". $row['transaction_datetime'] . "</center>", "</td>";

                                        echo "<td> ","<center>". $row['transaction_id'] . "</center>","</td>";

                                        echo "<td> ", "<center>". $row['transaction_tender'] . "</center>","</td>";

                                        echo "<td> ", "<center>". $row['transaction_change'] . "</center>", "</td>";


                                        echo "<td> ","<center>". $row['employee_firstname'] ."</center>", "</td>";

                                        echo "<td> ","<center>". $row['branch_name'] ."</center>", "</td>";
                                        
                            

                                                  
                                    echo "</tr>";

                                }

                                echo "</tbody>";                            

                            echo "</table>";
                            // Free result set

                            mysqli_free_result($result);


                        } else{

                            echo "<p class='lead'><em>No records were found.</em></p>";

                        }

                    } else{

                        echo "ERROR: Could not able to execute $sql. " . mysqli_error($conn);

                    }

 

                    // Close connection

                    mysqli_close($conn);

                    ?>
            <ul class=date>
     <li><h3><b>Date/Time: </b><span id="date"></h3></li>
</ul>

<script>
    document.getElementById("date").innerHTML = formatAMPM();

        function formatAMPM() {
            var d = new Date(),
                minutes = d.getMinutes().toString().length == 1 ? '0'+d.getMinutes() : d.getMinutes(),
                hours = d.getHours().toString().length == 1 ? '0'+d.getHours() : d.getHours(),
                ampm = d.getHours() >= 12 ? 'pm' : 'am',
                months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],
                days = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
            return days[d.getDay()]+' '+months[d.getMonth()]+' '+d.getDate()+' '+d.getFullYear()+' '+hours+':'+minutes+ampm;
        }
    </script>


    <script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}
</script>
</div>
</div>


</center>
  

</body>
</html>
