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
                <select class="custom-select" name="familia">
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
                <select class="custom-select" name="subFamilia">
                    <#list familias as familia>
                        <#if familia.subFamilia>
                            <option value="${familia.id}">${familia.nombre}</option>
                        </#if>
                    </#list>
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
            <div class="custom-file">
                <input type="file" class="custom-file-input" name="imagen" required>
                <label class="custom-file-label" for="validatedCustomFile">${placeholderImagen}</label>
            </div>
            <button type="submit" class="btn btn-primary mt-2">${botonCrear}</button>
        </form>
    </main>
</div>
</body>
</@base.pagina>