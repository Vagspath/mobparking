<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="parking LIST" />
    <c:param name="body">
     
      <img src="${pageContext.request.contextPath}/resources/img/car.jpg" alt="car" >
        <table
            class="table table-striped table-bordered table-condensed">
            <tr>
                <th>Αύξων αριθμός Parking</th>
                <th>Διάρκεια</th>
                <th>Χρόνος εισόδου</th>
                <th>Χρόνος εξόδου</th>
                 <th>Πελάτης</th>
                 <th>Πινακίδες</th>
                 <th>Κόστος</th>
                 <th>Πληρώθηκε</th>
                <th>&nbsp;</th>
                 <th>&nbsp;</th>
                  <th>&nbsp;</th>
            </tr>
            <c:forEach items="${page.content}" var="parking">
           
                <tr>
                    <td>${f:h(parking.parkingId)}</td>
                    <td>${f:h(parking.duration)}</td>
                    <td>${f:h(parking.timeOfEntrance)}</td>
                    <td>${f:h(parking.timeOfExit)}</td>
                    <td>${f:h(parking.customer)}</td>
                    <td>${f:h(parking.carLicence)}</td>
                    <td>${f:h(parking.cost)}</td>
                    <td>${f:h(parking.payed)}</td>
                    <td><a
                        href='${pageContext.request.contextPath}/parking/delete/${parking.parkingId}'
                        class="btn">Διαγραφή</a></td>
                     <td><a
                        href='${pageContext.request.contextPath}/parking/edit/${parking.parkingId}'
                        class="btn">Διόρθωση</a></td>
                    <td><a
                        href='${pageContext.request.contextPath}/parking/complete/${parking.parkingId}'
                        class="btn">Ολοκλήρωση</a></td>
                </tr>
            </c:forEach>
        </table>

        <p>${f:h(page.number + 1)}/${f:h(page.totalPages)}</p>
  
    </c:param>
</c:import>

