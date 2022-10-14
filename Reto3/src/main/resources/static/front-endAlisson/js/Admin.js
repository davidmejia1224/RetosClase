var host = "http://localhost:8080/api";

function mostrarInformacionAdmin() {
    $.ajax({
        url: host + '/Admin/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            tablaRespuestaAdmin(respuesta);
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
}

$(document).ready(function () {
    mostrarInformacionAdmin();
})

function tablaRespuestaAdmin(items) {
    let myTableAdmin = `<table class="container_tabla_admin"> <class="thadmin"> <th scope='col'> ID </th><th> EMAIL </th><th> FULL NAME </th><th> PASSWORD  </th>`;
    for (let i = 0; i < items.length; i++) {
        myTableAdmin += `<tr>`;
        myTableAdmin += `<td>${items[i].id}</td>`;
        myTableAdmin += `<td>${items[i].name}</td>`;
        myTableAdmin += `<td>${items[i].email}</td>`;
        myTableAdmin += `<td>${items[i].password}</td>`;
        myTableAdmin += `<td> <button onclick="finishActuAdmin( '${items[i].name}', '${items[i].email}','${items[i].password}')" class="button_admin">Change</button></td>`;
        myTableAdmin += `<td> <button onclick="borrarInformacionAdmin(${items[i].id})" class="button_admin">Delete</button></td>`;
        myTableAdmin += `</tr>`;
    }
    $("#resultadoAdmin").append(myTableAdmin);
    myTableAdmin = `</table>`;
}

function agregarInformacionAdmin() {
    $.ajax({
        type: "POST",
        url: host + '/Admin/save',
        data: JSON.stringify({
            id: $("#idAdmin").val(),
            name: $("#nameAdmin").val(),
            email: $("#emailAdmin").val(),
            password: $("#password").val(),
        }),
        contentType: "application/json"
    }).done(function (data) {
        $("#resultadoAdmin").empty();
        $("#idAdmin").val("");
        $("#nameAdmin").val("");
        $("#emailAdmin").val("");
        $("#passwordAdmin").val("");
        mostrarInformacionAdmin();
        alert("Elementos de administrador agregados");//imprimimos respuesta
    }).fail(function (e) {
        alert("Algo salió mal");
    });
}

function finishActuAdmin( name, email, password) {
    $("#nameAdmin").val(name);
    $("#emailAdmin").val(email);
    $("#passwordAdmin").val(password);
}

function actualizarInformacionAdmin() {
    $.ajax({
        method: 'PUT',
        url: host + '/Admin/update',
        data: JSON.stringify({
            id: $("#idAdmin").val(),
            name: $("#nameAdmin").val(),
            email: $("#emailAdmin").val(),
            password: $("#passwordAdmin").val(),
        }),
        contentType: "application/JSON"
    }).done(function (data) {
        $("#resultadoAdmin").empty();
        $("#emailAdmin").val("");
        $("#passwordAdmin").val();
        $("#nameAdmin").val("");
        $("#ageAdmin").val("");
        mostrarInformacionAdmin();
        alert("Elementos de administrador actualizados");//imprimimos respuesta
    }).fail(function (e) {
        console.log(e);
        alert("Algo salió mal");
    });
}

function borrarInformacionAdmin(id) {
    $.ajax({
        method: 'DELETE',
        url: host + '/Admin/' + id,
        contentType: "application/json",
        success: function (data) {
            $("#resultadoAdmin").empty();
            alert("Elementos de administrador se han eliminado");//imprimimos respuesta
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }, complete: function () {
            mostrarInformacionAdmin();
        }
    });
}