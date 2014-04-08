<!DOCTYPE html>
<html ng-app="web-project-seed">
    <head>
        <title>Web Project Seed</title>
        <link rel="stylesheet" href="assets/dist/css/all.css"/>
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
                        <li><a href="#/foo">foo</a></li>
                        <li><a href="#/bar">bar</a></li>
                        <li><a href="#/baz">baz</a></li>
                    </ul>
                </div>
            </div>
            <div ng-view/>
        </div>
        <script src="assets/dist/js/all.js"></script>
    </body>
</html>