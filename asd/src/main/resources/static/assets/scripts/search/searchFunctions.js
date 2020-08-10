function search(){

    var searchValue = $(".search").val();

    if(isNaN(searchValue)){
        searchByName(searchValue);
    }
    else if(!isNaN(searchValue))
    {
        searchById(searchValue);
    }
}

function searchById(searchValue){
        $.ajax({
        url: "/searchById",
        data:{"id":searchValue},
        success: function (data) {
            
                addArrToMid(data)

        },
        fail: function (err) {

        },
        error: function(){
            alert("error search by id")
        }
    });
}

function searchByName(searchValue){
    $.ajax({
        url: "/searchByName",
        data:{"name":searchValue},
        success: function (data) {
            
               addArrToMid(data);

        },
        fail: function (err) {
            console.log(err);
            errorFunction();
        },
        error: function(err){
            console.log(err);
            errorFunction();
        }
    });
}

function addArrToMid(data){
    var empArr = JSON.parse(data);
    if(!empArr[0]){
        $(".hint").append("no user found");
        return;
    }
    moveToSearch();
        $("#mid").append("<div id='infoContainer'><div>");

            $("#infoContainer").append(
                "<div class='infoHeader'>" +
                "<p>id</p>" +
                "<p>name</p>" +
                "<p>salary</p>" +
                "<p>job id</p>" +
                "<p>description</p>" +
                "<p>end date</p>" +
                "</div>"
            );

            empArr.forEach(function(emp){
                
                    $("#infoContainer").append(
                        "<div class='seperator'></div>"+
                        "<div class='empInfo'>" +
                        "<p>" + emp.emp_id + "</p>" +
                        "<p>" + emp.name + "</p>" +
                        "<p>" + emp.salary + "</p>" +
                        " </div>"
                    );

                    emp.jobs.forEach(function(job){

                        $("#infoContainer").append(
                            "<div class='jobInfo'>" +
                            "<p>" + job.id + "</p>" +
                            "<p>" + job.description + "</p>" +
                            "<p>" + job.endDate + "</p>" +
                            "</div>"
                        );
                    })

/*                    $("#mid").append(
                        "<div class='getOut headGet'>" +
                        "<p>id</p>" +
                        "<p>name</p>" +
                        "<p>salary</p>" +
                        "</div>"
                    );

                    $("#mid").append(
                        "<div class='getOut '>" +
                        "<p>" + emp.emp_id + "</p>" +
                        "<p>" + emp.name + "</p>" +
                        "<p>" + emp.salary + "</p>" +
                        " </div>"
                    );

                    emp.jobs.forEach(function(job){

                       $("#mid").append(
                            "<div class='getOut headGet'>" +
                            "<p>job id</p>" +
                            "<p>description</p>" +
                            "<p>end date</p>" +
                            "</div>"
                        );

                        $("#mid").append(
                            "<div class='getOut'>" +
                            "<p>" + job.id + "</p>" +
                            "<p>" + job.description + "</p>" +
                            "<p>" + job.endDate + "</p>" +
                            "</div>"
                        );
                    })

            })*/
})
}