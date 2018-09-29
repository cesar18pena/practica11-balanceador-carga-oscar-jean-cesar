<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-body">
        <a class="btn btn-primary mb-2" href="/cliente/crear"><i class="fas fa-plus"></i> ${botonCrear} ${linkClientes}</a>
        <table class="table table-hover table-responsive-sm">
            <thead>
            <tr>
                <th>${placeholderNombreCliente}</th>
                <th>${placeholderCedula}</th>
                <th>${placerholderTelefono}</th>
                <th>${placerholderFotografia}</th>
            </tr>
            </thead>
            <tbody>
        <#list clientes as cliente>
        <tr>
            <td>${cliente.nombre}</td>
            <td>${cliente.cedula}</td>
            <td>${cliente.telefono}</td>
            <td><img src="./${cliente.fotografia}" alt="fotocliente" width="20px"></td>
        </tr>
        </#list>
            </tbody>
        </table>
    </div>
</div>
</@base.pagina>