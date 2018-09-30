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
            <h3>${tituloModificarCliente}</h3>
            <h6>${mensajeModificarCliente}</h6>
        </div>
        <form id="modificarCliente" method="POST" action="/cliente/modificar/${cliente.id}">
            <div class="form-group">
                <input type="text" class="form-control" name="id" value="${cliente.id}" required readonly/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="nombre" value="${cliente.nombre}" required/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="cedula" value="${cliente.cedula}""
                       required />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="telefono" value="${cliente.telefono}"
                       required />
            </div>
            <div class="custom-file">
                <input type="file" class="custom-file-input" name="fotografia" value="${cliente.fotografia}">
                <label class="custom-file-label" for="validatedCustomFile">${placerholderFotografia}</label>
            </div>
            <button type="submit" class="btn btn-primary mt-2">${acciones2}</button>
        </form>
    </main>
</div>
</body>
</@base.pagina>