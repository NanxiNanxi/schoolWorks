<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DayPlanner.aspx.cs" Inherits="COMP235WebSite.WebForm2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Calendar ID="calPlanner" runat="server" OnSelectionChanged="calPlanner_SelectionChanged" CellPadding="4" CellSpacing="4" OnDayRender="calPlanner_DayRender">
                <DayHeaderStyle BackColor="#FFCC00" BorderColor="Yellow" />
                <DayStyle BackColor="#FFFFCC" />
                <SelectorStyle ForeColor="Yellow" />
                <TitleStyle BackColor="#FF9900" />
            </asp:Calendar>
            <hr style="height: 0px; width: 958px" />
            <asp:TextBox ID="txtEvent" TextMode="MultiLine" runat="server" Height="73px" Width="249px"></asp:TextBox>
            <br />
            <asp:Button ID="btnSave" runat="server" Text="Save" OnClick="btnSave_Click" />
        </div>
    </form>
</body>
</html>
