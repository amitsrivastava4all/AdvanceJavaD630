<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sj:head  jqueryui="true" jquerytheme="le-frog"/>
<script type="text/javascript">
    $.subscribe('before', function(event,data) {
      var fData = event.originalEvent.formData;
         alert('About to submit: \n\n' + fData[0].value + ' to target '+event.originalEvent.options.target+' with timeout '+event.originalEvent.options.timeout );
      var form = event.originalEvent.form[0];
      if (form.echo.value.length < 2) {
          alert('Please enter a value with min 2 characters');
          // Cancel Submit comes with 1.8.0
          event.originalEvent.options.submit = false;
      }
    });
    $.subscribe('complete', function(event,data) {
         alert('status: ' + event.originalEvent.status + '\n\nresponseText: \n' + event.originalEvent.request.responseText + 
     '\n\nThe output div should have already been updated with the responseText.');
    });
    $.subscribe('errorState', function(event,data) {
        alert('status: ' + event.originalEvent.status + '\n\nrequest status: ' +event.originalEvent.request.status);
    });
    </script>  
</head>
<body>
<s:form id="formValidate" action="loginAC" theme="xhtml">
        <s:textfield 
                id="userid" 
                name="userid" 
                label="User" 
                required="true"
        />
        <s:textfield 
                id="password" 
                name="password" 
                label="Password" 
                required="true"
        />
        <sj:submit  targets="result" 
                                        value="AJAX Submit" 
                                        timeout="2500" 
                                        indicator="indicator" 
                                        onBeforeTopics="before" 
                                        onCompleteTopics="complete" 
                                        onErrorTopics="errorState"  
                                        effect="highlight" 
                                        effectOptions="{ color : '#222222' }" 
                                        effectDuration="3000"/>
    </s:form>
    <img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
    <sj:tabbedpanel id="localtabs" cssClass="list">
                             <sj:tab id="tab1" target="tone" label="Reg"/>
                             <sj:tab id="tab2" target="ttwo" label="Login"/>
                             <sj:tab id="tab3" target="tthree" label="Local Tab Three"/>
                             <sj:tab id="tab4" target="tfour" label="Local Tab Four"/>
                             <div id="tone">
                             This is Reg Page
                             </div>
                             <div id="ttwo">Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor
                                 at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam.
                                 In suscipit faucibus urna.
                             </div>
                             <div id="tthree">Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque
                                 purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo,
                                 magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
                             </div>
                             <div id="tfour">Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis
                                 egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
                                 mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti
                                 sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.
                             </div>
                         </sj:tabbedpanel>
                         
                         <sj:datepicker id="date0" label="Select a Date" numberOfMonths="3"  />
      <sj:datepicker value="%{dateValue}" id="date1" name="date1" label="Date Value from Action" />
      <sj:datepicker id="date2" name="nameValue" label="Date Value by Name" />
      <sj:datepicker value="today" id="date3" name="date3" displayFormat="dd.mm.yy" label="Today" />
      <sj:datepicker value="yesterday" id="date4" name="date4" displayFormat="mm/dd/yy" label="Yesterday" />
      <sj:datepicker value="tomorrow" id="date5" name="date5" displayFormat="DD, d MM yy" label="Tomorrow" />
      <sj:datepicker value="2004-08-14" id="date6" name="date6" displayFormat="d M, yy" label="String Value" />
      
      <sj:dialog id="mydialog1" title="Local Dialog" autoOpen="false">
     Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
   </sj:dialog>
   <sj:a openDialog="mydialog1">Open Dialog</sj:a>
   <sj:a  
                 openDialog="mydialog1"
                targets="result" 
                indicator="indicator" 
                button="true" 
                buttonIcon="ui-icon-refresh"
        >
                Run AJAX Action
        </sj:a>
 
</body>
</html>