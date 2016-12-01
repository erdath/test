<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style/bootstrap/css/bootstrap.min.css">
<script src="js/jquery/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/script.js"></script>
</head>
<body>
<div style="margin: auto; margin-top: 20px;width: 700px">
	<form id="form-inserir-usuario" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="txt-nome" class="col-sm-3 control-label">Nome</label>
			<div class="col-sm-9">
				<input type="text" name="nome" id="txt-nome" class="form-control" placeholder="nome">
			</div>
		</div>
		<div class="form-group">
			<label for="txt-data" class="col-sm-3 control-label">Data Nascimento</label>
			<div class="col-sm-9">
				<input type="date" name="dataNascimento" id="txt-nome" class="form-control" placeholder="dd/mm/aaaa">
			</div>
		</div>
		<div class="form-group">
			<label for="txt-telefone" class="col-sm-3 control-label">Telefone</label>
			<div class="col-sm-9">
				<input type="text" name="telefone" id="txt-telefone" class="form-control" placeholder="Telefone">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-9 col-sm-offset-3">
				<div class="radio">
					<label class="checkbox-inline">
						<input type="radio" name="sexo" id="rdo-sexo-masculino" value="M"> Masculino
					</label>
					<label class="checkbox-inline">
						<input type="radio" name="sexo" id="rdo-sexo-feminino" value="F"> Feminino
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="txt-telefone" class="col-sm-3 control-label">Estado Civil</label>
			<div class="col-sm-9">
				<select class="form-control" name="usuarioEstadoCivil" id="slc-estado-civil">
					<c:forEach items="${estadoCivil}" var="e">
						<option value="${e.id}">${e.nome}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-9 col-sm-offset-3">
				<div class="checkbox">
					<label> 
						<input type="checkbox" id="chk-aceitar"> Li e aceito Termo de condições.
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-3 col-sm-offset-2" style="text-align: right">
				<input type="button" id="btn-adicionar-usuario" class="btn btn-default" value="Cadastrar">
 			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-9 col-sm-offset-3">
				<label id="msg-resposta"></label>
			</div>
		</div>
	</form>
</div>
</body>
</html>