<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
<div class="card mt-3">
    <div class="card-body">
        <a class="btn btn-primary mb-2" href="/alquiler/crear"><i class="fas fa-plus"></i> ${botonCrear} ${linkAlquiler} </a>
        <#if sizeAlquiler>
             <table class="table table-hover table-responsive-sm">
                 <thead>
                 <tr>
                     <th>ID</th>
                     <th>${fechaCreacion}</th>
                     <th>${fechaEntrega}</th>
                     <th>${clienteMensaje}</th>
                     <th>${total}</th>
                     <th>${ver}</th>
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
            <form method="POST" action="/alquiler/ver/${alquiler.id}">
                <td><button type="submit" class="btn btn-primary"><i class="far fa-eye"></i></button></td>
            </form>
        </tr>
        </#list>
                 </tbody>
             </table>
        <#else>
        <div class="alert alert-primary">
            No hay alquileres registrados.
        </div>
        </#if>
    </div>
</div>
</@base.pagina>