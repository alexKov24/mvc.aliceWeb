

function saveEmployee(){

    var empJson = {};

    empJson.name = $("#nameInput").val();
    empJson.salary = $("#salaryInput").val();
    empJson.jobs = [];

    $(".jobContainer").each(function(){
        var job = {};
        $(this).children().each(function(){
            if ($(this).hasClass("description")){
                job.description=$(this).val();
            }else{
                job.endDate=$(this).val();
            }
        })
        empJson.jobs.push(job);
    });

    $.ajax(
                {
                    url:"/save",
                    data: {'jsonString': JSON.stringify(empJson)},

                    success: function(data)
                        {
                            if(String(data) =='true'){
                                alert("saved");
                            }
                            else{
                                alert(String(data));
                            }
                        },
                    error: function(err)
                        {
                        console.log(err);
                        errorFunction();
                        },
                    fail: function(err){
                        console.log(err);
                        errorFunction();
                    }

                }
            );
}

var row = 3;
function loadMoreJobs(){

    $("#saving_button").remove();
    $("#loadmore_button").remove();

    $("#main_container").append(
        "<div class='jobContainer' style='grid-row: "+(++row)+"; grid-column:3' >"+
        "<input class='description' value='description' onmouseenter='toggleText(this)' onmouseleave='toggleText(this)'>"+

        "<input class='end date' type='date' value='end date' onmouseenter='toggleText(this)' onmouseleave='toggleText(this)'>"+
        "</div>"+

        "<button id='saving_button' onclick='saveEmployee()' style='grid-column: 3; grid-row: "+(++row)+"; justify-self:center;'>save</button>"+
        "<button id='loadmore_button' onclick='loadMoreJobs()' style='grid-column: 3; grid-row: "+(++row)+"; justify-self:center;'>more</button>"
        );

    if(row < 20 && row > 4){
           $("#loadmore_button").text(arrayOfWords[0]);
            if(row > 8)
           $("#loadmore_button").text(arrayOfWords[1]);
            if(row > 12)
           $("#loadmore_button").text(arrayOfWords[2]);
            if(row > 16)
           $("#loadmore_button").text(arrayOfWords[3]);
    }


}

function checkInput(){

    var input = $("#salaryInput").val();

    if (isNaN(input)){
        $("#salaryInput").css("color","red");
    }else{
        $("#salaryInput").css("color","black");
    }
}
