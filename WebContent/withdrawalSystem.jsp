<%@ page language="java" contentType="text/html; charset=euc_kr" 
	import="java.sql.*, util.*, java.util.regex.Pattern, java.util.regex.Matcher, SHOP.*"%>
<% request.setCharacterEncoding("euc-kr"); %>
<html>
  <head>
  <meta charset="EUC-KR">
  <title>ȸ������ ó��</title>
  </head>
  <body>
    <% 
		String id = request.getParameter("id");
   		SHOPDB.loadConnectshop();	
	    boolean result = SHOPDB.cancelInfo(id);
		
		if(result == true){
			out.print("<script>alert('������ �Ϸ�Ǿ����ϴ�!')</script>");
			out.print("<script>location='Main.jsp'</script>");
		}
		else{
			out.print("<script>alert('������ �ȵƽ��ϴ�~!')</script>");
			out.print("<script>location='manager.jsp'</script>");
		}
    %>
  </body>
</html>