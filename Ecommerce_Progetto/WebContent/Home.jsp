<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>VGHUB</title>
        <link rel="stylesheet" href="stile.css">
    </head>
    <body>
        <script>
            function changeCss () {
            var bodyElement = document.querySelector("body");
            var sfondo = document.getElementById("background-banner");
            this.scrollY > 80 ? sfondo.style.position = "fixed" : sfondo.style.position = "absolute";
            this.scrollY > 80 ? sfondo.style.top = "0px" : sfondo.style.top = "80px";
        }
        window.addEventListener("scroll", changeCss , false);
        </script>
        <a href="#" id="background-banner"></a>
        <div id="header" class="header-container">
            <div class="content navbar">
                <a id="logo" class="logo" title="VGHUB" href="#HOME"></a>
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
                            <a class="log-link log-link-profile mostra-box" href="#login">Account</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-container">
            <div id="banner">
                <a href="#linkgioco">
                    <img src="img/background-1.jpg" alt="BATTLEFIELD 2042">
                    <span class="prezzo">54.99$</span>
                </a>
            </div>
            <div class="content main-cat ombre">
                <div class="pannello-centrale">
                    <div class="titolo">
                        <div class="categoria">Ultime Uscite</div>
                        <a class="tutti" href="#">Guarda Tutti</a>
                    </div>
                    <div class="catalogo">
                        <div class="item">
                            <a class="cover" href="#" title="Battlefield">
                                <div class="badge playstation"></div>
                                <img class="picture ombre" src="img/battlefield-5-cover.jpg" alt="Battlefield V" onload="lazyLoadImage(this)">
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
                        <div class="payment-container">
                            <div id="licensa">VGHUB © 2021</div>
                        </div>
                        <div id="payment-type">
                            <img class="visa" src="icon/visa-logo.png">
                            <div class="payment-paypal">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>