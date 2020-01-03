<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CalandarControlPart1.aspx.cs" Inherits="COMP235WebSite.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Horoscope Page</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Calendar ViewStateMode="Enabled" ID="calFortunes" runat="server" OnDayRender="calFortunes_DayRender" OnSelectionChanged="calFortunes_SelectionChanged">

            </asp:Calendar>
        </div>
        <asp:Button ID="Button1" runat="server" Text="Button" />
    </form>
</body>
</html>
