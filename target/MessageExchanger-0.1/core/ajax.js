<script type="text/javascript">
    function madeAjaxCall(){
    $.ajax({
        type: "post",
        url: "'${pageContext.request.contextPath}/display_users'",
        cache: false,
        data:'firstName=' + $("#firstName").val() + "&lastName;=" + $("#lastName").val() + "&email;=" + $("#email").val(),
        success: function(response){
            $('#result').html("");
            var obj = JSON.parse(response);
            $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email);
        },
        error: function(){
            alert('Error while request..');
        }
    })
}
</script>