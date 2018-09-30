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
                <input type="text" class="form-control" name="nombre" value="${familia.nombre}" required />
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="subFamilia" value="true" />
                <label class="form-check-label" for="subFamilia">${placeholderSubFamilia}</label>
            </div>
            <button type="submit" class="btn btn-primary mt-2">${acciones2}</button>
        </form>
    </main>
</div>
</body>
</@base.pagina>