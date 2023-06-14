<?php

include "../db.php";

$conn = DatabaseConnection::getInstance();
// $connection->closeConnection();
$result = null;

$year = date("Y");
$semesterPeriod = array("خريفي","ربيعي","صيفي");

if(isset($_POST["room_number"]) & isset($_POST["course_name"]) & isset($_POST["date_exam"]) & isset($_POST["semester_period"]) & isset($_POST["year"]) & isset($_POST["exam_period"]) ){
  $room_number = $_POST["room_number"];
  $course_name = $_POST["course_name"];
  $date_exam = $_POST["date_exam"];
  $year = $_POST["year"];
  $semester_period = $_POST["semester_period"];
  $exam_period = $_POST["exam_period"];

  if($date_exam != ""){
    $date_exam = explode("/", $date_exam);
    $date_exam_convert = array($date_exam[2] , $date_exam[0] , $date_exam[1]);
    $date_exam = implode("-", $date_exam_convert);
  }

  // echo "date : " . $date_exam;
  $sql = "SELECT " . " committe.id,committe.class,committe.date,committe.course,committe.number_answer_paper,committe.year,committe.periodExam,committe.semester_period,course_name.id as courseId,course_name.courseName,course_name.courseNumber " .
  " FROM committe,course_name WHERE committe.class LIKE '%". $room_number ."%' AND committe.date LIKE '%". $date_exam ."%' AND course_name.courseName LIKE '%". $course_name ."%'  AND committe.year = '". $year ."'  AND committe.periodExam = '". $exam_period ."' AND committe.semester_period LIKE '". $semester_period ."'  AND course_name.id = committe.course";

  $result = $conn->query($sql);

}

?>


<!doctype html>
<html lang="ar" dir="rtl">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title> تقرير اللجان </title>

<link href="dist/css/bootstrap.rtl.min.css" rel="stylesheet">
<link href="dist/css/blog.rtl.css" rel="stylesheet">

  <link rel="stylesheet" href="dist/css/bootstrap-datepicker.min.css">
  <script src="dist/js/jquery-3.3.1.min.js"></script>
  <script src="dist/js/bootstrap-datepicker.min.js"></script>
  
  <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
      

  <link href="fontawesome-6.4.0/css/fontawesome.css" rel="stylesheet">
  <link href="fontawesome-6.4.0/css/brands.css" rel="stylesheet">
  <link href="fontawesome-6.4.0/css/solid.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

table.dataTable thead .sorting:after,
table.dataTable thead .sorting:before,
table.dataTable thead .sorting_asc:after,
table.dataTable thead .sorting_asc:before,
table.dataTable thead .sorting_asc_disabled:after,
table.dataTable thead .sorting_asc_disabled:before,
table.dataTable thead .sorting_desc:after,
table.dataTable thead .sorting_desc:before,
table.dataTable thead .sorting_desc_disabled:after,
table.dataTable thead .sorting_desc_disabled:before {
  bottom: .5em;
}
</style>

<script>
 $(function () {
        $("#datepicker").datepicker({
            dateFormat: 'yy-mm-dd'
        });
    });
