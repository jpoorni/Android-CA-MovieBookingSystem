<%@ Page Language="C#" AutoEventWireup="true" CodeFile="test.aspx.cs" Inherits="test" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
    </div>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="SqlDataSource1">
            <Columns>
                <asp:BoundField DataField="MovieID" HeaderText="MovieID" SortExpression="MovieID" />
                <asp:BoundField DataField="MovieName" HeaderText="MovieName" SortExpression="MovieName" />
                <asp:BoundField DataField="TheatreID" HeaderText="TheatreID" SortExpression="TheatreID" />
                <asp:BoundField DataField="MovieReview" HeaderText="MovieReview" SortExpression="MovieReview" />
                <asp:BoundField DataField="MovieSeats" HeaderText="MovieSeats" SortExpression="MovieSeats" />
                <asp:BoundField DataField="TicketPrice" HeaderText="TicketPrice" SortExpression="TicketPrice" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:MovieBookingConnectionString %>" SelectCommand="SELECT * FROM [Movie]"></asp:SqlDataSource>
    </form>
</body>
</html>
