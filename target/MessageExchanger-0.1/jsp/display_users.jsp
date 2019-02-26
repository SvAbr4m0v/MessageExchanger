<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript">
        var jq = jQuery.noConflict();
    </script>
</head>
<body>
<h2>Spring MVC + jQuery + Autocomplete example</h2>

<div>
    <input id="searchName" name="searchName" type="text" size="5">
    <input type="submit" value="Find" onclick="find()" />
    User: <span id="foundUser"> </span>
</div>
<script type="text/javascript">
    function find() {
        jq(document).ready(function () {
            jq.post("${pageContext.request.contextPath}/display_users",
                {
                    searchId: jq("#searchName").val(),
                },
                function (data) {
                    jq("#foundUser").replaceWith('<span id="foundUser">' + data + '</span>');
                });
        });
    }
</script>





















<%--<script type="text/javascript">--%>
    <%--function find() {--%>
        <%--jq(document).ready(function() {--%>
            <%--jq.post("${pageContext.request.contextPath}/display_users",--%>
                <%--{--%>
                    <%--searchId:  jq("#searchName").val(),--%>
                <%--},--%>
                <%--function(data){--%>
                    <%--jq("#foundUser").replaceWith('<span id="foundUser">'+ data + '</span>');--%>
                <%--});--%>
        <%--});--%>
    <%--}--%>
<%--</script>--%>

<%--<script type="text/javascript">--%>
    <%--$(document).ready(function() {--%>
        <%--$('#searchId')({--%>
            <%--serviceUrl: '${pageContext.request.contextPath}/display_users',--%>
            <%--paramName: "searchName",--%>
            <%--delimiter: ",",--%>
            <%--transformResult: function(response) {--%>

                <%--return {--%>
                    <%--//must convert json to javascript object before process--%>
                    <%--suggestions: $.map($.parseJSON(response), function(item) {--%>

                        <%--return { value: item.value, data: item.id };--%>
                    <%--})--%>

                <%--};--%>

            <%--}--%>

        <%--});--%>

    <%--});--%>
<%--</script>--%>

</body>
</html>