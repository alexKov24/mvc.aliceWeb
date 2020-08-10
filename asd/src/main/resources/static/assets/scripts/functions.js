function toggleText(obj){

    if($(obj).attr("value") != "")
    {
       $(obj).attr("value","");
    }
    else
    {
        $(obj).attr("value",$(obj).attr("class"));
    }

}

var arrayOfWords = ["more!!","enslave !!!","you sure?","you better not"];

var row = 4;

function errorFunction(){
    $("#mid").text("");
    $("#mid").append(
        "<div class='getOut error'>" +
           "no connection to dataBase"+
        " </div>"
    );
}



