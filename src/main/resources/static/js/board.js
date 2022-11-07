
let index= {

    init: function () {
        $("#btn-board-save").on("click", () => {
            this.save();
        });

        $("#btn-delete").on("click", () => {
            this.deleteById();
        });

        $("#btn-update").on("click", () => {
            this.update();
        });
    },




    save: function () {

        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        }

        //console.log(data);
        //ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", //바디데이터가 어떤 타입인지
            dataType: "json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든것이 문자열(생긴게 json이라면 js 오브젝트로 변경
        }).done(function (resp) {
            alert("글쓰기가 완료되었습니다.");
            console.log(resp);
            location.href="/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
        //통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    },

    deleteById : function () {
        let id = $("#id").text();
        //console.log(data);
        //ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
        $.ajax({

            type: "DELETE",
            url: "/api/board/"+id,
            dataType: "json" ,
            contentType: 'application/json; charset=utf-8'
        }).done(function (resp) {
            alert("삭제가 완료되었습니다.");
            console.log(resp);
            location.href="/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
        //통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    },

    update : function () {
        let id = $("#id").val();

        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };
        //console.log(data);
        //ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
        $.ajax({

            type: "PUT",
            url: "/api/board/"+id,
            data : JSON.stringify(data),
            dataType: "json" ,
            contentType: 'application/json; charset=utf-8'
        }).done(function (resp) {
            alert("글 수정이 완료되었습니다..");
            console.log(resp);
            location.href="/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
        //통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    }
}

index.init();
