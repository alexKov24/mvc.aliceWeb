function moveToSearch(){


    $("#top").text("search");
    $("#top").append("<p style='font-size:20px; margin: 0;'>*by id or name</p>");

    $("#mid").text("");

    checkConnection(addSearch());

}

function addSearch(){
    $("#mid").text("");
    $("#mid").append(
        "<div class='searchBlock' >"+
        "<input class='search' value='search' onmouseenter='toggleText(this)' onmouseleave='toggleText(this)' >"+
        "<p class='hint'></p>"+
        "<button id='searchButton' onclick='search()'>search</button>"+
        

        "</div>"
    );
}
