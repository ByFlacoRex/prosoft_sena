$(document).ready(function() {
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario(){
  document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}