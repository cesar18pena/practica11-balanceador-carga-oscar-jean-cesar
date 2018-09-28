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
            <h3>${tituloLogin}</h3>
            <h6>${mensajeLogin}</h6>
        </div>
        <form id="Login" method="POST" action="/login">
            <div class="form-group">
                <input type="text" class="form-control" name="username" placeholder="${placeholderUsuario}" required autofocus>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="${placerholderContrasena}" required>
            </div>
            <button type="submit" class="btn btn-primary">${botonEntrar}</button>
        </form>
    </main>
</div>
</body>