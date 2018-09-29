<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-body">
        <a class="btn btn-primary mb-2" href="/familia/crear"><i class="fas fa-plus"></i> ${botonCrear} ${linkFamilia}</a>
        <table class="table table-hover table-responsive-sm">
            <thead>
            <tr>
                <th>${placeholderNombreFamilia}</th>
                <th>${placeholderSubFamilia}</th>
            </tr>
            </thead>
            <tbody>
        <#list familias as familia>
        <tr>
            <td>${familia.nombre}</td>
            <td>${familia.subFamilia?string('${mensajeSi}', '${mensajeNo}')}</td>
        </tr>
        </#list>
            </tbody>
        </table>
    </div>
</div>
</@base.pagina>