<!--print stock status (filtered) report-->
<?php
ob_start();
session_start();

require ("fpdf/fpdf.php");
$db= new PDO('mysql:host=localhost;dbname=dbtanciongs','root','');


class myPDF extends FPDF{
	function header(){
	$this->Image('pic.png',93,1,29);
	$this->SetFont('Arial', 'B', 20);
	$this->Cell(276,8, 'Report Module', 0,0, 'C');
	$this->Ln();
	$this->SetFont('Times', '', 18);
	$this->Cell(276,10,'Stock Status Report', 0, 0, 'C');
	$this->Ln(20);
	}
	function footer(){
	$this->SetY(-15);
	$this->SetFont('Arial','',12);
	$this->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,0,'C');
}
function headerTable(){
	$this->SetFont('Times', 'B', 12);
	$this->Cell(40,10,'Stock ID',1,0,'C');
	$this->Cell(30,10,'Stock Onhand',1,0,'C');
	$this->Cell(40,10,'Date & Time',1,0,'C');
	$this->Cell(40,10,'Product Name',1,0,'C');
	$this->Cell(50,10,'Supplier Name',1,0,'C');
	$this->Cell(40,10,'Employee Name',1,0,'C');
	$this->Cell(40,10,'Delete Status',1,0,'C');
	

	$this->Ln();
}	
function viewTable($db){
	$this->SetFont('Times', '', 10);
//if(isset($_GET['generate']) || true){
if(1==1){                  

if(isset($_SESSION['start']) && isset($_SESSION['end'])){ 
						$stringQuery1 = "SELECT  stock.stock_id, stock.stock_onhand, stock.stock_datetime, product.product_id, product.product_name, supplier.supplier_id, supplier.supplier_name, employee.employee_id, employee.employee_firstname, stock.deleteStatus, 

                    CASE WHEN stock.deleteStatus = 1 THEN 'Deleted' ELSE 'Not Delete' END AS deleteStatus
                    FROM stock, product, employee, supplier
                    WHERE stock.product_id =product.product_id AND 
                    stock.supplier_id= supplier.supplier_id AND
                    stock.employee_id= employee.employee_id
                    AND stock.stock_datetime >= '$_SESSION[start]'
            AND stock.stock_datetime <= '$_SESSION[end]' 
                    ORDER BY stock_id ASC";
                       $stmt= $db->query($stringQuery1);
                      // echo $stringQuery1;
                                // echo $stringQuery1;
                       
 

         while($data= $stmt->fetch(PDO::FETCH_OBJ)){
		
	$this->Cell(40,10,$data->stock_id,1,0,'L');
	$this->Cell(30,10,$data->stock_onhand,1,0,'L');
	$this->Cell(40,10,$data->stock_datetime,1,0,'L');
	$this->Cell(40,10,$data->product_name,1,0,'L');
	$this->Cell(50,10,$data->supplier_name,1,0,'L');
	$this->Cell(40,10,$data->employee_firstname,1,0,'L');
	$this->Cell(40,10,$data->deleteStatus,1,0,'L');
	
	

	$this->Ln();
}
    
     }else {
     	


 						$stringQuery = "SELECT  stock.stock_id, stock.stock_onhand, stock.stock_datetime, product.product_id, product.product_name, supplier.supplier_id, supplier.supplier_name, employee.employee_id, employee.employee_firstname, stock.deleteStatus, 

                    CASE WHEN stock.deleteStatus = 1 THEN 'Deleted' ELSE 'Not Delete' END AS deleteStatus
                    FROM stock, product, employee, supplier
                    WHERE stock.product_id =product.product_id AND 
                    stock.supplier_id= supplier.supplier_id AND
                    stock.employee_id= employee.employee_id
                    ORDER BY stock_id ASC";
                        $stmt= $db->query($stringQuery);
                        }

}
    }

}
$pdf= new myPDF();
$pdf->AliasNbPages();
$pdf->AddPage('L','A4', 0);
$pdf->headerTable();
$pdf->viewTable($db);
$pdf->Cell(0,10, "Start Date:" .$_SESSION['start']);
$pdf->Ln();
$pdf->Cell(0,10, "End Date:" .$_SESSION['end']);
$pdf->Ln();

date_default_timezone_set("Asia/Manila");
$pdf->Cell(0,10,'Date & Time Printed:  '. date("M d Y").' '.date("h:i:sa"), 0,0);


$pdf->output();
ob_end_flush(); 

?>

