<!DOCTYPE html>
<html>
<head>
    <g:render template="/templates/commonHead"/>
</head>

<body>
<g:render template="/templates/topNavbar"/>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <g:each in="books">

            </g:each>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <g:each in="movies">

            </g:each>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <g:each in="music">

            </g:each>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <g:each in="videogames">

            </g:each>
        </div>
    </div>
</div>
</body>
</html>