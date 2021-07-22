<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.UserBean"%>
        <div id="header" class="header-container">
            <div class="content navbar">
                <a id="logo" class="logo" title="VGHUB" href="Home.jsp"></a>
                <form id="form-ricerca" class="form-ricerca" action="#" method="get" itemprop="potentialAction" itemscope itemtype="https://schema.org/SearchAction" role="search">
                    <meta itemprop="target" content="#">
                    <div id="barra-ricerca">
                        <input id="barra-ricerca-box" accesskey="s" type="text" name="name" autocomplete="off" spellcheck="false" autocapitalize="off" itemprop="query-input" placeholder="Cerca qui">
                        <input id="barra-ricerca-submit" type="submit" value title="Ricerca">
                    </div>
                </form>
                <div class="placer"></div>
                <div class="menu-container">
                    <div class="menu-main">
                    </div>
                    <a href="javascript:void(0);" for="menu-dropdown" id="menu-button" class="menu-button" title="Menu Utente">
                    </a>
                    <div id="sub" class="submenu-container">
                        <div class="login login-content">
                            <div class="user-submenu"></div>
                            <a href="#loginregister" id="sign-link" style="display: none"></a>
                            <%if(session.getAttribute("utente")==null){ %>
                            <a class="log-link log-link-profile mostra-box" href="LoginPage.jsp">Login</a>
                            <%} else if(session.getAttribute("utente")!=null){ %>
                            <a class="log-link log-link-profile mostra-box" href="UserPage.jsp">Account</a>
                            <a class="log-link log-link-profile mostra-box" href="logout">Logout</a>
                            <%} else if(session.getAttribute("manager")!=null){ %>
                            <a class="log-link log-link-profile mostra-box" href="AdminPage.jsp">Admin</a>
                            <%} %>
                        </div>
                    </div>
                </div>
            </div>
        </div>