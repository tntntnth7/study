var main = {
    init : function () {
        var _this = this;
<<<<<<< HEAD
        $('#btn-save').on('click', function (){
            _this.save();
        });
    },
    save : function (){
=======
        $('#btn-save').on('click',function (){
            _this.save();
        });
    },
    save : function(){
>>>>>>> origin/master
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/posts',
            dataType : 'json',
<<<<<<< HEAD
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function(){
            alert("글이 등록되었습니다.");
            window.location.href = '/';
=======
            contentType : 'application/json; charset=utr-8',
            data : JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = "/";
>>>>>>> origin/master
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();