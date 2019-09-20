<%-- 
    Document   : getData
    Created on : 18.11.2011, 12:05:18
    Author     : 7Data Gotzy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="sprava.PripojeniDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>

<%
    out.println("R: ");
    out.println("Q : " + request.getParameter("q"));
    String str = request.getParameter("q");
    ResultSet pd = PripojeniDB.dotazS("SELECT akce_id, nazev "
            + "FROM akce_hlavni WHERE nazev ILIKE '%" + str + "%' ORDER BY nazev");
    // ArrayList<String> nazev = new ArrayList<String>();
    while (pd.next()) {
        //nazev.add(pd.getString(2));
        out.println(pd.getString(2));
    }
    pd.close();
    PripojeniDB.rs.close();
    PripojeniDB.pstmt.close();
    PripojeniDB.con.close();
%>
