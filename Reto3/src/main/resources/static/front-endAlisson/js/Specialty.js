var host = "http://localhost:8081/api";

function mostrarInformacionSpe() {
    $.ajax({
        url: host + '/Specialty/all',
        type: 'GET',
        dataType: "JSON",
        success: function (respuesta) {
            tableRespuestaSpe(respuesta);
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }
    });
}

$(document).ready(function () {
    mostrarInformacionSpe();
})

function tableRespuestaSpe(items) {
    let myTableSpe = `<table BORDER CELLPADDING=2 BORDERCOLOR='#7c65b1'><th scope='col'> FULL NAME </th><th> DESCRIPTION </th><th> DOCTOR </th>`;
    for (let i = 0; i < items.length; i++) {
        myTableSpe += `<tr>`;
        myTableSpe += `<td>${items[i].name}</td>`;
        myTableSpe += `<td>${items[i].description}</td>`;
        myTableSpe += `<td>${items[i].doctors[1]}</td>`;
        myTableSpe += `<td> <button onclick="finishActuSpe(${items[i].id},'${items[i].name}', '${items[i].description}')" style="background-color:#7c65b1; border-color:#563856; color:white;">Change</button></td>`;
        myTableSpe += `<td> <button onclick="borrarInformacionSpe(${items[i].id})" style="background-color:#7c65b1; border-color:#563856; color:white;">Delete</button></td>`;
        myTableSpe += `</tr>`;
        
    }
    $("#resultadoSpe").append(myTableSpe);
    myTableSpe = `</table>`;
}

function agregarInformacionSpe() {
    $.ajax({
        type: "POST",
        url: host + "/Specialty/save",
        data: JSON.stringify({
            id: $("#idSpe").val(),
            name: $("#nameSpe").val(),
            doctor: $("#doctor").val(),
            description: $("#description").val(),
        }),
        contentType: "application/json"
    }).done(function (data) {
        $("#resultadoSpe").empty();
        $("#nameSpe").val("");
        $("#doctor").val("");
        $("#description").val("");
        mostrarInformacionSpe();
        alert("Elementos de Specialty agregados");//imprimimos respuesta
    }).fail(function (e) {
        alert("Algo salió mal");
    });
}

function finishActuSpe(id, name, description) {
    $("#idSpe").val(id);
    $("#nameSpe").val(name);
    $("#description").val(description);
}

function actualizarInformacionSpe() {

    $.ajax({
        method: 'PUT',
        url: host + '/Specialty/update',
        data: JSON.stringify({
            id: $("#idSpe").val(),
            name: $("#nameSpe").val(),
            doctor: $("#doctor").val(),
            description: $("#description").val(),
        }),
        contentType: "application/JSON",
    }).done(function (data) {
        console.log(data);
        $("#resultadoSpe").empty();
        $("#nameSpe").val("");
        $("#doctor").val("");
        $("#description").val("");
        mostrarInformacionSpe();
        alert("Elementos de Specialty actualizados");//imprimimos respuesta
    }).fail(function (e) {
        console.log(e);
        alert("Algo salió mal");
    });

}

function borrarInformacionSpe(id) {
    $.ajax({
        method: 'DELETE',
        url: host + '/Specialty/' + id,
        contentType: "application/JSON",
        success: function (data) {
            console.log(data);
            $("#resultadoSpe").empty();
            alert("Elementos de Specialty se han eliminado");//imprimimos respuesta
        }, error: function (e) {
            console.log(e);
            alert("Algo salió mal");
        }, complete: function () {
            mostrarInformacionSpe();
        }
    });
}