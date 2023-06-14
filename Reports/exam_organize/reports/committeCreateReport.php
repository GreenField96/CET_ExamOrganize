<?php

include "../db.php";

$conn = DatabaseConnection::getInstance();
// $connection->closeConnection();
$studentResult = null;
$monitorsResult = null;
$committeResult = null;

$total = 0;
$attendance = 0;
$absence = 0;

if(isset($_GET["committe_id"])){
  $committe_id = $_GET["committe_id"];

  $sql = "SELECT
  student_absence.student_id,student_absence.name,student_absence.phone_number,student_absence.specification,student_absence.group_number,student_absence.note
  FROM
  student_absence
  WHERE
  student_absence.committe_id = " . $committe_id;
  $studentResult = $conn->query($sql);

  $sql = "SELECT 
  monitor_committe.personal_info_id,monitor_committe.absence,employees.name,employees.phone_number,employees.work_as,employees.email
  FROM
  monitor_committe , employees
  WHERE
  monitor_committe.committe_id = ". $committe_id ." AND monitor_committe.personal_info_id = employees.id";
 
 $monitorsResult = $conn->query($sql);

  $sql = "SELECT committe.id,committe.class,committe.date,committe.course,committe.number_answer_paper,committe.periodExam,committe.year,committe.semester_period,course_name.courseName as courseName
  FROM 
 committe,course_name
  WHERE
 committe.id = ". $committe_id . " AND course_name.id = committe.course;";
 
 $committeResult = $conn->query($sql);
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
              if($committeResult != null){
               if ($committeResult->num_rows > 0) {
                $count = 1;
                while($row = $committeResult->fetch_assoc()) {
                  $absence = $studentResult->num_rows;
                  $attendance = $row["number_answer_paper"];
                  $total = ($row["number_answer_paper"] + $studentResult->num_rows);
          ?>  
      <h3>لجنة الامتحانات والمراقبين للفصل <?php echo $row["year"] . " " . $row["semester_period"] ?></h3>
      <p class="lead">استمارة غياب الطلبة عن امتحان النهائي لمادة <?php echo $row["courseName"] ?></p>
    </div>

    <div class="row g-3">
      
       <div class="col">
          <div class="row g-3">
          <?php
            $newDate = date('l', strtotime($row["date"]));
                    $newDate = getDayForDate($newDate);
              ?> 
          <div class="row g-2 justify-content-center" style="margin:0 auto;">
            <div class="col-3" style="text-align:center;padding:0">
              <label for="firstName" class="form-label">اللجنة (<?php echo $row["id"] ?>)</label>
            </div>
            <div class="col-3" style="text-align:center;padding:0">
                <label for="firstName" class="form-label">الفترة (<?php echo $row["periodExam"] ?>)</label>
            </div>
            <div class="col-3" style="text-align:center;padding:0">
                <label for="firstName" class="form-label">التاريخ (<?php echo $row["date"] ?>)</label>            
            </div>
          </div>

          <div class="row justify-content-center" style="margin:0 auto;">
            <div class="col-3" style="text-align:center;padding:0">
              <label for="firstName" class="form-label">قاعة (<?php echo $row["class"] ?>)</label>
            </div>
            <div class="col-3" style="text-align:center;padding:0">
            <label for="firstName" class="form-label">اليوم (<?php echo $newDate ?>)</label>
            </div>
          </div>

          <hr class="my-4">

          <div class="row justify-content-center" style="margin:0px auto;">
            <div class="col-3" style="text-align:center">
              <label for="firstName" class="form-label">عدد الحضور (<?php echo $attendance ?>)</label>
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
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">التخصص
                </th>
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">المجموعة
                </th>
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">رقم الهاتف
                </th>
              </tr>
            </thead>
            
            <tbody> 
            <?php
             
                $count = 1;
                while($row = $studentResult->fetch_assoc()) {
              ?> 
                <tr id="CheckName_1">
                        <td><?php echo $count++; ?></td>
                        <td><?php echo $row["name"] ?></td>
                        <td><?php echo $row["student_id"] ?></td>
                        <td><?php echo $row["specification"] ?></td>
                        <td><?php echo $row["group_number"] ?></td>
                        <td><?php echo $row["phone_number"] ?></td>
                    </tr>
             
             <?php } } 
             }else{
              ?>
                <tr id="CheckName_1">
                        <td></td>
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

        <div class="row justify-content-center" style="width:740px;margin:0 auto">
          <table id="dtBasicExample" style="margin:15px 0;" class="table table-striped table-bordered table-sm" cellspacing="0">
            <?php
              if($monitorsResult != null){
               if ($monitorsResult->num_rows > 0) {

              ?>      
          <thead>
              <tr>
                <th style="padding-top:6x;padding-bottom:10px;"  class="th-sm">ر.ت
                </th> 
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">اسم الملاحظ
                </th>
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">رقم الهاتف
                </th>
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">التوقيع
                </th>
                <th  style="padding-top:6px;padding-bottom:10px;" class="th-sm">الملاحظات
                </th>
              </tr>
            </thead>
            
            <tbody>
            <?php
          
                $count = 1;
                while($row = $monitorsResult->fetch_assoc()) {	
                    $absence = $row["absence"] != 1 ? "متغيب" : "غير متغيب";
              ?>      
                <tr id="CheckName_1">
                        <td><?php echo $count++; ?></td>
                        <td><?php echo $row["name"] ?></td>
                        <td><?php echo $row["phone_number"] ?></td>
                        <td><?php echo $absence ?></td>
                        <td></td>
                    </tr>
             <?php } } 
             }else{
              ?>
                <tr id="CheckName_1">
                        <td></td>
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
