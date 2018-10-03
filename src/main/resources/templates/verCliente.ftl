<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-header">
        <h5 class="card-title">
            ${datosDelCliente}
        </h5>
    </div>
    <div class="card-body">
        <div class="alert alert-secondary p-2">
            <img class="rounded-circle" src="/img/${cliente.fotografia}" alt="fotocliente" width="100px">
            <span><strong>ID: </strong> ${cliente.id}</span>
            &nbsp;|&nbsp;
            <span><strong>${placeholderNombreCliente}: </strong> ${cliente.nombre}</span>
            &nbsp;|&nbsp;
            <span><strong>${placeholderCedula}: </strong> ${cliente.cedula}</span>
            &nbsp;|&nbsp;
            <span><strong>${placerholderTelefono}: </strong> ${cliente.telefono}</span>
        </div>
        <table class="table table-hover table-responsive-sm">
            <caption>${equiposDelCliente}</caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>${fechaCreacion}</th>
                <th>${fechaEntrega}</th>
                <th>${clienteMensaje}</th>
                <th>${total}</th>
            </tr>
            </thead>
            <tbody>
				<#list alquileres as alquiler>
                <tr>
                    <td>${alquiler.id}</td>
                    <td>${alquiler.fecha?date}</td>
                    <td>${alquiler.fechaEntrega?date}</td>
                    <td>${alquiler.cliente.nombre}</td>
                    <td>${alquiler.total}</td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</@base.pagina>