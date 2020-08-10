function loadAllEmployees(){
    console.log("got into loadAllEmployees")
    $.ajax({
        url: "/loadAllEmployees",
        success: function (data) {

            console.log(data);

            var empArr = JSON.parse(data);

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

            });

        },
        fail: function (err) {
            console.log(err);

        },
        error: function(err){
            console.log(err);

        }
    });
}
