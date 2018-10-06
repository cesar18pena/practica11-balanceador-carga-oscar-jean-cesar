<#import "base.ftl" as base>
<@base.pagina logueado=estaLogueado usuario=usuario>
    <div class="card mt-3">
        <div class="card-body">
            <div>${mensaje} ${servidor}:${puerto}</div>
        </div>
    </div>
</@base.pagina>