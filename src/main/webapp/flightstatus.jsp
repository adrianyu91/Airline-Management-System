<%-- 
    Document   : flightstatus
    Created on : Feb 3, 2024, 9:43:41 AM
    Author     : student
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="AirlineManagement.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Status</title>
    </head>
    <body>
        <%ArrayList<Flight> flightResults = new ArrayList<>(); // will be replaced with sql call
        flightResults.add(new Flight(1, "CYYZ", "CYYC", new Aircraft("B737", 150), 1706633079, 240));
        flightResults.add(new Flight(2, "CYHM", "CYPQ", new Aircraft("B777", 300), 1706633132, 37));
        
        %>
    <center>
        <h1>Flight Status</h1>
        <form action=Extend" method=post">
            <table border="2" align="center" cellpadding="5" cellspacing="5">
                <tr>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Flight #</th>
                    <th>Duration</th>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Status</th>
                </tr> 
                <% for(Flight flight:flightResults){
                    %>
                    <tr>
                        <td><%=flight.getDate()%></td>
                        <td><%=flight.getDepartureTime()%></td>
                        <td><%=flight.getFlightNumber()%></td>
                        <td><%=flight.getFlightDuration()%></td>
                        <td><%=flight.getOrigin()%></td>
                        <td><%=flight.getDestination()%></td>
                        <td><%=flight.getFlightStatusString()%></td>
                        <% } %>
                    </tr>
            </table>
        </form>
    </center>
    </body>
</html>
