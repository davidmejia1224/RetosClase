var host = "http://localhost:8081/api";

function mostrarInformacionMes() {
    $.ajax({
        url: host + '/Message/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            tablaRespuestaMes(respuesta);
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
    mostrarInformacionMes();
})

function tablaRespuestaMes(items) {
    let myTableMes = `<table BORDER CELLPADDING=2 BORDERCOLOR='#7c65b1'><th scope='col'> MESSAGE </th><th>DOCTOR</th><th>CLIENT</th>`;
    for (let i = 0; i < items.length; i++) {
        myTableMes += `<tr>`;
        myTableMes += `<td>${items[i].messagetext}</td>`;
        myTableMes += `<td>${items[i].doctor.name}</td>`;
        myTableMes += `<td>${items[i].client}</td>`;
        myTableMes += `<td> <button onclick="finishActuMes('${items[i].messagetext}')" style="background-color:#7c65b1; border-color:#563856; color:white;">Change</button></td>`;
        myTableMes += `<td> <button onclick="borrarInformacionMes(${items[i].idMessage})" style="background-color:#7c65b1; border-color:#563856; color:white;">Delete</button>`;
        myTableMes += `</tr>`;

    }
    for (let j = 0; j < items.length; j++){
        console.log(items[j].idMessage)
        const element = items[j];
        $('#client').append(`<option value="${element.client.id}">${element.client.name}</option>`);
        $("#client").val("");
        $('#doctor').append(`<option value="${element.doctor.id}">${element.doctor.name}</option>`);
        $("#doctor").val("");
    }
    $("#resultadoMes").append(myTableMes);
    myTableMes = `</table>`;
}

function agregarInformacionMes() {
    $.ajax({
        type: "POST",
        url: host + "/Message/save",
        data: JSON.stringify({
            idMessage: $("#").val(),
            messagetext: $("#messagetext").val(),
            client: $("#client").val(),
            doctor: $("#doctor").val(),
        }),
        contentType: "application/json"
    }).done(function (data) {
        $("#resultadoMes").empty();
        $("#messagetext").val("");
        $("#client").val("");
        $("#doctor").val("");
        mostrarInformacionMes();
        alert("Elementos de mensaje agregados");//imprimimos respuesta
    }).fail(function (e) {
        alert("Algo salió mal");
    });
}

function finishActuMes(messagetext, doctor, client) {
    $("#messagetext").val(messagetext);
    $("#client").val(client);
    $("#doctor").val(doctor);
}

function actualizarInformacionMes() {
    $.ajax({
        method: 'PUT',
        url: host + '/Message/update',
        data: JSON.stringify({
            messagetext: $("#messagetext").val(),
            client: $("#client").val(),
            doctor: $("#doctor").val(),
        }),
        contentType: "application/JSON"
    }).done(function (data) {
        $("#resultadoMes").empty();
        $("#messagetext").val("");
        $("#client").val("");
        $("#doctor").val("");
        mostrarInformacionMes();
        alert("Elementos de mensaje actualizados");//imprimimos respuesta
    }).fail(function (e) {
        console.log(e);
        alert("Algo salió mal");
    });
}

function borrarInformacionMes(id) {
    $.ajax({
        method: 'DELETE',
        url: host + 'Message/' + id,
        contentType: "application/json",
        success: function (data) {
            $("#resultadoMes").empty();
            alert("Elementos de mensaje se han eliminado");//imprimimos respuesta
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }, complete: function () {
            mostrarInformacionMes();
        }
    });
}