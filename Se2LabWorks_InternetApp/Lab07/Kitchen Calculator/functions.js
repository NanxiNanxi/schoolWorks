function changeBorder(opt) {
    if (opt == 1) { document.getElementById("outer").style.border = "solid blue" }
    if (opt == 2) { document.getElementById("outer").style.border = "solid red" }
    if (opt == 3) { document.getElementById("outer").style.border = "solid green" }  
}


function showPics() {
    var x = document.getElementById("nameOfCabinet")
    var currentIndex = x.selectedIndex
   
    if (x.options[currentIndex].value == "x1") {
        document.getElementById("showPic").innerHTML = "<img src='wall.jpg'>"
        document.getElementById("showPic2").innerHTML = "<img src='corners.jpg'>"
        document.getElementById("showPic2").style.visibility = "visible"
        document.getElementById("showPic").style.visibility = "visible"
        document.getElementById("counterTop").style.visibility = "visible"
    }
    if (x.options[currentIndex].value == "x2") {
        document.getElementById("showPic").innerHTML = "<img src='base.jpg'>"
        document.getElementById("showPic2").innerHTML = "<img src='corners.jpg'>"
        document.getElementById("counterTop").style.visibility = "visible"
        document.getElementById("showPic2").style.visibility = "visible"
        document.getElementById("showPic").style.visibility = "visible"
    }
    if (x.options[currentIndex].value == "x3") {
        document.getElementById("showPic").innerHTML = "<img src='counters.jpg'>"
        document.getElementById("counterTop").style.visibility="hidden"
       // document.getElementById("showPic2").innerHTML = ""
        document.getElementById("showPic2").style.visibility = "hidden"
        document.getElementById("showPic").style.visibility = "visible"
    }
    if (x.options[currentIndex].value == "0") {
        document.getElementById("counterTop").style.visibility = "visible"
        document.getElementById("showPic2").style.visibility = "hidden"
        document.getElementById("showPic").style.visibility = "hidden"
    }

}

var priceTable =[
    [99.99,179,200.99],
    [69.99,79,99.99],
    [30.99,189.99,212.99],
    [50.99,79.99,89.99]
]


var price
var x1y1 = 99.99
var x1y2 = 179
var x1y3 = 200.99
var x2y1 = 69.99
var x2y2 = 79
var x2y3 = 99.99
var x3y1 = 30.99
var x3y2 = 189.99
var x3y3 = 212.99
var x4y1 = 50.99
var x4y2 = 79.99
var x4y3 = 89.99
function Calculate(){
    var numOfFoot = document.getElementById("footage").value
    var numOfunit = document.getElementById("numberOfUnits").value
    var x = document.getElementById("nameOfCabinet")
    var currentIndex = x.selectedIndex
    var kitchenStyle = document.forms[0]
    var stylePrice = 0
    if (x.options[currentIndex].value == "0") {
        alert("Please choose a product type!")
        return
    }
    for (var i = 0; i < kitchenStyle.length; i++){
        if (kitchenStyle[i].checked) {
            stylePrice = kitchenStyle[i].value
        }
    }
    if (stylePrice == 0) {
        alert("Please choose a product line!")
        return
    }
    if (numOfFoot == "" || numOfFoot > 50 || numOfFoot<3) {
        alert("Linear footage must be between 3 to 50 feet. Please enter a valid footage number!")
        return
    }
    
    if (x.options[currentIndex].value == "x1") {
        if (numOfunit == "" || numOfunit < 0 || numOfunit > 5) {
            alert("The number of Corner Units must be from 0 to 5. Please enter a valid unit number!")
            return
        }
        if(stylePrice == "y1"){price = x1y1 * numOfFoot +x4y1*numOfunit}
        if(stylePrice == "y2"){price = x1y2 * numOfFoot +x4y2*numOfunit}
        if(stylePrice == "y3"){price = x1y3 * numOfFoot +x4y3*numOfunit}
    }
    if (x.options[currentIndex].value == "x2") {
        if (numOfunit == "" || numOfunit < 0 || numOfunit >5) {
            alert("The number of Corner Units must be from 0 to 5. Please enter a valid unit number!")
            return
        }
        if(stylePrice == "y1"){price = x2y1 * numOfFoot +x4y1*numOfunit}
        if(stylePrice == "y2"){price = x2y2 * numOfFoot +x4y2*numOfunit}
        if(stylePrice == "y3"){price = x2y3 * numOfFoot +x4y3*numOfunit}
    }
    if (x.options[currentIndex].value == "x3") {
        if(stylePrice == "y1"){price = x3y1 * numOfFoot}
        if(stylePrice == "y2"){price = x3y2 * numOfFoot}
        if(stylePrice == "y3"){price = x3y3 * numOfFoot}
    }
    document.getElementById("results").value = price
}