<%@ page %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html ng-app="whirlwin">
    <head>
        <title>whirlwin</title>
        <link rel="stylesheet" href="/assets/dist/all.css"/>
    </head>
    <body>
        <div class="container">
            <div class="navbar navbar-default">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="/" class="navbar-brand">whirlwin</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/blog">Blog</a></li>
                        <li><a href="/login">Login</a></li>
                    </ul>
                </div>
            </div>
            <div ng-view/>
        </div>

        <!--
        <script src="/assets/dist/libs.js"></script>
        <script src="/assets/dist/custom.js"></script>
        -->
        <script src="/assets/dist/all.js"></script>
    </body>
</html>