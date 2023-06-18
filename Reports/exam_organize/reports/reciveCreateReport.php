<?php

include "../db.php";

$conn = DatabaseConnection::getInstance();
// $connection->closeConnection();
$studentResult = null;
$deliveryResult = null;
$employeeResult = null;

$countStudentEmpty = 5;

$phoneNumber_he_had = null;
$name_he_had = null;

$total = 0;
$attendance = 0;
$absence = 0;

if(isset($_GET["Recive_id"])){
  $Recive_id = $_GET["Recive_id"];

  $sql = "SELECT 
  committe.id,committe.date as committeDate,committe.class,committe.periodExam,committe.semester_period,committe.year,
  employees.name,course_name.courseName,
  answer_paper_movement.date,answer_paper_movement.number_papers_received,answer_paper_movement.specification,answer_paper_movement.group,answer_paper_movement.he_have_id,answer_paper_movement.he_had_id
  FROM 
  answer_paper_movement,employees,committe,course_name
  WHERE 
  answer_paper_movement.id = " . $Recive_id . " AND 
  employees.id = answer_paper_movement.he_had_id AND 
  course_name.id = committe.course AND 
  answer_paper_movement.committe_id = committe.id";

  $deliveryResult = $conn->query($sql);
  
  
  

 }

function getDayForDate($newDate){
    switch($newDate){
        case "Saturday":
            $newDate = "السبت";
            break;
        case "Sunday":
            $newDate = "الاحد";
            break;
        case "Monday":
            $newDate = "الاتنين";
            break;
        case "Tuesday":
            $newDate = "التلاتاء";
            break;
        case "Wednesday":
            $newDate = "الاربعاء";
            break;
        case "Friday":
            $newDate = "الجمعة";
            break;
        case "Thursday":
            $newDate = "الخميس";
            break;
        }
      return $newDate;
}

?>

<!doctype html>
<html lang="ar" dir="rtl" data-bs-theme="auto">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.112.5">
    <title>تقرير اللجنة</title>
<link href="dist/css/bootstrap.rtl.min.css" rel="stylesheet">

<style type="text/css" media="print">
@page {
    size: auto;   /* auto is the initial value */
    margin: 1mm 0;  /* this affects the margin in the printer settings */
}

</style>

<link href="dist/css/checkout.css" rel="stylesheet">

</head>

<body style="background-color:white;" class="">  

