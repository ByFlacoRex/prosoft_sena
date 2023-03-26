// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
  });
  
  async function registrarAspirantes() {
    
    let datos = {};

    datos.nombre = document.getElementById('txtnombre').value;
    datos.apellido = document.getElementById('txtapellido').value;
    datos.documentos = document.getElementById('txtTipoDocumento').value;
    datos.documento = document.getElementById('txtdocumento').value;
    datos.telefono = document.getElementById('txttelefono').value;
    datos.email = document.getElementById('txtemail').value;
 
      const request = await fetch('api/aspirantes', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });

      alert('El usuario se registro correctamente.');
      location.reload()

  }