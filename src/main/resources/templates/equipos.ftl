<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-body">
        <a class="btn btn-primary mb-2" href="/equipo/crear"><i class="fas fa-plus"></i> ${botonCrear} ${linkEquipos}</a>
        <table class="table table-hover table-responsive-sm">
            <thead>
            <tr>
                <th>${placeholderNombreEquipo}</th>
                <th>${placeholderFamiliaEquipo}</th>
                <th>${placeholderSubFamiliaEquipo}</th>
                <th>${placeholderExistencia}</th>
                <th>${placeholderCostoPorDia}</th>
                <th>${placeholderImagen}</th>
            </tr>
            </thead>
            <tbody>
        <#list equipos as equipo>
        <tr>
            <td>${equipo.nombre}</td>
            <#if equipo.familia??>
                <td>${equipo.familia.nombre}</td>
            </#if>
            <#if equipo.subFamilia??>
                <td>${equipo.subFamilia.nombre}</td>
            </#if>
            <td>${equipo.existencia}</td>
            <td>${equipo.costoPorDia}</td>
            <td><img src="./${equipo.imagen}" alt="imagenequipo"></td>
        </tr>
        </#list>
            </tbody>
        </table>
    </div>
</div>
</@base.pagina>