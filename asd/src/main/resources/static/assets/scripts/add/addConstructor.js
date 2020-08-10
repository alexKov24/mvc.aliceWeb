
var currentPage;

function moveToAdd(){

    $("#top").text("add one")
    $("#top").append("<p id='topSub'>employee</p>");

    $("#mid").text("");

    function onSuccess(){
        appendMidForAdd();
        document.querySelector("#salaryInput").addEventListener('input',checkInput);
    }

    checkConnection(onSuccess())
}

function appendMidForAdd(){

        $("#mid").append(
        "<div id='main_container'>"+
        "<input id='nameInput' type='text' class='name' value='name' onmouseenter='toggleText(this)' onmouseleave='toggleText(this)' >"+

        "<input id='salaryInput' class='salary' value='salary' onmouseenter='toggleText(this)' onmouseleave='toggleText(this)' >"+

        "<div class='jobContainer' style='grid-row:3; grid-column:3'>"+
        "<input class='description' value='description' onmouseenter='toggleText(this)' onmouseleave='toggleText(this)'>"+

        "<input class='end date' type='date' value='end date' onmouseenter='toggleText(this)' onmouseleave='toggleText(this)'>"+
        "</div>"+

        "<button id='saving_button' style='grid-row=5' onclick='saveEmployee()' >save</button>"+

        "<button id='loadmore_button' style='grid-row=6' onclick='loadMoreJobs()' >more</button>"+

        "</div>"
    );
}

