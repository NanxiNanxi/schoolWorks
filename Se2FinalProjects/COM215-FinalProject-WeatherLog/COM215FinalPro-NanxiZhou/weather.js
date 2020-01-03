//hide input boxes, city box shows as default
$("#Postal").hide();
$("#LatLong").hide();

//set validation to input boxes
var cityName = document.getElementById('CityName')
var countryCode = document.getElementById('CountryCode')
var countryCodePO = document.getElementById('CountryCodePO')
var postalCode = document.getElementById('PostalCode')
var latitude = document.getElementById('Latitude')
var longitude = document.getElementById('Longitude')

cityName.oninput = function (evt) {
    cityName.checkValidity();
}
countryCode.oninput = function (evt) {
    countryCode.checkValidity();
}
countryCodePO.oninput = function (evt) {
    countryCodePO.checkValidity();
}
postalCode.oninput = function (evt) {
    postalCode.checkValidity()
}
latitude.oninput = function (evt) {
    latitude.checkValidity()
}
longitude.oninput = function (evt) {
    longitude.checkValidity()
}



//check validation
function checkInput(event) {
    inputBox = event.target
    inputBox.setCustomValidity("");
    if (!inputBox.validity.valid) {
        if (inputBox == cityName) {
            if (inputBox.validity.valueMissing) {
                inputBox.setCustomValidity("City name is required.");
            }
        }
        if (inputBox == countryCode || inputBox == countryCodePO) {
            inputBox.setCustomValidity("")
            if (inputBox.validity.valueMissing) {
                inputBox.setCustomValidity('Country Code is required')
            }
            else if (inputBox.validity.patternMismatch) {
                inputBox.setCustomValidity('You must enter a 2 uppercase country code')
            }
        }
        if (inputBox == postalCode) {
            inputBox.setCustomValidity('')
            if (inputBox.validity.valueMissing) {
                inputBox.setCustomValidity('Postal Code is required!')
            }
            else if (inputBox.validity.patternMismatch) {
                inputBox.setCustomValidity('Postal code should contain valid alphabets and number!')
            }
        }
        if (inputBox == latitude) {
            inputBox.setCustomValidity('');
            if (inputBox.validity.valueMissing) {
                inputBox.setCustomValidity('Latitude is required')
            } else if (inputBox.validity.patternMismatch) {
                inputBox.setCustomValidity('Latutude should between -90 and 90')
            }
        }
        if (inputBox == longitude) {
            inputBox.setCustomValidity('');
            if (inputBox.validity.valueMissing) {
                inputBox.setCustomValidity('longitude is required')
            } else if (inputBox.validity.patternMismatch) {
                inputBox.setCustomValidity('longitude should between -180 and 180')
            }
        }

    }
};

