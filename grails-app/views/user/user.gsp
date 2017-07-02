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
            <form action="${postUrl ?: '/user/addMedia'}" method="POST" id="addMediaForm" class="form"
                  autocomplete="off">
                <p>
                    <label for="mediaTypeAdd">Typ:</label>
                    <select class="" name="mediaTypeAdd" id="mediaTypeAdd">
                        <option value="book"><g:message code="inventory.media.book"/></option>
                        <option value="movie"><g:message code="inventory.media.movie"/></option>
                        <option value="music"><g:message code="inventory.media.music"/></option>
                        <option value="videogame"><g:message code="inventory.media.videogame"/></option>
                    </select>

                    <label for="mediaIdAdd">Barcode:</label>
                    <input type="text" class="text_" name="mediaIdAdd" id="mediaIdAdd"/>
                </p>

                <p>
                    <input type="submit" id="submitAdd" value="${message(code: 'inventory.user.addmedia')}"/>
                </p>
            </form>
        </div>
    </div>
    
    <div class="row">
        <div class="col-sm-12">
            <p>
                <a href="/user/show"><g:message code="inventory.user.showmedia"/></a>
            </p>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <form action="${postUrl ?: '/user/removeMedia'}" method="POST" id="removeMediaForm" class="form"
                  autocomplete="off">
                <p>
                    <label for="mediaTypeRemove">Typ:</label>
                    <select class="" name="mediaTypeRemove" id="mediaTypeRemove">
                        <option value="book"><g:message code="inventory.media.book"/></option>
                        <option value="movie"><g:message code="inventory.media.movie"/></option>
                        <option value="music"><g:message code="inventory.media.music"/></option>
                        <option value="videogame"><g:message code="inventory.media.videogame"/></option>
                    </select>

                    <label for="mediaIdRemove">Barcode:</label>
                    <input type="text" class="text_" name="mediaIdRemove" id="mediaIdRemove"/>
                </p>

                <p>
                    <input type="submit" id="submitRemove" value="${message(code: 'inventory.user.addmedia')}"/>
                </p>
            </form>
        </div>
    </div>
</div>
</body>
</html>