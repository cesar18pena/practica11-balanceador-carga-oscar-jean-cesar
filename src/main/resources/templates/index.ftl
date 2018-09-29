<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
    <div class="card mt-3">
        <div class="card-body">
            <div>${mensaje}</div>
        </div>
    </div>
</@base.pagina>