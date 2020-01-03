//搜索字母代表的pattern规则（正则对象）Regex cheat sheet

function changeBorder(opt) {
    if (opt == 1) { document.getElementById("outer").style.border = "solid blue" }
    if (opt == 2) { document.getElementById("outer").style.border = "solid red" }
    if (opt == 3) { document.getElementById("outer").style.border = "solid green" }  
}


function showPics() {
    var x = document.getElementById("nameOfCabinet")
    var currentIndex = x.selectedIndex
    if (x.options[currentIndex].value == "5") {
        document.getElementById("counterTop").style.visibility = "visible"
        document.getElementById("showPic2").style.visibility = "hidden"
        document.getElementById("showPic").style.visibility = "hidden"
    }
    if (x.options[currentIndex].value == "0") {
        document.getElementById("showPic").innerHTML = "<img src='wall.jpg'>"
        document.getElementById("showPic2").innerHTML = "<img src='corners.jpg'>"
        document.getElementById("showPic").style.visibility = "visible"
        document.getElementById("counterTop").style.visibility = "visible"
        document.getElementById("showPic2").style.visibility = "visible"
    }
    if (x.options[currentIndex].value == "1") {
        document.getElementById("showPic").innerHTML = "<img src='base.jpg'>"
        document.getElementById("showPic2").innerHTML = "<img src='corners.jpg'>"
        document.getElementById("counterTop").style.visibility = "visible"
        document.getElementById("showPic").style.visibility = "visible"
        document.getElementById("showPic2").style.visibility = "visible"
    }
    if (x.options[currentIndex].value == "2") {
        document.getElementById("showPic").innerHTML = "<img src='counters.jpg'>"
        document.getElementById("counterTop").style.visibility="hidden"
        document.getElementById("showPic").style.visibility = "visible"
        document.getElementById("showPic2").style.visibility = "hidden"
    }

}


var priceTable =[
    [99.99,179,200.99],
    [69.99,79,99.99],
    [30.99,189.99,212.99],
    [50.99,79.99,89.99]
]

var price = 0
var isValidData = false


function isValid(){
    if (productType == "5") {
        alert("Please choose a product type!")
        return
    }
    if(stylePrice != 5 &&
        numOfFoot <=50 && numOfFoot >=3 && 
        numOfunit <=5 && numOfunit >=0)
        {
            isValidData = true
        }
}
function Calculate(){
    var numOfFoot = document.getElementById("footage").value
    var numOfunit = document.getElementById("numberOfUnits").value
    var x = document.getElementById("nameOfCabinet")
    var currentIndex = x.selectedIndex
    var productType = x.options[currentIndex].value

 
    var kitchenStyle = document.forms[0]
    var stylePrice = 5
   
    for (var i = 0; i < kitchenStyle.length; i++){
        if (kitchenStyle[i].checked) {
            stylePrice = kitchenStyle[i].value
        }
    }
    
    if(stylePrice != 5 &&
        numOfFoot <=50 && numOfFoot >=3 && 
        numOfunit <=5 && numOfunit >=0)
        {
            isValidData = true
        }
    
    if(isValidData= true && 
       productType ==0){
        price = priceTable[productType][stylePrice]*numOfFoot + priceTable[3][stylePrice]*numOfunit
        document.getElementById("results").value = price
       }
       if(isValidData= true && 
        productType ==1){
         price = priceTable[productType][stylePrice]*numOfFoot + priceTable[3][stylePrice]*numOfunit
         document.getElementById("results").value = price
        }
      if(isValidData = true &&
        productType ==2){
         price = priceTable[productType][stylePrice]*numOfFoot
         document.getElementById("results").value = price
        }
    else if(isValidData=false){
        alert("Please input a valid data!")
    }

}
