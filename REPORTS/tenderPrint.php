<!--print tendered Report (not filtered)-->
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
	$this->Cell(276,10,'Tendered Report', 0, 0, 'C');
	$this->Ln(20);
	}
	function footer(){
	$this->SetY(-15);
	$this->SetFont('Arial','',12);
	$this->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,0,'C');
}
function headerTable(){
	$this->SetFont('Times', 'B', 12);
	$this->Cell(40,10,'Date/Time',1,0,'C');
	$this->Cell(30,10,'Transaction ID',1,0,'C');
	$this->Cell(40,10,'Tendered Amount',1,0,'C');
	$this->Cell(40,10,'Change',1,0,'C');
	$this->Cell(40,10,'Employee Name',1,0,'C');
	$this->Cell(40,10,'Branch Assigned',1,0,'C');
	$this->Ln();
}	
function viewTable($db){
	$this->SetFont('Times', '', 10);
	$stmt= $db->query("SELECT  transaction.transaction_datetime, transaction.transaction_id, transaction.transaction_tender, transaction.transaction_change, employee.employee_id, employee.employee_firstname, branch.branch_id, branch.branch_name
                    FROM transaction, employee, branch
                    WHERE transaction.employee_id= employee.employee_id AND employee.branch_id = branch.branch_id
                    ORDER BY transaction_datetime ASC");

	while($data= $stmt->fetch(PDO::FETCH_OBJ)){
		$this->Cell(40,10,$data->transaction_datetime,1,0,'L');
	$this->Cell(30,10,$data->transaction_id,1,0,'L');
	$this->Cell(40,10,$data->transaction_tender,1,0,'L');
	$this->Cell(40,10,$data->transaction_change,1,0,'L');
	$this->Cell(40,10,$data->employee_firstname,1,0,'L');
	$this->Cell(40,10,$data->branch_name,1,0,'L');
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
$pdf->Cell(0,10,'Date & Time Printed:  '. date("M d Y").' '.date("h:i:sa"), 0,0);$pdf->output();
ob_end_flush(); 

?>

