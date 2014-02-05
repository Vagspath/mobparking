<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="HOME" />
    <c:param name="body">
        <h2>Καλώς ήρθατε στο σύστημα mobile parking</h2>
        <p>
           <br>
           <br>
        </p>
        <ul>
            <li><a href='${pageContext.request.contextPath}/parking/list/'>Parking
                    LIST</a></li>
            <li><a href='${pageContext.request.contextPath}/parking/form/'>Parking
                    CREATE</a></li>
        </ul>
    </c:param>
</c:import>

