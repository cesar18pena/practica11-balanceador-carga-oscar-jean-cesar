<#macro pagina logueado=false usuario="">
<!DOCTYPE html>
<html lang="es">
<head>
    <!-- Bootstrap 4.1 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>

    <!-- Font Awesome 5.3 -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">


    <link rel="stylesheet" href="/css/style.css"/>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="row">
                <div class="col-12 p-0">
                    <nav class="navbar navbar-expand-lg navbar-dark">
                        <a class="navbar-brand" href="/">${titulo}</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="/"><i class="fas fa-home"></i> ${linkInicio}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/cliente/"><i class="fas fa-user-circle"></i> ${linkClientes}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/familia/"><i class="fas fa-registered"></i> ${linkFamilia}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/equipo/"><i class="fas fa-wrench"></i> ${linkEquipos}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/alquiler/"><i class="fas fa-file-invoice"></i> ${linkAlquiler}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/graficas/"><i class="fas fa-chart-line"></i> ${linkGraficas}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/crear-usuario"><i class="fas fa-user"></i> ${linkUsuario}</a>
                            </li>
                        </ul>
                        <a class="btn btn-outline-light mr-2" href="/creador">
                            <i class="fas fa-hdd"></i> ${creador}
                        </a>
                        <strong class="avatar text-white">
                            <img src="https://i.imgur.com/rWS64lZ.gif" class="rounded-circle mr-2" alt="avatar">
                            <span class="mr-1">${usuario}</span>
                            <form action="/logout" method="POST" class="d-inline">
                                <button type="submit" class="rounded-circle border-icon fas fa-power-off"></button>
                            </form>
                        </strong>
                    </nav>
                </div>
            </div>
            <#nested>
        </div>
    </div>
</div>
</body>
</html>
</#macro>