$(document).ready(function () {
    //load the local storage to the page
    loadWeatherRecords();
    //radio function
    $('input:radio').change(
        function () {
            $("#Postal").hide();
            $("#LatLong").hide();
            $("#City").hide();
            cityName.oninvalid = null;
            countryCode.oninvalid = null;
            postalCode.oninvalid = null;
            countryCodePO.oninvalid = null;
            latitude.oninvalid = null;
            longitude.oninvalid = null;
            //check whether the search form is valid by each form
            if ($(this).val() == '1') {
                $("#City").show();
                cityName.oninvalid = checkInput;
                countryCode.oninvalid = checkInput;
            }
            if ($(this).val() == '2') {
                $("#Postal").show();
                postalCode.oninvalid = checkInput;
                countryCodePO.oninvalid = checkInput;
            } else if ($(this).val() == '3') {
                $("#LatLong").show();
                latitude.oninvalid = checkInput;
                longitude.oninvalid = checkInput;
            }
        }
    );

    $("#SearchButton").click(
        function (evt) {

            var apiKey = "52453f34dee0d65b1a41a02656142c6b"
            var searchFormIsValid = false;
            if (document.getElementById('cityRadio').checked) {
                //checkValidity for city form
                searchFormIsValid = document.getElementById('City').checkValidity();

                var CityName = $("#CityName").val();
                var CountryCode = $("#CountryCode").val();
                SearchString = "http://api.openweathermap.org/data/2.5/weather" +
                    "?q=" + CityName + "," + CountryCode +
                    "&APPID=" + apiKey;


            } else if (document.getElementById('postalRadio').checked) {
                //checkValidity for Postal form
                searchFormIsValid = document.getElementById('Postal').checkValidity();

                var Zip = $("#PostalCode").val();
                var CountryCode = $("#CountryCodePO").val();
                SearchString = "http://api.openweathermap.org/data/2.5/weather" +
                    "?zip=" + Zip + "," + CountryCode +
                    "&APPID=" + apiKey;
            } else if (document.getElementById('LatLongRadio').checked) {
                //checkValidity for LatLong form
                searchFormIsValid = document.getElementById('LatLong').checkValidity();
                var latitudeValue = $("#Latitude").val();
                var longitudeValue = $("#Longitude").val();
                SearchString = "http://api.openweathermap.org/data/2.5/weather" +
                    "?lat=" + latitudeValue + "&lon=" + longitudeValue +
                    "&APPID=" + apiKey;
            }
            //if the search form we checked is valid,then fire the search button click event
            if (searchFormIsValid) {
              
                var xhttp = new XMLHttpRequest();

                xhttp.onreadystatechange = function () {
                    //Call back function (event handler)
                    //process response from the server.
                    if (this.readyState == 4 && this.status == 200) {
                        //get raw data from XMLHttpReqest
                        var SearchResponse = this.responseText;
                        var weatherObj = JSON.parse(SearchResponse);

                        //assign viarables to objs that parsed from searchResponse string
                        var city_name = weatherObj["name"];
                        var country_name = weatherObj["sys"]["country"];
                        var weather_description = weatherObj["weather"][0]["description"];
                        var tempera_ture = weatherObj["main"]["temp"] - 273.15;
                        var pressure = weatherObj["main"]["pressure"];
                        var wind_speed = weatherObj["wind"]["speed"];
                        var humidity = weatherObj["main"]["humidity"];
                        var wind_direction = weatherObj["wind"]["deg"];
                        var sun_rise = new Date(weatherObj["sys"]["sunrise"] * 1000);
                        var sun_set = new Date(weatherObj["sys"]["sunset"] * 1000);
                        var lati_tude = weatherObj["coord"]["lat"];
                        var longi_tude = weatherObj["coord"]["lon"];
                        var id = $.now();

                        //assign values to result objs
                        var weatherToString = {
                            City: city_name, Country: country_name, Longitude: longi_tude,
                            Latitude: lati_tude, Weather: weather_description, Temperature: tempera_ture,
                            Pressure: pressure, Humidity: humidity, WindSpeed: wind_speed, windDire: wind_direction, Sunrise: sun_rise.toLocaleTimeString(),
                            Sunset: sun_set.toLocaleTimeString(),
                            id: id
                        };


                        myJSON = JSON.stringify(weatherToString)

                        //store myJson into local storage
                        store(myJSON);

                        //append new record line at the bottom of search log
                        loadNewWeatherRecord(weatherToString);

                        $("#getCity").html("City: " + city_name);
                        $("#getCountry").html("Country: " + country_name);
                        $("#getWeather").html("Weather: " + weather_description);

                        //I matched the value of checkboxes with current weather table's td index, 
                        //then create an array for check boxes and use a loop to get the index for the result td that need to be shown in 
                        //current weather table.
                        var insertResult = new Array();
                        insertResult[0] = "Temperature: " + tempera_ture;
                        insertResult[1] = "Latitude: " + lati_tude;
                        insertResult[2] = "Longitude: " + longi_tude;
                        insertResult[3] = "Pressure: " + pressure;
                        insertResult[4] = "Humidity: " + humidity;
                        insertResult[5] = "Wind Speed: " + wind_speed;
                        insertResult[6] = "Wind Direction: " + wind_direction;
                        insertResult[7] = "Sunrise: " + sun_rise.toLocaleTimeString();
                        insertResult[8] = "Sunset: " + sun_set.toLocaleTimeString();

                        var itemCheck = document.getElementsByName("searchResult");

                        for (var i = 0; i < itemCheck.length; i++) {
                            if (itemCheck[i].checked) {
                                $("#" + itemCheck[i].value).html(insertResult[itemCheck[i].value]);
                            }
                            else {
                                $("#" + itemCheck[i].value).html("");
                            }
                        }
                    };
                }

                xhttp.open("GET", SearchString, true);
                xhttp.send();

                var searchResult = document.forms[1];
                var checkBoxValue = new Array();
                //loop through radio buttons and hide the input box
                for (var i = 0; i < searchResult.length; i++) {
                    if (searchResult[i].checked) {
                        checkBoxValue = searchResult[i].value
                    }
                }
                for (var i = 0; i < checkBoxValue.length; i++) {

                    $('.currentWeatherTable div:not(:contains(' + checkBoxValue[i] + '))').hide();

                }
            }

        });

    //Store function for storing jason into local storage, if there's new record, 
    //it will add the new record to the old records
    function store(weatherToString) {

        var weathers = new Array();
        if (localStorage.getItem('weatherJSON')) {
            weathers = JSON.parse(localStorage.getItem('weatherJSON'));
        }

        weathers.push(weatherToString);
        localStorage.setItem('weatherJSON', JSON.stringify(weathers));
    }

    $(mainElement).find("#clearLogButton").click(
        function (evt) {
            evt.preventDefault();
            localStorage.clear();
            $(mainElement).find('#storageTable').empty();
        }
    );

    $(mainElement).on("click", "#deleteRowButton",
        function (evt) {
            evt.preventDefault();
            deleteWeather(evt);
        }
    );
    //this function is for appending a new line to research log after clicking serach button and received a valid data 
    function loadNewWeatherRecord(weatherRecord) {


        var row = $('<tr>');
        var html = '<td>' + weatherRecord.City + '</td>' +
            '<td>' + weatherRecord.Country + '</td>' +
            '<td>' + weatherRecord.Longitude + '</td>' +
            '<td>' + weatherRecord.Latitude + '</td>' +
            '<td>' + weatherRecord.Weather + '</td>' +
            '<td>' + weatherRecord.Temperature + '</td>' +
            '<td>' + weatherRecord.Pressure + '</td>' +
            '<td>' + weatherRecord.Humidity + '</td>' +
            '<td>' + weatherRecord.WindSpeed + '</td>' +
            '<td>' + weatherRecord.windDire + '</td>' +
            '<td>' + weatherRecord.Sunrise + '</td>' +
            '<td>' + weatherRecord.Sunset + '</td>' +
            '<td><input id="deleteRowButton" type="button" value="delete row" /></td>';


        row.data().weatherRecordID = weatherRecord.id;
        row.append(html);
        $('#weatherLog').find('#storageTable').append(row);
    }
    //delete a single log row
    function deleteWeather(evt) {
        var weatherId = $(evt.target).parents('tr').data().weatherRecordID;
        var weathers = JSON.parse(localStorage.getItem('weatherJSON'));
        var newWeather = weathers.filter(function (w) {
            var weather = JSON.parse(w);
            return weather.id != weatherId;
        });
        localStorage.setItem('weatherJSON', JSON.stringify(newWeather));
        $(evt.target).parents('tr').remove();


    }
});


