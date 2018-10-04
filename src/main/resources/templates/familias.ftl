<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-body">
        <a class="btn btn-primary mb-2" href="/familia/crear"><i class="fas fa-plus"></i> ${botonCrear} ${linkFamilia}
        </a>
        <#if familias?size gt 0>
        <table class="table table-hover table-responsive-sm">
            <thead>
            <tr>
                <th>ID</th>
                <th>${placeholderNombreFamilia}</th>
                <th>${placeholderSubFamilia}</th>
                <th>${placeholderFamiliaPadre}</th>
                <#if esAdmin>
                    <th>${acciones}</th>
                    <th>${acciones2}</th>
                </#if>
            </tr>
            </thead>
            <tbody>
        <#list familias as familia>
        <tr>
            <td>${familia.id}</td>
            <td>${familia.nombre}</td>
            <td>${familia.subFamilia?string('${mensajeSi}', '${mensajeNo}')}</td>
            <td>
                <#if familia.subFamilia>
                    ${familia.familiaPadre.nombre}
                    <#else>
                    N/A
                </#if>
            </td>
            <#if esAdmin>
                <form method="POST" action="/familia/eliminar-familia/${familia.id}">
                    <td>
                        <button type="submit" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
                    </td>
                </form>
                <form method="POST" action="/familia/modificar-familia/${familia.id}">
                    <td>
                        <button type="submit" class="btn btn-success"><i class="far fa-edit"></i></button>
                    </td>
                </form>
            </#if>
        </tr>
        </#list>
            </tbody>
        </table>
        <#else>
            <div class="alert alert-primary">
                ${mensajeNoFamilias}
            </div>
        </#if>
    </div>
</div>
</@base.pagina>