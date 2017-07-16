<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <body>
    <c:if test="${pageContext.request.method=='POST'}">
      <c:if test="${param.guess=='java'}">You guessed it!
      <br />
      <br />
      </c:if>

      <c:if test="${param.guess!='java'}"> 
      You are wrong
      <br />
      <br />
      </c:if>
    </c:if>

    <form method="post">Guess what computer language
                        I am thinking of?
    <input type="text" name="guess" />

    <input type="submit" value="Try!" />

    <br />
    </form>
  </body>
</html>