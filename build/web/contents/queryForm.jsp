<%@page import="java.util.ArrayList"%>
<%@page import="DTO.SodatDTO"%>
<h2>Consulta Libro</h2>
<label for="txtEditor">Seleccione Editorial:</label>
 <select id="txtEditor" name="editor">
    <option>Test1</option>
    <option>Test2</option>
    <option>Test3</option>
</select>
<button>
    Buscar
</button>
<table>
    <tr>
        <th>Título</th>
        <th>Autor</th>
        <th>Editorial</th>
        <th>Precio</th>
        <th>Acción</th>
    </tr>
    <% 
        ArrayList<Soda> sodas = request.getAttribute("sodas") != null ?
                (ArrayList<Soda>)request.getAttribute("sodas") : 
                new ArrayList<Soda>();
        for(Soda soda : sodas) {               
    %>
    <tr>
        <td><%= sodas.getName() %></td>
        <td><%= sodas.getCompany()%></td>
        <td><%= sodas.getQuantity() %></td>
        <td><%= sodas.getPrice() %></td>
        <td>Eliminar</td>
    </tr>
    <% } %>
</table>
 