//create a fuction for loading the local storage and output it into the search log
var mainElement = document.getElementById('weatherLog');
function loadWeatherRecords() {
    //get all the local storage data(as an array) from retrieveAll function. 
    //I returned an array as local storage in that function, then loop through the array, output to the search log
    var weatherStored = retrieveAll();
    if (weatherStored) {
        $.each(weatherStored, function (i, val) {
            weatherRecords = JSON.parse(val);
            var row = $('<tr>');
            var html = '<td>' + weatherRecords.City + '</td>' +
                '<td>' + weatherRecords.Country + '</td>' +
                '<td>' + weatherRecords.Longitude + '</td>' +
                '<td>' + weatherRecords.Latitude + '</td>' +
                '<td>' + weatherRecords.Weather + '</td>' +
                '<td>' + weatherRecords.Temperature + '</td>' +
                '<td>' + weatherRecords.Pressure + '</td>' +
                '<td>' + weatherRecords.Humidity + '</td>' +
                '<td>' + weatherRecords.WindSpeed + '</td>' +
                '<td>' + weatherRecords.windDire + '</td>' +
                '<td>' + weatherRecords.Sunrise + '</td>' +
                '<td>' + weatherRecords.Sunset + '</td>' +
                '<td><input id="deleteRowButton" type="button" value="delete row" /></td>';

            row.data().weatherRecordID = weatherRecords.id;

            row.append(html);
            $(mainElement).find('#storageTable').append(row);
        })
    }
}

//get all local storage data as an array, return it to loadWeatherRecords fuction
function retrieveAll() {
    var arrayString = localStorage.getItem('weatherJSON');
    var array = JSON.parse(arrayString);
    return array;
}


