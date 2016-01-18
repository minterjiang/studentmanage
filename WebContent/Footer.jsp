<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.text.*" %>
<div class="footer">
	<p>©copyright <% DateFormat  sdf =  new SimpleDateFormat("yyyy"); 
	out.print(sdf.format(new Date())); %> 名特教育 mintertech.com 版权所有 站长统计</p>
</div>