<div class="container" id="doc" style="width:700px">
  <main>
    <div class="py-1 text-center"  style="margin:0 auto;">
    <img class="d-block mx-auto" src="../images/Untitled.png" alt="" width="540" height="100">
    <footer style="font-size: 12px;" class="text-body-secondary text-center text-small">
    </footer>
    <?php
              if($deliveryResult != null){
               if ($deliveryResult->num_rows > 0) {
                $count = 1;
                while($row = $deliveryResult->fetch_assoc()) {
    
                $sql = "SELECT
                 name,phone_number
                FROM
                 employees
                WHERE
                 id = " . $row["he_have_id"];
                $employeeResult = $conn->query($sql);

                if ($employeeResult->num_rows > 0) {
                  while($subRow = $employeeResult->fetch_assoc()) {
                    $name_he_had = $subRow["name"];
                    $phoneNumber_he_had = $subRow["phone_number"];
                  }
                }

                $sql = "SELECT
                 *
                FROM
                 student_absence
                WHERE
                 committe_id = " . $row["id"] . " AND specification = '" . $row["specification"] . "' AND group_number = '" . $row["group"] . "' ";

                  $studentResult = $conn->query($sql);
                  $absence = $studentResult->num_rows;
                  $attendance = $row["number_papers_received"];
                  $total = ($row["number_papers_received"] + $studentResult->num_rows);
                  

          ?>  
      <h3>لجنة الامتحانات والمراقبين للفصل <?php echo $row["year"] . " " . $row["semester_period"] ?></h3>
      <p class="lead">نمودج استلام اوراق اجابة للامتحان النهائي لمادة <?php echo $row["courseName"] ?></p>
    </div>

    <div class="row g-3">
      
       <div class="col">
          <div class="row g-3">
          <?php
            $newDate = date('l', strtotime($row["date"]));
            $newDate = getDayForDate($newDate);
          ?>
          <div class="row g-2 justify-content-center" style="margin:0 auto;">
            <div class="col-5" style="text-align:center;padding:0">
              <label for="firstName" class="form-label">تم الاستلام من الاستاد : <?php echo $row["name"] ?></label>
            </div> 
          </div>

          <div class="row g-2 justify-content-center" style="margin:0 auto;">
          <div class="col-4" style="text-align:center;padding:0">
                <label for="firstName" class="form-label">تاريخ الاستلام (<?php echo $row["date"] ?>)</label>            
            </div>
            <div class="col-3" style="text-align:center;padding:0">
            <label for="firstName" class="form-label">اليوم (<?php echo $newDate ?>)</label>
            </div>
          </div>
          
          <div class="row g-2 justify-content-center" style="margin:0 auto;">
            <div class="col-3" style="text-align:center;padding:0">
              <label for="firstName" class="form-label">اللجنة (<?php echo $row["id"] ?>)</label>
            </div>
            <div class="col-3" style="text-align:center;padding:0">
                <label for="firstName" class="form-label">المجموعة (<?php echo $row["group"] ?>)</label>
            </div>
            <div class="col-3" style="text-align:center;padding:0">
                <label for="firstName" class="form-label">التخصص (<?php echo $row["specification"] ?>)</label>            
            </div>
          </div>

          <div class="row" style="margin:10px 80px 10px 10px;">
            <div class="col-4" style="text-align:center;padding:0">
                <label for="firstName" class="form-label">تاريخ اجراء الامتحان (<?php echo $row["committeDate"] ?>)</label>            
           </div>
           <div class="col-2" style="text-align:center;padding:0">
              <label for="firstName" class="form-label">قاعة (<?php echo $row["class"] ?>)</label>
            </div>
            <div class="col-3" style="text-align:center;padding:0">
              <label for="firstName" class="form-label">الفترة (<?php echo $row["periodExam"] ?>)</label>
            </div>
          </div>
          
          
          <div class="row" style="margin:10px 80px 10px 10px;">
    
          <div class="col-9" style="padding:0;margin:10px 0px 10px 0px;">
          شاكرين سلفا على حسن تعاونكم و نأمل منكم الاخد بالاعتبار النقاط التالية:
           </div>
           <div class="col-9" style="padding:0;margin:10px 0px 10px 0px;">
           1 / مراجعة كراسات الاجابة من الداخل للتأكد من تصحيح جميع جزيئات الاسئلة وجمع درجات الاسئلة ومطابقتها للدرجة الكلية المثبتة على غلاف كراسة الاجابة
           </div>
           <div class="col-9" style="padding:0;margin:10px 0px 10px 0px;">
           2 / التأكد من تطابق عدد الاوراق المستلمة مع عدد الاوراق المسلمة سابقا
           </div>
           <div class="col-9" style="padding:0;margin:20px 0px 0px 10px;">
           توقيع عضو هيئة التدريس   _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
           </div>
           <div class="col-9" style="padding:0;margin:20px 0px 0px 10px;">
           تم التسليم ل <?php echo $name_he_had ?>
           <?php if($phoneNumber_he_had != ""){echo " / ر.ه " . $phoneNumber_he_had; }?>
           </div>
           <div class="col-9" style="padding:0;margin:10px 0px 10px 0px;font-weight:bold;font-size:16px;">
           و تم التسليم بعد <?php echo intval((strtotime($row["date"]) - strtotime($row["committeDate"]) )/(24*60*60)) ?>/ي
           من تاريخ اجراء الامتحان النهائي
           </div>
          </div>

          <hr class="my-4">

          <div class="row justify-content-center" style="margin:0px auto;">
            <div class="col-3" style="text-align:center">
              <label for="firstName" class="form-label">عدد الاوراق (<?php echo $attendance ?>)</label>
            </div>
            <div class="col-3" style="text-align:center">
            <label for="firstName" class="form-label">عدد الغياب (<?php echo $absence ?>)</label>
            </div>
            <div class="col-3" style="text-align:center">
            <label for="firstName" class="form-label">الاجمالي (<?php echo $total ?>)</label>
            </div>
          </div>
          
        <?php 
                }
            }
        }
        ?>


        <div class="row justify-content-center"  style="width:740px;margin:0 auto">
          <table id="dtBasicExample" style="margin:15px 0;" class="table table-striped table-bordered table-sm" cellspacing="0" >
          <?php
              if($studentResult != null){
                if ($studentResult->num_rows > 0) {
              ?>  
          <thead>
              <tr>
                <th style="padding-top:6x;padding-bottom:10px;" class="th-sm">ر.ت
                </th> 
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">اسم الطالب
                </th>
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">رقم القيد
                </th>
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">رقم الهاتف
                </th>
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">ملاحظات
                </th>
              </tr>
            </thead>
            
            <tbody> 
            <?php
             
              
                $count = 1;
                while($row = $studentResult->fetch_assoc()) {
                  $countStudentEmpty--;
              ?>       
                <tr id="CheckName_1">
                        <td><?php echo $count++; ?></td>
                        <td><?php echo $row["name"] ?></td>
                        <td><?php echo $row["student_id"] ?></td>
                        <td><?php echo $row["note"] ?></td>
                        <td><?php echo $row["phone_number"] ?></td>
                    </tr>
             
             <?php } } 
             }
             for($i=0 ;$i < $countStudentEmpty ; $i++){
              ?>
                <tr id="CheckName_1">
                        <td><?php echo $count++; ?></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                 </tr>
              <?php
             }
              ?>
             <!-- end-for -->
             
            </div>
            </tbody>
          </table>
          </div>
          
        
          <hr class="my-4">

      </div>
    </div>
  </main>
  
</div>

<script src="dist/js/html2pdf.bundle.min.js"></script>
<script src="dist/js/bootstrap.bundle.min.js"></script>
<script src="dist/js/checkout.js"></script>

<script>
    function printDiv() {
        var printContents = document.getElementById("doc").innerHTML;
        var originalContents = document.body.innerHTML;
        document.body.innerHTML = printContents;
        window.print();
        document.body.innerHTML = originalContents;
        }
 
</script>

</body>
<button class="w-100 btn btn-primary btn-lg" onclick="printDiv()" >التحويل الي pdf</button>

</html>
