<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" href="/css/login.css"/>
    <title>${titulo}</title>
</head>
<body>
<div class="login-form">
    <main class="mx-auto mt-2">
        <div class="panel">
            <h3>${tituloModificarFamilia}</h3>
            <h6>${mensajeModificarFamilia}</h6>
        </div>
        <form id="agregarCliente" method="POST" action="/familia/modificar/${familia.id}">
            <div class="form-group">
                <input type="text" class="form-control" name="id" value="${familia.id}" required readonly/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="nombre" value="${familia.nombre}" required/>
            </div>
            <div class="form-check form-check-inline">
                <#if familia.subFamilia>
                    <input class="form-check-input" type="checkbox" name="subFamilia" value="true" checked  id="subFamilia" onclick="cambiar()"/>
                <#else>
                    <input class="form-check-input" type="checkbox" name="subFamilia" value="true"  id="subFamilia" onclick="cambiar()"/>
                </#if>
                <label class="form-check-label" for="subFamilia">${placeholderSubFamilia}</label>
            </div>
            <div class="input-group mb-3" id="familiaPadre">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">${placeholderFamiliaPadre}</label>
                </div>
                <select class="custom-select" name="familiaPadre">
                    <#list familias as familiaX>
                        <#if !familiaX.subFamilia>
                            <#if familia.familiaPadre??>
                                <#if familiaX.id==familia.familiaPadre.id>
                                    <option value="${familiaX.id}" selected>${familiaX.nombre}</option>
                                <#else>
                                    <option value="${familiaX.id}">${familiaX.nombre}</option>
                                </#if>
                                <#else>
                                    <#if familiaX.id != familia.id>
                                        <option value="${familiaX.id}">${familiaX.nombre}</option>
                                    </#if>
                            </#if>
                        </#if>
                    </#list>
                </select>
            </div>
            <button type="submit" class="btn btn-primary mt-2">${acciones2}</button>
        </form>
    </main>
</div>
</body>

<script>
    var estado = "${familia.subFamilia?c}";

    var familiaPadre = document.querySelector("#familiaPadre");

    console.log(estado);

    if (estado == "true") {
        familiaPadre.style.visibility = "visible";
    } else {
        familiaPadre.style.visibility = "collapse";
    }

    function cambiar() {
        if (familiaPadre.style.visibility === "collapse") {
            document.querySelector("#familiaPadre").style.visibility = "visible";
        } else {
            document.querySelector("#familiaPadre").style.visibility = "collapse";
        }
    }
</script>
</@base.pagina>