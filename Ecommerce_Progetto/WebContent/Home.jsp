<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>VGHUB</title>
        <link rel="stylesheet" href="stile.css">
    </head>
    <body>
        <a href="#" id="background-banner"></a>
        <div id="header" class="header-container">
            <div class="content navbar">
                <a id="logo" class="logo" title="VGHUB" href="#HOME">VGHUB</a>
                <form id="form-ricerca" class="form-ricerca" action="#" method="get" itemprop="potentialAction" itemscope itemtype="https://schema.org/SearchAction" role="search">
                    <meta itemprop="target" content="#">
                    <div id="barra-ricerca">
                        <input id="barra-ricerca-box" accesskey="s" type="text" name="name" autocomplete="off" spellcheck="false" autocapitalize="off" itemprop="query-input" placeholder="Cerca qui">
                        <input id="barra-ricerca-submit" type="submit" value title="Ricerca">
                    </div>
                </form>
                <div class="menu-container">
                    <div class="menu-main">
                    </div>
                    <a href="javascript:void(null)" for="menu-dropdown" id="menu-button" class="menu-button" title="Menu Utente">
                    </a>
                    <div class="submenu-container">
                        <div class="login login-content">
                            <div class="user-submenu"></div>
                            <a href="#loginregister" id="sign-link" style="display: none"></a>
                            <a class="log-link log-link-profile mostra-box" href="#login">Account</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-container">
            <div id="banner">
                <a href="#linkgioco">
                    <img src="img/banner.jfif" alt="BATTLEFIELD 2042">
                    <span class="prezzo">54.99$</span>
                </a>
            </div>
            <div class="content main-cat">
                <div class="pannello-centrale">
                    <div class="titolo">
                        <div class="categoria">Ultime Uscite</div>
                        <a class="tutti" href="#">Guarda Tutti</a>
                    </div>
                    <div class="catalogo">
                        <div class="item">
                            <a class="cover" href="#" title="Battlefield">
                                <div class="badge"></div>
                                <img class="picture mainshadow" src="img/bfv_src.png" alt="Battlefield V" onload="lazyLoadImage(this)">
                                <div class="shadow">
                                    <div class="prezzo">69.90$</div>
                                </div>
                            </a>
                            <div class="nome">Battlefield V</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-container">
            <div class="footer">
                <div class="content">
                    <div class="informative">
                        <a class="links" href="#">Informativa Privacy</a>
                        <a class="links" href="#">Contatti</a>
                    </div>
                    <div class="copyright">
                        <div id="payment-type">
                            <img src="icon/loghi.png">
                            <div class="payment-paypal">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>