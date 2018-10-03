<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-body">
        <#if sizeFamilia>
            <a class="btn btn-primary mb-2" href="/equipo/crear"><i
                    class="fas fa-plus"></i> ${botonCrear} ${linkEquipos}</a>
            <#if equipos?size gt 0>
                <table class="table table-hover table-responsive-sm">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>${placeholderNombreEquipo}</th>
                        <th>${placeholderFamiliaEquipo}</th>
                        <th>${placeholderSubFamiliaEquipo}</th>
                        <th>${placeholderExistencia}</th>
                        <th>${placeholderCostoPorDia}</th>
                        <th>${placeholderImagen}</th>
                        <th>${acciones}</th>
                        <th>${acciones2}</th>
                        <th>Subir Foto</th>
                    </tr>
                    </thead>
                    <tbody>

        <#list equipos as equipo>
        <tr>
            <td>${equipo.id}</td>
            <td>${equipo.nombre}</td>
            <#if equipo.familia??>
                <td>${equipo.familia.nombre}</td>
            </#if>
            <#if equipo.subFamilia??>
                <td>${equipo.subFamilia.nombre}</td>
            </#if>
            <td>${equipo.existencia}</td>
            <td>${equipo.costoPorDia}</td>
            <td><img class="rounded-circle" src="/img/${equipo.imagen}" alt="imagenequipo" height="48px" width="48px"></td>
            <form method="POST" action="/equipo/eliminar-equipo/${equipo.id}">
                <td>
                    <button type="submit" class="btn btn-danger"><i class="far fa-trash-alt"></i></button>
                </td>
            </form>
            <form method="POST" action="/equipo/modificar-equipo/${equipo.id}">
                <td>
                    <button type="submit" class="btn btn-success"><i class="far fa-edit"></i></button>
                </td>
            </form>
            <td><form method="POST" action="/equipo/subir-foto/${equipo.id}" enctype="multipart/form-data">
                <div class="input-group mb-3">
                    <div class="custom-file">
                        <input type="file" name="file" class="custom-file-input" id="inputGroupFile01">
                        <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                    </div>
                    <div class="input-group-prepend">
                        <input type="submit" class="input-group-text" />
                    </div>
                </div>
            </form>
            </td>
        </tr>
        </#list>
                    </tbody>
                </table>
            <#else>
                <div class="alert alert-primary">
                    ${mensajeNoEquipos}
                </div>
            </#if>
        <#else>
            <div class="alert alert-primary">
                ${mensajeNoFamilias}
            </div>
        </#if>
    </div>
</div>
</@base.pagina>