<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-header">
        <h5 class="card-title">
            ${datosDelAlquiler}
        </h5>
    </div>
    <div class="card-body">
        <div class="alert alert-secondary p-2">
            <span><strong>ID: </strong> ${alquiler.id}</span>
            &nbsp;|&nbsp;
            <span><strong>${fechaCreacion}: </strong> ${alquiler.fecha?date}</span>
            &nbsp;|&nbsp;
            <span><strong>${fechaEntrega} </strong> ${alquiler.fechaEntrega?date}</span>
            &nbsp;|&nbsp;
            <span><strong>${clienteMensaje}: </strong> ${alquiler.cliente.nombre}</span>
            &nbsp;|&nbsp;
            <span><strong>${total}: </strong> ${alquiler.total}</span>
        </div>
        <table class="table table-hover table-responsive-sm">
            <caption>${equiposDelAlquiler}</caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>${placeholderNombreEquipo}</th>
                <th>${placeholderFamiliaEquipo}</th>
                <th>${placeholderSubFamiliaEquipo}</th>
                <th>${placeholderExistencia}</th>
                <th>${placeholderCostoPorDia}</th>
                <th>${placeholderImagen}</th>
                <th>${devolver}</th>
            </tr>
            </thead>
            <tbody>
				<#list equiposAlquiler as equipo>
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
                    <td><img src="./${equipo.imagen}" alt="imagenequipo"></td>
                    <form method="POST" action="/equipo/devolver/${equipo.id}/${alquiler.id}">
                        <td><button type="submit" class="btn btn-primary"><i class="fas fa-hand-holding-usd"></i></button></td>
                    </form>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</@base.pagina>