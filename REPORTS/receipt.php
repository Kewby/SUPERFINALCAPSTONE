<!--print receipt -->
<?php
ob_start();
session_start();

require ("fpdf/fpdf.php");
$db= new PDO('mysql:host=localhost;dbname=dbtanciongs','root','');


class myPDF extends FPDF{
	function header(){
	
	$this->SetFont('Arial', '', 9);
	$this->Cell(0,0, 'PROPRIETOR: JOSEPHINE ROSS OMEGA MARQUEZ', 0,0, 'C');
	$this->Cell(-2.7,0.5, "TANCIONG'S GENERAL MERCHANDISE", 0,0, 'C');
	$this->Cell(0,1, "The Persimmon Plus M.J Cuenco Ave.,Mabolo Cebu City", 0,0, 'C');
	$this->Ln();
	
	}
	function footer(){
	$this->SetY(-15);
	$this->SetFont('Arial','',12);
	
}
function receipt(){
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
}

}
$pdf= new myPDF();
$pdf->AliasNbPages();
$pdf->AddPage('P','A4', 0);
//$pdf->headerTable();
$pdf= new myPDF('P', 'in',array(3.5, 10));
date_default_timezone_set("Asia/Manila");
$pdf->Cell(0,10,'Date Printed:  '. date("M d Y").' '.date("h:i:sa"), 0,0);

$pdf->output();
ob_end_flush(); 



//$pdf->Cell(0,10, "Start Date:" .$_SESSION['start']);
//$pdf->Ln();
//$pdf->Cell(0,10, "End Date:" .$_SESSION['end']);
//$pdf->Ln();

//$pdf->Cell(0,10,'Date Printed:  '. date("M d Y"));
?>

