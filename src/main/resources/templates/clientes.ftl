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
                    <th>${placerholderFotografia}</th>
                    <th>${placeholderNombreCliente}</th>
                    <th>${placeholderCedula}</th>
                    <th>${placerholderTelefono}</th>
                    <#if esAdmin>
                        <th>${acciones}</th>
                        <th>${acciones2}</th>
                    </#if>
                    <th>${ver}</th>
                    <#if esAdmin>
                        <th>${subirFoto}</th>
                    </#if>
                </tr>
                </thead>
                <tbody>
        <#list clientes as cliente>
        <tr>
            <td>${cliente.id}</td>
            <td><img class="rounded-circle" src="/img/${cliente.fotografia}" alt="fotocliente" height="48px" width="48px"></td>
            <td>${cliente.nombre}</td>
            <td>${cliente.cedula}</td>
            <td>${cliente.telefono}</td>
            <#if esAdmin>
            <form method="POST" action="/cliente/eliminar-cliente/${cliente.id?string['0']}">
                <td>
                    <button type="submit" class="btn btn-danger">
                        <i class="far fa-trash-alt"></i>
                    </button>
                </td>
            </form>
            <form method="POST" action="/cliente/modificar-cliente/${cliente.id?string['0']}">
                <td>
                    <button type="submit" class="btn btn-success">
                        <i class="far fa-edit"></i>
                    </button>
                </td>
            </form>
            </#if>
            <td>
                <a href="/cliente/ver/${cliente.id?string['0']}" class="btn btn-primary">
                    <i class="far fa-eye"></i>
                </a>
            </td>
            <#if esAdmin>
            <td>
                <form method="POST" action="/cliente/subir-foto/${cliente.id}" enctype="multipart/form-data">
                    <div class="input-group mb-3">
                        <div class="custom-file">
                            <input type="file" name="file" class="custom-file-input" id="inputGroupFile01">
                            <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                        </div>
                        <div class="input-group-prepend">
                            <input type="submit" class="input-group-text"/>
                        </div>
                    </div>
                </form>
            </td>
            </#if>
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