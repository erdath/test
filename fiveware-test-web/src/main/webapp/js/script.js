$(document).ready(function() {
	$("#btn-adicionar-usuario").click(function() {
		if ($("#chk-aceitar").prop("checked") == true) {
			$.ajax({
				url : 'adicionarUsuario',
				type : 'post',
				data : $("#form-inserir-usuario").serialize(),
				success : function(response) {
					$("#msg-resposta").text(response);
				},
				error : function(response) {
				}
			});
		} else {
			$("#msg-resposta").text("É necessario aceitar os termos");
		}
	});
});