function moveToGet(){

    $("#top").text("get all")
    $("#top").append("<p style='font-size:20px; margin: 0;'>(there you go)</p>");

    $("#mid").text("");

    checkConnection(loadAllEmployees());
}
