<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
teste ${error}
<c:choose>
	<c:when test="${error} eq null">
		Usuario cadastrado com sucesso
	</c:when>
	<c:otherwise>
		${error}
	</c:otherwise>
</c:choose>

