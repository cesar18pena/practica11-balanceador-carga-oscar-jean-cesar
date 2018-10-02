<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-body">
        <a class="btn btn-primary mb-2" href="/cliente/crear"><i class="fas fa-plus"></i> ${botonCrear} ${linkClientes}
        </a>
        <#if clientes?size gt 0>
            <table class="table table-hover table-responsive-sm">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>${placeholderNombreCliente}</th>
                    <th>${placeholderCedula}</th>
                    <th>${placerholderTelefono}</th>
                    <th>${placerholderFotografia}</th>
                    <th>${acciones}</th>
                    <th>${acciones2}</th>
                </tr>
                </thead>
                <tbody>
        <#list clientes as cliente>
        <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nombre}</td>
            <td>${cliente.cedula}</td>
            <td>${cliente.telefono}</td>
            <td><img src="./${cliente.fotografia}" alt="fotocliente" width="20px"></td>
            <form method="POST" action="/cliente/eliminar-cliente/${cliente.id}">
                <td>
                    <button type="submit" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
                </td>
            </form>
            <form method="POST" action="/cliente/modificar-cliente/${cliente.id}">
                <td>
                    <button type="submit" class="btn btn-success"><i class="far fa-edit"></i></button>
                </td>
            </form>
        </tr>
        </#list>
                </tbody>
            </table>
        <#else>
            <div class="alert alert-primary">
                ${mensajeNoClientes}
            </div>
        </#if>

    </div>
</div>
</@base.pagina>