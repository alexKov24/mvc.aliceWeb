function checkConnection(successData){
    $.ajax(
                {
                    url:"/connection",
                    success: function()
                        {
                            successData;
                        },
                    error: function()
                        {
                        console.log("error establishing cinnection");

                            errorFunction();
                        },
                    fail: function(){
                        console.log("failed establishing cinnection");

                            errorFunction();
                    }

                }
            );


}
