<%@include file="login.jsp"%>
<%@include file="register.jsp"%>

<div class="navbar-fixed">
    <ul id="dropdown1" class="dropdown-content">
        <li><a class="waves-effect waves-light modal-trigger" href="#login">Log In</a></li>
        <li><a class="waves-effect waves-light modal-trigger" href="#register">Register</a></li>
    </ul>

    <nav>
        <div class="nav-wrapper">
            <a href="index.jsp" class="brand-logo" style="padding-left: 15px">TAMPON SHOP</a>
            <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li class="active"><a href="#">Category 1</a></li>
                <li><a href="#">Category 2</a></li>
                <li><a href="#">Category 2</a></li>
                <li>
                    <a class="dropdown-trigger" href="#!" data-target="dropdown1">
                        <i class="material-icons left">person</i>Profile
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>

<ul class="sidenav" id="mobile-demo">
    <li><a href="#">Sass</a></li>
    <li><a href="#">Components</a></li>
    <li><a href="#">Javascript</a></li>
    <li><a href="#">Mobile</a></li>
</ul>