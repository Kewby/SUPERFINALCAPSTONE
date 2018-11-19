<!--print Sales by product report-->
<?php
ob_start();
require ("fpdf/fpdf.php");
$db= new PDO('mysql:host=localhost;dbname=dbtanciongs','root','');


class myPDF extends FPDF{
	function header(){
	$this->Image('pic.png',93,1,29);
	$this->SetFont('Arial', 'B', 20);
	$this->Cell(276,8, 'Report Module', 0,0, 'C');
	$this->Ln();
	$this->SetFont('Times', '', 18);
	$this->Cell(276,10,'Sales Report', 0, 0, 'C');
	$this->Ln(20);
	}
	function footer(){
	$this->SetY(-15);
	$this->SetFont('Arial','',12);
	$this->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,0,'C');
}
function headerTable(){
	$this->SetFont('Times', 'B', 12);
	$this->Cell(30,10,'Sales ID',1,0,'C');
	$this->Cell(40,10,'Sales Date/Time',1,0,'C');
	$this->Cell(102,10,'Employee Name',1,0,'C');
	$this->Cell(30,10,'Changefund',1,0,'C');
	$this->Cell(30,10,'Total Sales',1,0,'C');
	
	$this->Ln();
}	
function viewTable($db){
	$this->SetFont('Times', '', 10);
	$stmt= $db->query("SELECT * FROM sales, employee


                      WHERE sales.employee_id = employee.employee_id
                  
                    ORDER BY sales_id ASC");
	while($data= $stmt->fetch(PDO::FETCH_OBJ)){
		$this->Cell(30,10,$data->sales_id,1,0,'L');
	$this->Cell(40,10,$data->sales_datetime,1,0,'L');
	$this->Cell(102,10,$data->employee_firstname,1,0,'L');
	$this->Cell(30,10,$data->changefund,1,0,'L');
	$this->Cell(30,10,$data->total_sales,1,0,'L');
	$this->Ln();
	}
}
}
$pdf= new myPDF();
$pdf->AliasNbPages();
$pdf->AddPage('L','A4', 0);
$pdf->headerTable();
$pdf->viewTable($db);
date_default_timezone_set("Asia/Manila");
$pdf->Cell(0,10,'Date & Time Printed:  '. date("M d Y").' '.date("h:i:sa"), 0,0);
$pdf->output();
ob_end_flush(); 

?>

