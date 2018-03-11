
		<div class="col-sm-10">
			<div class="col-lg-12">

				<h2>Gesti�n de Roles</h2>
            </div>

<h4>Roles</h4>
<p>Los roles configuran el nivel de acceso de los usuarios en la aplicaci�n, estos accesos estan vinculados a las URLS que solicita el usuario. Esa url tiene un nivel de acceso y tambien pertenece a un m�dulo, por lo que el rol debe actuar de forma distinta para cada uno de los m�dulos de la aplicacion.</p>
<p>Por ejemplo:</p>
<ul>
<li>El rol 'Gestor' tiene un nivel de 1 (acceso admin) en el modulo de Gesti�n de contenidos</li>
<li>El rol 'Gestor' tiene un nivel de 3 (acceso restringido) en el modulo de Facturaci�n</li>
</ul>
<p>Como podemos ver, el comportamiento del usuario es distinto en cada uno de los m�dulos de la aplicacion, gracias a esto podemos definir de forma concreta la accesibilidad de cada usuario en cada uno de los m�dulos de la aplicaci�n.</p>
<hr>

<h4>Funciones b�sicas para la administraci�n de Roles</h4>
<ul class="nav  nav-stacked" >
<li><a href="menu-addRol"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Nuevo rol</a></li>
<li><a href="list-rol"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Modificar roles</a></li>
</ul>




		</div>
	<jsp:include page="navbar-control-roles.jsp" />