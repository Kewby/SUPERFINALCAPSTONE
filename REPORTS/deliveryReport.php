<!--shows delivery Report-->
<?php require_once('connection.php'); session_start();?>

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
  <a class="button" href="deliveryPrint.php"  target="_blank"><span class="glyphicon glyphicon-print"> Print</span>
 
  </a>
  
  </ul>
</div>
</div>




<div class="container">
<form action  = 'deliveryReport.php' method="GET">

          Select date: <input type="date" name="startdate"  
                        value="<?php if(isset($_GET['startdate'])) echo $_GET['startdate']; ?>"> to 

            <input type="date" name="enddate" 

                value="<?php if(isset($_GET['enddate'])) echo $_GET['enddate']; ?>">
          
            <input type="submit" value="generate" name="generate" >
          
            <div>
        
        </form>


        <?php if(isset($_GET['generate'])){
          $_SESSION['generate']= $_GET['generate'];
         $_SESSION['start']= $_GET['startdate'];
         $_SESSION['end']= $_GET['enddate'];
          
         //echo  $_SESSION['start'];
         //echo  $_SESSION['end'];
                  //echo  $_SESSION['generate'];




          }
          ?>

      
<center><table class='table'>


                                <caption>
                                <h1>Delivery List Report</h1>
                                </caption>

                                    <tr style='width: 100px;'>

                                        <th style='width: 150px;'>Delivery Id</th>

                                        <th>Date & Time</th>

                                       <th>Product Name</th>

                                       
                                        <th>Product Type</th>

                                        <th>Unit Price</th>

                                        <th>Number of Units</th>

                                       <th>Unit of Measure</th>

                                        <th>Supplier Name</th>

                                       <th>Branch Name</th>

                                      <th>Employee Name</th>

                                      <th>Total Cost Amount</th>

                                      <th>Delete Status</th>

</tr>

<tbody>
 
                <tr>


<?php

                    //Include config file

                    require_once 'connection.php'; ?>
                    <br><br><br>

                    <?php
                    
                    if(isset($_GET['startdate']) && isset($_GET['enddate'])){

                    $sql = mysqli_query($conn, "SELECT  delivery.delivery_id, delivery.delivery_datetime, product.product_id, product.product_name, product.product_type, delivery.delivery_unitprice, delivery.delivery_numberofunits, delivery.delivery_unitofmeasure, delivery.delivery_totalcostamount, supplier.supplier_id, supplier.supplier_name, branch.branch_id, branch.branch_name, employee.employee_id, employee.employee_firstname, delivery.deleteStatus,

                    CASE WHEN delivery.deleteStatus = 1 THEN 'Deleted' ELSE 'Not Delete' END AS deleteStatus, 

                     CASE WHEN product.product_type = 1 THEN 'Non-Agricultural' ELSE 'Agricultural' END AS product_type

                    FROM delivery, product,   supplier, branch, employee
                    WHERE delivery.supplier_id =supplier.supplier_id AND delivery.branch_id= branch.branch_id 
                    AND delivery.employee_id= employee.employee_id
                    AND delivery.product_id= product.product_id
                    AND delivery.delivery_datetime >= '$_GET[startdate]'
            AND delivery.delivery_datetime <= '$_GET[enddate]' 

                    ORDER BY delivery_id ASC");


                     }else {
                      

                       $sql = mysqli_query($conn,"SELECT  delivery.delivery_id, delivery.delivery_datetime, product.product_id, product.product_name, product.product_type, delivery.delivery_unitprice, delivery.delivery_numberofunits, delivery.delivery_unitofmeasure, delivery.delivery_totalcostamount, supplier.supplier_id, supplier.supplier_name, branch.branch_id, branch.branch_name, employee.employee_id, employee.employee_firstname, delivery.deleteStatus,

                    CASE WHEN delivery.deleteStatus = 1 THEN 'Deleted' ELSE 'Not Delete' END AS deleteStatus, 

                     CASE WHEN product.product_type = 1 THEN 'Non-Agricultural' ELSE 'Agricultural' END AS product_type

                    FROM delivery, product,   supplier, branch, employee
                    WHERE delivery.supplier_id =supplier.supplier_id AND delivery.branch_id= branch.branch_id 
                    AND delivery.employee_id= employee.employee_id
                    AND delivery.product_id= product.product_id
                     
                    ORDER BY delivery_id ASC");

                     
}
                    $sum_sales = 0;
                               


                                while($row= mysqli_fetch_assoc($sql)){

                                    //print_r($row); 
                                  $total_payment  = $row['delivery_totalcostamount'];

                                    echo "<tr>";

                                        echo "<td> ", "<center>". $row['delivery_id'] . "</center>", "</td>";

                                        echo "<td> ","<center>". $row['delivery_datetime'] . "</center>","</td>";

                                        echo "<td> ", "<center>". $row['product_name'] . "</center>","</td>";

                                        
                                        echo "<td>", "<center>". $row['product_type'] ."</center>", "</td>";

                                        echo "<td> ", "<center>". $row['delivery_unitprice'] . "</center>", "</td>";

                                        echo "<td> ", "<center>". $row['delivery_numberofunits'] . "</center>", "</td>";

                                        echo "<td> ", "<center>". $row['delivery_unitofmeasure'] . "</center>", "</td>";

                                        echo "<td> ", "<center>". $row['supplier_name'] . "</center>", "</td>";

                                        echo "<td> ", "<center>". $row['branch_name'] . "</center>", "</td>";


                                        echo "<td> ", "<center>". $row['employee_firstname'] . "</center>", "</td>";


                                         echo "<td> ", "<center>". $row['delivery_totalcostamount'] . "</center>", "</td>";

                                        echo "<td> ", "<center>". $row['deleteStatus'] . "</center>", "</td>";


                                  $sum_sales += $total_payment;

               
                                
                                
                      
                      }

mysqli_free_result($sql);
                   
 

                    // Close connection

                    mysqli_close($conn);

                    ?>
</center>
               </tbody>

          </table>    
 <h4>Total Sales: P <?php echo number_format($sum_sales, 2);  ?> </h4><br>

                   
            <ul class=date1>
     <li><h3><b>Date/Time: </b><span id="date"></h3></li>
</ul>



                                
<script>
    document.getElementById("date1").innerHTML = formatAMPM();

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

  

</body>
</html>
