<h2>Ingreso producto</h2>

<form id="add" method="post">
    <label for="txtName">Nombre:</label>
    <input type="text" name="name" id="txtName" required/>
    <br/>    <br/>
    <label for="txtCompany">Empresa:</label>
    <input type="text" name="company" required id="txtCompany"/>
    <br/>    <br/>
    <label for="txtQuantity">Unidades a ingresar:</label>
    <input type="number" min="0" name="quantity" required id="txtQuantity"/>
    <br/>    <br/>
    <label for="txtPrice">Precio unitario:</label>
    <input type="number" min="0" name="price" required id="txtPrice"/>
    <br/>    <br/>
    <button>Guardar producto</button>
</form>