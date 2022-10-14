var host = "http://localhost:8081/api";

function mostrarInformacionCli() {
    $.ajax({
        url: host + '/Client/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            tablaRespuestaCli(respuesta);
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
    mostrarInformacionCli();
})

function tablaRespuestaCli(items) {
    let myTableCli = `<table BORDER CELLPADDING=2 BORDERCOLOR='#7c65b1'><th scope='col'> ID </th><th> EMAIL </th><th> FULL NAME </th><th> AGE </th>`;
    for (let i = 0; i < items.length; i++) {
        myTableCli += `<tr>`;
        myTableCli += `<td>${items[i].idClient}</td>`;
        myTableCli += `<td>${items[i].email}</td>`;
        myTableCli += `<td>${items[i].name}</td>`;
        myTableCli += `<td>${items[i].age}</td>`;
        myTableCli += `<td> <button onclick="finishActuCli('${items[i].email}','${items[i].password}','${items[i].name}', ${items[i].age} )" style="background-color:#7c65b1; border-color:#563856; color:white;">Change</button></td>`;
        myTableCli += `<td> <button onclick="borrarInformacionCli(${items[i].idClient})" style="background-color:#7c65b1; border-color:#563856; color:white;">Delete</button></td>`;
        myTableCli += `</tr>`;
    }
    $("#resultadoCli").append(myTableCli);
    myTableCli = `</table>`;
}

function agregarInformacionCli() {
    $.ajax({
        type: "POST",
        url: host + '/Client/save',
        data: JSON.stringify({
            idClient: $("#idClient").val(),
            name: $("#nameCli").val(),
            email: $("#emailCli").val(),
            age: $("#ageCli").val(),
        }),
        contentType: "application/json"
    }).done(function (data) {
        $("#resultadoCli").empty();
        $("#idClient").val("");
        $("#nameCli").val("");
        $("#emailCli").val("");
        $("#ageCli").val("");
        mostrarInformacionCli();
        alert("Elementos de cliente agregados");//imprimimos respuesta
    }).fail(function (e) {
        alert("Algo salió mal");
    });
}

function finishActuCli(id, email, password, name, age) {
    $("#idCli").val(id);
    $("#emailCli").val(email);
    $("#nameCli").val(name);
    $("#ageCli").val(age);
}

function actualizarInformacionCli() {
    $.ajax({
        method: 'PUT',
        url: host + '/Client/update',
        data: JSON.stringify({
            idClient: $("#idClient").val(),
            email: $("#emailCli").val(),
            password: $("#passwordCli").val(),
            name: $("#nameCli").val(),
            age: $("#ageCli").val(),
        }),
        contentType: "application/JSON"
    }).done(function (data) {
        $("#resultadoCli").empty();
        $("#idClient").val("");
        $("#emailCli").val("");
        $("#passwordCli").val();
        $("#nameCli").val("");
        $("#ageCli").val("");
        mostrarInformacionCli();
        alert("Elementos de cliente actualizados");//imprimimos respuesta
    }).fail(function (e) {
        console.log(e);
        alert("Algo salió mal");
    });
}

function borrarInformacionCli(id) {
    $.ajax({
        method: 'DELETE',
        url: host + '/Client/' + id,
        contentType: "application/json",
        success: function (data) {
            $("#resultadoCli").empty();
            alert("Elementos de cliente se han eliminado");//imprimimos respuesta
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }, complete: function () {
            mostrarInformacionCli();
        }
    });
}