<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" href="/css/login.css"/>
    <title>${titulo}</title>
</head>
<body onload="filtrarSubFamilias()">
<div class="login-form">
    <main class="mx-auto mt-2">
        <div class="panel">
            <h3>${tituloCrearEquipo}</h3>
            <h6>${mensajeCrearEquipo}</h6>
        </div>
        <form id="agregarCliente" method="POST" action="/equipo/crear">
            <div class="form-group">
                <input type="text" class="form-control" name="nombre" placeholder="${placeholderNombreEquipo}"
                       required/>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">${placeholderFamiliaEquipo}</label>
                </div>
                <select class="custom-select" name="familia" id="familia" onchange="filtrarSubFamilias()">
                    <#list familias as familia>
                        <#if !familia.subFamilia>
                            <option value="${familia.id}">${familia.nombre}</option>
                        </#if>
                    </#list>
                </select>
            </div>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">${placeholderSubFamiliaEquipo}</label>
                </div>
                <select class="custom-select" name="subFamilia" id="listaSubFamilias">
                    <#--Esto se autogenerara-->
                </select>
            </div>
            <div class="form-group">
                <input type="number" class="form-control" name="existencia" placeholder="${placeholderExistencia}"
                       required/>
            </div>
            <div class="form-group">
                <input type="number" class="form-control" name="costoPorDia" placeholder="${placeholderCostoPorDia}"
                       required/>
            </div>
            <button type="submit" class="btn btn-primary mt-2">${botonCrear}</button>
        </form>
    </main>
</div>
</body>
<script>
    function filtrarSubFamilias() {
        var listaSubFamilias = [];
        var familiaJS = document.querySelector("#familia").value;

        <#list familias as familia>
            <#if familia.subFamilia>
                var familiaPadreJS = "${familia.familiaPadre.id?string['0']}";

                if (familiaJS == familiaPadreJS) {
                    listaSubFamilias.push({ id: "${familia.id}", nombre: "${familia.nombre}" });
                }
            </#if>
        </#list>

        document.querySelector("#listaSubFamilias").innerHTML = "";
        for (var i = 0; i < listaSubFamilias.length; i++) {
            document.querySelector("#listaSubFamilias").innerHTML += '<option value="' + listaSubFamilias[i].id +'">' + listaSubFamilias[i].nombre +'</option>';
        }

        console.table(listaSubFamilias);
    }
</script>
</@base.pagina>