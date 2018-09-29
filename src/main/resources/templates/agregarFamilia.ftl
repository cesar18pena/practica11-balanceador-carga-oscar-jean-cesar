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
            <h3>${tituloCrearFamilia}</h3>
            <h6>${mensajeCrearFamilia}</h6>
        </div>
        <form id="agregarCliente" method="POST" action="/familia/crear">
            <div class="form-group">
                <input type="text" class="form-control" name="nombre" placeholder="${placeholderNombreFamilia}" required
                       autofocus />
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="subFamilia" value="true" />
                <label class="form-check-label" for="subFamilia">${placeholderSubFamilia}</label>
            </div>
            <button type="submit" class="btn btn-primary mt-2">${botonCrear}</button>
        </form>
    </main>
</div>
</body>
</@base.pagina>