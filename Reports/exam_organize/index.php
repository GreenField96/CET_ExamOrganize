<?php
include "db.php";

$connection = DatabaseConnection::getInstance();

?>

<!doctype html>
<html lang="ar" dir="rtl" data-bs-theme="auto">
  <head><script src="assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.112.5">
    <title>نظام متابعة سير الامتحانات النهائية</title>
    <link rel="icon" href="images/icon.png">

    <link href="assets/dist/css/bootstrap.rtl.min.css" rel="stylesheet">

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

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }
      .bd-mode-toggle {
        z-index: 1500;
      }
    </style>

    <!-- Custom styles for this template -->
    <link href="assets/dist/css/blog.rtl.css" rel="stylesheet">
  </head>
  <body>
    
    
<div class="container" style="margin-bottom:15px">
  <header class="border-bottom lh-1 py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-4 pt-1">
        <strong class="d-inline-block mb-2 text-primary-emphasis">
          نظام متابعة سير الامتحانات النهائية  
        </strong>
      </div>
      <div class="col-4 text-center">
        <a class="blog-header-logo text-body-emphasis text-decoration-none" href="#"></a>
      </div>
      <div class="col-4 d-flex justify-content-end align-items-center">
      </div>
    </div>
  </header>
  
</div>

<main class="container">

  <div style="background-color:gray" class="p-4 p-md-1 mb-4 rounded text-body-emphasis">
    <div class="col-lg-6 px-0">
     <img src="images/full_cet_logo.png" style="width: auto;height: 200px;" alt="">
     </div>
  </div>


  <div class="row mb-2">
    
    <div class="col-md-6">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary-emphasis">تقرير لجان</strong>
          <p class="card-text mb-auto">تقرير عن لجنة متل الطلبة المتغيبين والمراقبين وعدد الاورقام المستلمة من اللجنة</p>
          <a href="reports/committeReport.php" class="icon-link gap-1 icon-link-hover stretched-link">
            اضغط هنا
            <svg class="bi"><use xlink:href="#chevron-right"/></svg>
          </a>
        </div>
        <div class="col-auto d-none d-lg-block">
          <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: صورة مصغرة" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">صورة مصغرة</text></svg>
        </div>
      </div>
    </div>

    <div class="col-md-6">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary-emphasis">تقرير تسليم اوراق الاجابة</strong>
          <p class="card-text mb-auto">تقرير عن تسليم اوراق الاجبابة لدكتور لتصحيحها وتطلب بيانات متل اسم دكتور و اللجنة التي يريد استلام اوراقها</p>
          <a href="#" class="icon-link gap-1 icon-link-hover stretched-link">
            اضغط هنا
            <svg class="bi"><use xlink:href="#chevron-right"/></svg>
          </a>
        </div>
        <div class="col-auto d-none d-lg-block">
          <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: صورة مصغرة" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">صورة مصغرة</text></svg>
        </div>
      </div>
    </div>

    <div class="col-md-6">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary-emphasis">تقرير استلام اوراق الاجابة</strong>
          <p class="card-text mb-auto">تقرير عن استلام اوراق الاجبابة من دكتور لتوتيق تاريخ انتهاء التصحيح مع ادخال عدد الاوراق المستلمة </p>
          <a href="#" class="icon-link gap-1 icon-link-hover stretched-link">
            اضغط هنا
            <svg class="bi"><use xlink:href="#chevron-right"/></svg>
          </a>
        </div>
        <div class="col-auto d-none d-lg-block">
          <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: صورة مصغرة" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">صورة مصغرة</text></svg>
        </div>
      </div>
    </div>

  </div>


</main>

<footer class="py-5 text-center text-body-secondary bg-body-tertiary">
  <p>  تصميم وبرمجةو تحليل الطالبان مندر الجبالي و محمد فرارة بأشراف م.مصطفى قاباج .</p>
  <a href="https://t.me/ferro6060">mohamed_Furara</a> , <a href="https://t.me/munder_Aljbaly"><bdi lang="en" dir="ltr">munder_Aljbaly</bdi></a>
  <p class="mb-0">
    <a href="#">عد إلى الأعلى</a>
  </p>
</footer>
<script src="assets/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
