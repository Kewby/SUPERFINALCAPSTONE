<!--print agricultural products in Product Master List-->
<?php
ob_start();
require ("fpdf/fpdf.php");
$db= new PDO('mysql:host=localhost;dbname=dbtanciongs','root','');


class myPDF extends FPDF{
	function header(){
	$this->Image('pic.png',63,1,29);
	$this->SetFont('Arial', 'B', 20);
	$this->Cell(276,8, 'Report Module', 0,0, 'C');
	$this->Ln();
	$this->SetFont('Times', '', 18);
	$this->Cell(276,10,'Product Master List (Agricultural Products)', 0, 0, 'C');
	$this->Ln(20);
	}
	function footer(){
	$this->SetY(-15);
	$this->SetFont('Arial','',12);
	$this->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,0,'C');
}
function headerTable(){
	$this->SetFont('Times', 'B', 10);
	$this->Cell(23,10,'Product ID',1,0,'C');
	$this->Cell(30,10,'Product Code',1,0,'C');
	$this->Cell(102,10,'Product Name',1,0,'C');
	$this->Cell(30,10,'Product type',1,0,'C');
	$this->Cell(30,10,'Category',1,0,'C');
	$this->Cell(30,10,'Branch',1,0,'C');
	$this->Cell(30,10,'Delete Status',1,0,'C');
	$this->Ln();
}	
function viewTable($db){
	$this->SetFont('Times', '', 9);
	$stmt= $db->query("SELECT   product.product_id, product.product_code, product.product_name, category.category_id, category.category_name, branch.branch_id, product.deleteStatus, branch.branch_name, product.product_type,

                   CASE WHEN product.deleteStatus = 1 THEN 'Deleted' ELSE 'Not Delete' END AS deleteStatus,

                   CASE WHEN product.product_type = 0 THEN 'Agricultural' ELSE 'Non-Agricultural' END AS product_type

                    FROM product, category, branch
                    WHERE product.branch_id =branch.branch_id AND product.category_id= category.category_id 
                    AND product.product_type =0
                    ORDER BY product_id ASC");
	while($data= $stmt->fetch(PDO::FETCH_OBJ)){
		$this->Cell(23,10,$data->product_id,1,0,'L');
	$this->Cell(30,10,$data->product_code,1,0,'L');
	$this->Cell(102,10,$data->product_name,1,0,'L');
	$this->Cell(30,10,$data->product_type,1,0,'L');
	$this->Cell(30,10,$data->category_name,1,0,'L');
	$this->Cell(30,10,$data->branch_name,1,0,'L');
	$this->Cell(30,10,$data->deleteStatus,1,0,'L');
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

