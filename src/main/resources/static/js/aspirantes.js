// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarAspirantes();
  $('#aspirantes').DataTable();
  actualizarEmailDelUsuario();

});

  function actualizarEmailDelUsuario(){
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email
  }

async function cargarAspirantes() {

    const request = await fetch('api/aspirantes', {
      method: 'GET',
      headers: getHeaders()
    });
    const aspirantes = await request.json();

    

    let listadoHtml = '';
    for (let aspirante of aspirantes) {

      let botonEliminar = '<a href="#" onclick="eliminarAspirante('+aspirante.id+')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i> </a>';
      
      let aspiranteHtml = '<tr><td> '+ aspirante.id +'</td> <td>'+ aspirante.nombre +' '+ aspirante.apellido +'</td> <td>'
      + aspirante.documentos +'</td> <td>'+ aspirante.documento +'</td> <td>'
      + aspirante.telefono +'</td> <td>'+ aspirante.email +'</td> <td> '+botonEliminar+' </td> </tr>';
      
      listadoHtml += aspiranteHtml;
    }
    
    document.querySelector('#aspirantes tbody').outerHTML = listadoHtml;

}


function getHeaders(){
  return{
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token
  };
}


async function eliminarAspirante(id){

  if(!confirm('¿Desea eliminar a este usuario?')){
    return;
  }
  const request = await fetch('api/aspirantes/' +id, {
    method: 'DELETE',
    headers: getHeaders()
  });

  location.reload()

}