<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="currentid" required="true" type="java.lang.String" %>
  <script>
  $( function() {
    $( "#${currentid}" ).datepicker({
      numberOfMonths: 3,
      showButtonPanel: true
    });
  } );
  </script>
 
<p>Date: <input type="text" id="${currentid}"></p>
 
 
