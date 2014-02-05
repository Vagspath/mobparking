<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="New Parking REQUEST FORM" />
    <c:param name="body">
        <spring:hasBindErrors name="parking">
            <script type="text/javascript">
                $(document).ready(function() {
                    $("div.control-group>div.controls>.error").parent().parent().addClass("error");
                });
            </script>
        </spring:hasBindErrors>
        <form:form method="post" action="." modelAttribute="parking"
            cssClass="form-horizontal">
            <fieldset>
                <legend>parking</legend>
                    <div class="control-group">
                    <label class="control-label" for="duration">Διάρκεια</label>
                    <div class="controls">
                        <form:input path="duration" cssClass="span3"
                            cssErrorClass="error" />
                        <form:errors path="duration"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
             
                         <div class="control-group">
                    <label class="control-label" for="customer">Πελάτης</label>
                    <div class="controls">
                        <form:input path="customer" cssClass="span3"
                            cssErrorClass="error" />
                        <form:errors path="customer"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="carLicence">carLicence</label>
                    <div class="controls">
                        <form:input path="carLicence" cssClass="span5"
                            cssErrorClass="error" />
                        <form:errors path="carLicence"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="cost">ποσό</label>
                    <div class="controls">
                        <form:input path="cost" cssClass="span3"
                            cssErrorClass="error" />
                        <form:errors path="cost"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                
                <form:hidden path="parkingId" />
                <div class="form-actions">
                    <input type="submit" class="btn btn-primary"
                        value="Submit">&nbsp;
                    <button type="reset" class="btn">Cancel</button>
                </div>
            </fieldset>
        </form:form>
        <hr>
        <a href='${pageContext.request.contextPath}/parking/list' class="btn">list</a>
    </c:param>
</c:import>