</script>

  </head>

    <div class="container">

        <header class="blog-header py-3">
            <div class="row flex-nowrap justify-content-between align-items-center">
                <div class="col-4 pt-1">
                    <!-- <a class="link-secondary" href="#">الإشتراك في النشرة البريدية</a> -->
                </div>
                <div class="col-4 d-flex justify-content-end align-items-center">
                    <a class="link-secondary" href="../index.php" >
                        <span style="padding-right:2px;padding-left:2px;" class="btn btn-sm btn-outline-secondary">الصفحة الرئيسية</span>
                    </a>                
                </div>
            </div>
        </header>

     <form method="POST" action="<?php echo $_SERVER['PHP_SELF']; ?>" class="needs-validation">
        
      <figure  style="margin-bottom:0px;margin-top: 50px;">
        <blockquote class="blockquote">
          <p>ادخال بيانات اللجنة</p>
        </blockquote>
        <figcaption class="blockquote-footer">
         تحديد <cite title="Source Title">اللجنة</cite>
        </figcaption>
      </figure>
        <div>
               
          <div class="input-group d-flex gap-3 justify-content-center py-5">
            
            <div class="col">
                <input type="search"  value="" name="room_number" class="col form-control rounded" placeholder="رقم القاعة" />
                <input type="search"  value="" name="course_name" class="col form-control rounded" placeholder="اسم المادة/الكورس" />
                <select name="semester_period" class="form-select" aria-label="Default select example" required>
                    <option value="<?php echo $semesterPeriod[0] ?>" selected><?php echo $semesterPeriod[0] ?></option>
                    <option value="<?php echo $semesterPeriod[1] ?>"><?php echo $semesterPeriod[1]  ?></option>
                    <option value="<?php echo $semesterPeriod[2] ?>"><?php echo $semesterPeriod[2] ?></option>
                <select>
            </div>

            <div style="margin:0" class="col">
                  <div class="row form-group">
                    <div class="col">
                        <div class="input-group date" id="datepicker">
                            <input name="date_exam" type="text" class="form-control">
                            <span class="input-group-append">
                                <span style="height:40px" class="input-group-text bg-white">
                                    <i class="fa fa-calendar"></i>
                                </span>
                            </span>
                        </div>
                    </div>
                </div>
                <select name="year" class="form-select" aria-label="Default select example" required>
                    <option selected><?php echo $year ?></option>
                    <?php for($i = -1; $i < 3;$i++){ ?>
                    <option value="<?php echo ($year + $i) ?>"><?php echo ($year + $i) ?></option>
                    <?php } ?>
                <select>
                <select name="exam_period" class="form-select" aria-label="Default select example" required>
                    <option value="<?php echo "09:00-11:00"; ?>" selected ><?php echo "09:00-11:00"; ?></option>
                    <option value="<?php echo "11:30-13:30"; ?>" ><?php echo "11:30-13:30";  ?></option>
                <select>
              </div>

        
            <button class="btn btn-outline-primary">أبحت</button>
        </div>
    </form>

        <form method="GET" action="committeCreateReport.php" class="needs-validation">
          <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
            <thead>
              <tr>
                <th class="th-sm">المادة
                </th> 
                <th class="th-sm">رقم القاعة
                </th>
                <th class="th-sm">عدد اوراق
                </th>
                <th class="th-sm">تاريخ
                </th>
              </tr>
            </thead>
            
            <tbody>

            <div class="form-check">
            
              <!-- for -->
              <?php
              if($result != null){
               if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
              ?>              
                <tr id="CheckName_1">
                        <td><?php echo $row["courseName"] ?></td>
                        <td><?php echo $row["class"] ?></td>
                        <td><?php echo $row["number_answer_paper"] ?></td>
                        <td><?php echo $row["date"] ?></td>
                        <td>
                            <input type="radio" id="checked_1" name="committe_id" class="form-check-input" value="<?php echo $row["id"] ?>" required>
                        </td>
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
                        <td><input type="radio" id="checked_1" name="committe_id" class="form-check-input" value="" required></td>
                    </tr>
              <?php
              }
              ?>
             <!-- end-for -->
             
            </div>
            </tbody>
          </table>
         </div>

            <div style="padding-bottom:50px;" class="d-flex flex-column">
            <button class="btn btn-primary" type="submit" data-toggle="collapse" >أنشاء تقرير</button>
            </div>
  </form>
</div>

  <script src="dist/js/bootstrap.bundle.min.js"></script>

  <script>
        let checkList_1 = document.querySelectorAll("#CheckName_1");
        checkList_1.forEach((e) => {
            e.addEventListener("mousedown", () => {
                e.children[3].children[0].checked = true;
            });
        });
        
     $(document).ready(function () {
     $('#dtBasicExample').DataTable();
     $('.dataTables_length').addClass('bs-select');
     });

    </script>

  </body>
</html>
