<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
   <HEAD>
      <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8"/>
      <TITLE>Search Activity Category Form</TITLE>
   </HEAD>
   <BODY BGCOLOR="#FDF5E6">
   <H1>查詢您想參與的活動 </H1>

  <FORM ACTION="<c:url value='SelectCategoryServlet' />" method="post">
  活動類別 <select name="activity_category" size="1" >
          <option value="1" >音樂</option>
          <option value="2">戲劇</option>
          <option value="3">舞蹈</option>
          <option value="4">親子</option>
          <option value="5">獨立音樂</option>
          <option value="6">展覽</option>
          <option value="7">講座</option>
          <option value="8">電影</option>
          <option value="11">綜藝</option>
          <option value="13">競賽</option>
          <option value="14">徵選</option>
          <option value="15">其他</option>
          <option value="16">未知分類</option>
          <option value="17">演唱會</option>
          <option value="19">研習課程</option>
        </select>
    <BR><BR>
    <INPUT TYPE="submit" value="送出查詢"> 
  </FORM>
   </BODY>
</HTML>