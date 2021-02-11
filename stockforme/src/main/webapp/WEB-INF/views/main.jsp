<!DOCTYPE html>
<html>
<head>
<title>Stock&me</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<!--   <div class="topnav">
  <a class="active" href="#home">Home</a>
  <!--  <a href="/stockforme/createuser" target="iframe_a">Créer client</a> 
  <a href="/stockforme/chercher" target="iframe_a">Chercher client</a>
  <a href="/stockforme/creercommande"target="iframe_a">Créer commande</a>
  <a href="/stockforme/searchcommande" target="iframe_a">Chercher commande</a>
  <a href="/stockforme/modifiercommande" target="iframe_a">Modifier commande</a>
  <a href="/stockforme/fournisseur" target="iframe_a">Fournisseur</a>
  <a href="/stockforme/stock" target="iframe_a">Stock</a>
  <a href="#/stockforme/stock" target="iframe_a">Stats</a>
  <a href="/stockforme/login ">Exit</a> -->
<ul>
  <li><a href="#home">Home</a></li>
  <li class="dropdown"> 
  <a href="javascript:void(0)" class="dropbtn">Gestion Produit</a>
  <div class="dropdown-content">
      <a href="/stockforme/createproduct" target="iframe_a">Créer Produit</a>
    </div>
  </li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Gestion Client</a>
    <div class="dropdown-content">
      <a href="/stockforme/createclient" target="iframe_a">Créer client</a>
      <a href="/stockforme/searchclient" target="iframe_a">Chercher client</a>
      <a href="#stockforme/chercher" target="iframe_a">Modifier client</a>
    </div>
    </li>
    <li class="dropdown">
      <a href="javascript:void(0)" class="dropbtn">Gestion Commande</a>
      <div class="dropdown-content">
      <a href="/stockforme/createcommandeview" target="iframe_a">Créer commande</a>
      <a href="/stockforme/searchcommandeview" target="iframe_a">Chercher commande</a>
      <a href="/stockforme/modifycommandeview" target="iframe_a">Modifier commande</a>
      </div>
      </li>
        <li class="dropdown">
       <a href="javascript:void(0)" class="dropbtn">Fournisseur</a>
       <div class="dropdown-content">
        <a href="/stockforme/fournisseur" target="iframe_a">Chercher Fournisseur</a>
        <a href="/stockforme/viewsaveupdate" target="iframe_a">Modifier Fournisseur</a>
       </div>
        </li>
        <li class="dropdown">
        <a href="javascript:void(0)" class="dropbtn">Stock</a>
        <div class="dropdown-content">
        <a href="/stockforme/getstock" target="iframe_a">Etat de Stock</a> 
        <a href="/stockforme/viewupdatestock" target="iframe_a">Mise à jour stock</a> 
        </div>
        </li>
        
        
        <li class="dropdown">
        <a href="javascript:void(0)" class="dropbtn">Stats</a>
      <div class="dropdown-content">
      <a href="/stockforme/CalculCA" target="iframe_a">Chiffre d'affaire par intervalle</a>
      <a href="/stockforme/CalculBenef" target="iframe_a">Bénéfice par intervalle</a>
      </div>
        </li>
        
        <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Rapports</a>
    <div class="dropdown-content">
      <a href="/stockforme/exportpardate" target="iframe_a">Export ventes par date</a>
    </div>
    </li>   
    
       <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Traitement de Masse</a>
    <div class="dropdown-content">
      <a href="/stockforme/uploadproduct" target="iframe_a">Import Produit</a>
      <a href="/stockforme/uploadcommande" target="iframe_a">Import Commande</a>
    </div>
    </li>
        <li><a href="/stockforme/login ">Exit</a></li>
        <li style="float:right"><a class="active" href="#">${welcome}</a></li>
</ul>

<iframe name="iframe_a" height="1000px" width="100%"> </iframe>
</body>
</html>
