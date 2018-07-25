<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
	<head>
	<title>Java Spring</title>
	</head>
	<body>
		<h2>Desafio Java - Cadastro de Usuário</h2>
		
		<form:form method="POST" action="/DesafioJava/usuarios/novoUsuario" modelAttribute="user">
		
			<table>
                <tr>
                    <td><form:label path="nome">Nome</form:label></td>
                    <td><form:input path="nome"/></td>
                </tr>
                <tr>
                    <td><form:label path="sobrenome">Sobrenome:</form:label></td>
                    <td><form:input path="sobrenome"/></td>
                </tr>
                <tr>
                    <td><form:label path="username">
                      Nome de usuário:</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Senha:</form:label></td>
                    <td><form:input type="password" path="password"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email:</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="telefone">Telefone:</form:label></td>
                    <td><form:input path="telefone"/></td>
                </tr>
                <tr>
                    <input type="radio" name="isEnabled" value="1" /> Ativo <br>
	  				<input type="radio" name="isEnabled" value="0" /> Inativo <br>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
            
            
			<!-- <label for="telefone">Telefone:</label>
			<input type="text" id="telefone" name="telefone" />
			</p>
			<input type="radio" name="isEnabled" value="ativo"> Ativo<br>
	  		<input type="radio" name="isEnabled" value="inativo"> Inativo<br>
	  		</p> 
	  		
			<input type="submit" value="Salvar"> -->
			
		</form:form>
	</body>
</html>