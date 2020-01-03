CREATE TABLE [dbo].[Invoices]
(
	[InvoiceID] INT NOT NULL PRIMARY KEY, 
    [InvoiceDate] DATETIME NULL, 
    [Shipped] BIT NULL, 
    [CustomerName] NVARCHAR(50) NULL, 
    [CustomerAdress] NVARCHAR(100) NULL, 
    [CustomerEmail] NVARCHAR(50) NULL
)

