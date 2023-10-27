<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<%@ page import="SHOP.Product" %>
<%@ page import="java.sql.*, SHOP.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page import="java.util.List"%>
<jsp:useBean id="productDAO" class="SHOP.SHOPDB" scope="session"/>
<html>
<%@include file="header.jsp" %>
  <head>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link rel="stylesheet" href="css/Payment.css">
  <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- material icon -->
<!-- jquery -->
<!-- bootstrap -->
<!-- joinForm icons -->
<!-- swiper-wrapper script -->
<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<!-- kakao script -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"   rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<!-- sweetAlert2 -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<!-- Iamport -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- End of Script -->



    <title>주문상세페이지</title>
  </head>

  <body>

       <!-- 전체 박스 시작 -->
<div class="products-detail">
   <!-- 상단 박스 시작 -->
   <div class="products-detail-box">
   <form id="theForm">
      <div class="products-box-info">
         <!-- 이미지, 브랜드, 상품명, 가격, 사이즈선택  -->
         <div class="products-info-image swiper-container">
            <!-- 이미지 -->
            <div class="swiper-wrapper">
            
               <c:if test="${prodDto.imgUrl_1 != ''}">
               <div class="swiper-slide">
                  <img src="${prodDto.imgUrl_1}" />
                  <!-- 동기적으로 불러오기 -->
               </div>
               </c:if>
               </div>
               </div>
               <span class="products-info-desciption">※ 이미지를 좌우로 드래그하면 더 많은 이미지를 확인하실 수 있습니다.</span>
               </div>
                        <div>   <!-- 상품명 -->
            <span>${prodDto.productName}</span>
            </div>
                        <div class ="main-text">
                        <span class="products-box-detail-title">배송정보|</span> <span
               class="products-box-detail-content">일반배송</span>
               </div>
               <div>
               <span class="products-box-detail-title">정품인증|</span> <span
               class="products-box-detail-content">CoCoMo 내 모든 상품은  100% 정품입니다.</span></div>
               <div>
               <span class="products-box-detail-title">상품 금액|</span>
            <span class="products-box-detail-figure">
               <fmt:formatNumber value="${prodDto.price}" type="number" />
            </span>
            </div>
          <!-- 버튼 시작 -->
           <div class="cart__mainbtns">
            <c:choose>
            <c:when test="${sessionScope.customer ne null}">
               <button type="button" class="cart__bigorderbtn left" onclick="location.href='<%=request.getContextPath()%>/cart?cmd=directBuy&prodId=${prodDto.prodId}&userId=${sessionScope.customer.num}'">바로 구매</button>
            </c:when>
            <c:otherwise>
               <button type="button" class="cart__bigorderbtn left" onclick="needLogin()">바로 구매</button>
            </c:otherwise>
            </c:choose>
         <!-- 장바구니 버튼 시작 -->
         <c:choose>
         <c:when test="${sessionScope.customer ne null}">
            <c:choose>
               <c:when test="${isCart eq true }">
                  <button type="button" class="cart__bigorderbtn right" onclick="rmvCart(${sessionScope.customer.num}, ${prodDto.prodId})">
               
                    장바구니 삭제
                  </button>
               </c:when>
               <c:otherwise>
             
                  <button type="button" class="cart__bigorderbtn right" onclick="addCart(${sessionScope.customer.num}, ${prodDto.prodId})">
                     <i>장바구니 추가</i>
                  </button>
               </c:otherwise>
            </c:choose>
         </c:when>
         <c:otherwise>
         <a>   <button type="button" class="cart__bigorderbtn right" onclick="needLogin()">
               <i>장바구니 담기</i>
             
            </button></a>
         </c:otherwise>
         </c:choose>
         </div>
        <!-- </form> -->
       
         <!-- 장바구니 버튼 끝 -->
         
         <!-- 좋아요 버튼 시작 -->
          <c:choose>
          <c:when test="${sessionScope.customer ne null}">
	<c:choose>
               <c:when test="${isFavor eq true }">
 	<button type="button" class="cart__bigorderbtn left" onclick="rmvFavor(${sessionScope.customer.num}, ${prodDto.prodId})">
                     <i>좋아요 취소</i>
                  </button>
                  
               </c:when>
               <c:otherwise>
 	<button type="button" class="cart__bigorderbtn left" onclick="addFavor(${sessionScope.customer.num}, ${prodDto.prodId})">
                     <i>좋아요</i>
                  </button>
                 
               </c:otherwise>
	</c:choose>
               </c:when>
         
         <c:otherwise>
         <a>   <button type="button" class="cart__bigorderbtn left" onclick="needLogin()">
               <i>좋아요</i>
             
            </button></a>
            
         </c:otherwise>
	</c:choose>
         
          <!-- 좋아요 버튼 끝 -->
       </form>
         <!-- 버튼 끝 -->
               </div>
                           
               
               
               </div>
               
                   <script type="text/javascript">
                   var realInfoOn = false;
                   var addressInfoOn = false;
                  function test(){
                     Swal.fire({
                          position: 'top-end',
                          icon: 'success',
                          title: 'Your work has been saved',
                          showConfirmButton: false,
                          timer: 1500
                        })
                     
                  }
                   function addressInfoBox() {
                      if (addressInfoOn == false) {
                         addressInfoOn = true;
                         $("#addressInfo-box").show();
                      } else {
                         addressInfoOn = false;
                         $("#addressInfo-box").hide();
                      }
                   };
                   function addCartMessage() {
                      Swal.fire({
                         title: '장바구니에 추가되었습니다.',
                         icon: 'success',
                         timer: 2000,
                         timerProgressbar: true,
                         willClose: () => {
                            clearInterval(timerInterval)
                         }
                      }).then((result) => {
                         location.reload();
                      })
                   }
                   function rmvCartMessage() {
                      Swal.fire({
                         title: '장바구니에서 삭제되었습니다.',
                         icon: 'success',
                         timer: 2000,
                         timerProgressbar: true,
                         willClose: () => {
                            clearInterval(timerInterval)
                         }
                      }).then((result) => {
                         location.reload();
                      })
                   }
                   function addCart(userId, prodId) {
                      var dto = {
                         userId: userId,
                         prodId: prodId
                      };
                      $.ajax({
                         type: "POST",
                         url: "/CoCoMo/cart?cmd=cartAdd",
                         data: JSON.stringify(dto),
                         contentType: "application/json; charset=utf-8",
                         dataType: "text"
                      }).done(function(result){
                         if (result === '200') {
                            addCartMessage();
                         }
                      })
                   };
                   function rmvCart(userId, prodId) {
                      var dto = {
                         userId: userId,
                         prodId: prodId
                      };
                      $.ajax({
                          type: "POST",
                          url: "/CoCoMo/cart?cmd=cartRmv",
                          data: JSON.stringify(dto),
                          contentType: "application/json; charset=utf-8",
                          dataType: "text"
                       }).done(function(result){
                          if (result === '200') {
                             rmvCartMessage();
                          }
                       })
                    };
                    function addressInfoBox() {
                		if (addressInfoOn == false) {
                			addressInfoOn = true;
                			$("#addressInfo-box").show();
                		} else {
                			addressInfoOn = false;
                			$("#addressInfo-box").hide();
                		}
                	};

                	function addFavMessage() {
                		Swal.fire({
                			html: '좋아요 목록에 추가되었습니다.',
                			icon: 'success',
                			timer: 2000,
                			timerProgressbar: true,
                			willClose: () => {
                				clearInterval(timerInterval)
                			}
                		}).then((result) => {
                			location.reload();
                		})
                	}

                	function rmvFavMessage() {
                		Swal.fire({
                			html: '좋아요 목록에서 해제되었습니다.',
                			icon: 'success',
                			timer: 2000,
                			timerProgressbar: true,
                			willClose: () => {
                				clearInterval(timerInterval)
                			}
                		}).then((result) => {
                			location.reload();
                		})
                	}

                	function addFavor(userId, prodId) {
                		var dto = {
                			userId: userId,
                			prodId: prodId
                		};

                		$.ajax({
                			type: "POST",
                			url: "/CoCoMo/favor?cmd=favorAdd",
                			data: JSON.stringify(dto),
                			contentType: "application/json; charset=utf-8",
                			dataType: "text"
                		}).done(function(result){
                			if (result === '200') {
                				addFavMessage();
                			}
                		})
                	};

                	function rmvFavor(userId, prodId) {
                		var dto = {
                			userId: userId,
                			prodId: prodId
                		};

                		$.ajax({
                			type: "POST",
                			url: "/CoCoMo/favor?cmd=favorRmv",
                			data: JSON.stringify(dto),
                			contentType: "application/json; charset=utf-8",
                			dataType: "text"
                		}).done(function(result){
                			if (result === '200') {
                				rmvFavMessage();
                			}
                		})
                	};
                    function needLogin() {
                       Swal.fire({
                          title: '로그인이 필요한 기능입니다.',
                          text: '로그인하시겠습니까?',
                          icon: 'info',
                          closeOnClickOutside: false,
                          showCancelButton: true,
                          confirmButtonText: '로그인',
                          cancelButtonText: '페이지 머물기',
                          reverseButtons: true
                       }).then((result) => {
                          if (result.isConfirmed) {
                             location.href='/CoCoMo/login.jsp';
                          } else {
                             swal.close();
                          }
                       })
                    };
                    </script>
	<%-- <---------------------------------------------------------------------->    --%>	
   
 <div class="clearfix"></div>
       <div class="footer">
            <a href="http://faceboo.com">
                <img src="https://bakey-api.codeit.kr/files/629/images/facebook.png" height="20">
            </a>
            <a href="http://faceboo.com">
                <img src="https://bakey-api.codeit.kr/files/629/images/instagram.png" height="20">
            </a>
            <a href="http://faceboo.com">
                <img src="https://bakey-api.codeit.kr/files/629/images/twitter.png" height="20">
            </a>
        </div>
    </body>
    </html>

    
