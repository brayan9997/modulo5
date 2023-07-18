$(document).ready(function() {
        $("#tipo").change(function() {
            var tipoUsuario = $(this).val();
            
            // Ocultar todos los campos adicionales
            $(".campos-adicionales").hide();
            
            // Mostrar los campos adicionales correspondientes al tipo de usuario seleccionado
            $("#campos" + tipoUsuario).show();
        });
        
        // Mostrar los campos adicionales iniciales según el tipo de usuario seleccionado al cargar la página
        var tipoUsuarioInicial = $("#tipo").val();
        $("#campos" + tipoUsuarioInicial).show();
    });